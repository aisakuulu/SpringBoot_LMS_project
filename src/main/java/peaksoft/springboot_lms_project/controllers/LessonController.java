package peaksoft.springboot_lms_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import peaksoft.springboot_lms_project.entities.Course;
import peaksoft.springboot_lms_project.entities.Lesson;
import peaksoft.springboot_lms_project.service.CourseService;
import peaksoft.springboot_lms_project.service.LessonService;

import java.util.List;

@Controller
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;
    private final CourseService courseService;

    public LessonController(LessonService lessonService, CourseService courseService) {
        this.lessonService = lessonService;
        this.courseService = courseService;
    }

    @RequestMapping("/showLessons")
    public String showAllLessons(Model model){
        List<Lesson> lessons = lessonService.getAllLessons();
        model.addAttribute("lessonsAtr", lessons);
        return "lessons-show";
    }

    @RequestMapping("/new")
    public String displayLessonForm(Model model){
        List<Course> courseList = courseService.getAllCourse();
        Lesson lesson = new Lesson();
        model.addAttribute("newLessonAtr", lesson);
        model.addAttribute("courseListAtr", courseList);
        return "lesson-form";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNewLesson(@ModelAttribute("newLessonAtr") Lesson lesson){
        lessonService.save(lesson);
        return "redirect:/lessons/showLessons";
    }

    @RequestMapping("/edit/{id}")
    public String displayLessonEditForm(@PathVariable("id") Long id, Model model){
        Lesson lesson = lessonService.getById(id);
        model.addAttribute("newLessonAtr", lesson);
        List<Course> courseList = courseService.getAllCourse();
        model.addAttribute("courseListAtr", courseList);
        return "lesson-form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteLesson(@PathVariable("id") Long id){
        lessonService.delete(id);
        return "redirect:/lessons/showLessons";
    }

}

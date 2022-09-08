package peaksoft.springboot_lms_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import peaksoft.springboot_lms_project.entities.Company;
import peaksoft.springboot_lms_project.entities.Course;
import peaksoft.springboot_lms_project.service.CompanyService;
import peaksoft.springboot_lms_project.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final CompanyService companyService;

    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }


    @RequestMapping("/showCourses")
    public String showAllCourses(Model model){
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("coursesAtr", courses);
        return "show-courses";
    }

    @RequestMapping("/new")
    public String displayCourseForm(Model model){
        List<Company> companyList = companyService.getAllCompany();
        Course course = new Course();
        model.addAttribute("newCourseAtr", course);
        model.addAttribute("companyListAtr", companyList);
        return "course-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNewCourse(@ModelAttribute("newCourseAtr") Course course){
        courseService.save(course);
        return "redirect:/courses/showCourses";
    }

    @RequestMapping("/edit/{id}")
    public String displayCourseEditForm(@PathVariable("id") Long id, Model model){
        Course course = courseService.getById(id);
        model.addAttribute("newCourseAtr", course);
        List<Company> companyList = companyService.getAllCompany();
        model.addAttribute("companyListAtr", companyList);
        return "course-form";
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.POST)
    public String updatedCourse(@ModelAttribute("courseInfo") Course course,
                                 @PathVariable("id") Long id){
        courseService.updateCourse(id, course);
        return "redirect:/courses/showCourses";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteCourse(@PathVariable("id") Long id){
        courseService.delete(id);
        return "redirect:/courses/showCourses";
    }
}

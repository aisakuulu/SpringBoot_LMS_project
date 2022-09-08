package peaksoft.springboot_lms_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import peaksoft.springboot_lms_project.entities.*;
import peaksoft.springboot_lms_project.service.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final LessonService lessonService;
    private final TaskService taskService;

    public TaskController(LessonService lessonService, TaskService taskService) {
        this.lessonService = lessonService;
        this.taskService = taskService;
    }


    @RequestMapping("/showTasks")
    public String showAllStudents(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasksAtr", tasks);
        return "show-tasks";
    }

    @RequestMapping("/new")
    public String displayTaskForm(Model model){

        List<Lesson> lessonList = lessonService.getAllLessons();
        Task task = new Task();
        model.addAttribute("newTaskAtr", task);
        model.addAttribute("lessonListAtr", lessonList);
        return "task-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNewStudent(@ModelAttribute("newTaskAtr") Task task){
        taskService.save(task);
        return "redirect:/tasks/showTasks";
    }

    @RequestMapping("/edit/{id}")
    public String displayInstructorEditForm(@PathVariable("id") Long id, Model model){
        Task task = taskService.getById(id);
        model.addAttribute("newTaskAtr", task);
        List<Lesson> lessonList = lessonService.getAllLessons();
        model.addAttribute("lessonListAtr", lessonList);
        return "task-form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteTask(@PathVariable("id") Long id){
        taskService.delete(id);
        return "redirect:/tasks/showTasks";
    }

}

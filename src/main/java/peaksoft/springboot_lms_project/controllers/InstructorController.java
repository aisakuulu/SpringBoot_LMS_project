package peaksoft.springboot_lms_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import peaksoft.springboot_lms_project.entities.Company;
import peaksoft.springboot_lms_project.entities.Course;
import peaksoft.springboot_lms_project.entities.Instructor;
import peaksoft.springboot_lms_project.service.CompanyService;
import peaksoft.springboot_lms_project.service.CourseService;
import peaksoft.springboot_lms_project.service.InstructorService;

import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;
    private final CompanyService companyService;
    private final CourseService courseService;

    public InstructorController(InstructorService instructorService, CompanyService companyService, CourseService courseService) {
        this.instructorService = instructorService;
        this.companyService = companyService;
        this.courseService = courseService;
    }

    @RequestMapping("/showInstructors")
    public String showAllInstructors(Model model){
        List<Instructor> instructors = instructorService.getAllInstructor();
        model.addAttribute("instructorAtr", instructors);
        return "show-instructors";
    }

    @RequestMapping("/new")
    public String displayInstructorForm(Model model){
        List<Company> companyList = companyService.getAllCompany();
        List<Course> courseList = courseService.getAllCourse();
        Instructor instructor = new Instructor();
        model.addAttribute("newInstructorAtr", instructor);
        model.addAttribute("companyListAtr", companyList);
        model.addAttribute("courseListAtr", courseList);
        return "instructor-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNewInstructor(@ModelAttribute("newInstructorAtr") Instructor instructor){
        instructorService.save(instructor);
        return "redirect:/instructors/showInstructors";
    }

    @RequestMapping("/edit/{id}")
    public String displayInstructorEditForm(@PathVariable("id") Long id, Model model){
        Instructor instructor = instructorService.getById(id);
        model.addAttribute("newInstructorAtr", instructor);
        List<Company> companyList = companyService.getAllCompany();
        model.addAttribute("companyListAtr", companyList);
        List<Course> courseList = courseService.getAllCourse();
        model.addAttribute("courseListAtr", courseList);
        return "instructor-form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteInstructor(@PathVariable("id") Long id){
        instructorService.delete(id);
        return "redirect:/instructors/showInstructors";
    }
}

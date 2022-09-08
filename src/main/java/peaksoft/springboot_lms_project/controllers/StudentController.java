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
import peaksoft.springboot_lms_project.entities.Student;
import peaksoft.springboot_lms_project.service.CompanyService;
import peaksoft.springboot_lms_project.service.CourseService;
import peaksoft.springboot_lms_project.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;
    private final CompanyService companyService;

    public StudentController(StudentService studentService, CourseService courseService, CompanyService companyService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @RequestMapping("/showStudents")
    public String showAllStudents(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("studentsAtr", students);
        return "show-students";
    }

    @RequestMapping("/new")
    public String displayStudentForm(Model model){
        List<Company> companyList = companyService.getAllCompany();
        List<Course> courseList = courseService.getAllCourse();
        Student student = new Student();
        model.addAttribute("newStudentAtr", student);
        model.addAttribute("companyListAtr", companyList);
        model.addAttribute("courseListAtr", courseList);
        return "student-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNewStudent(@ModelAttribute("newStudentAtr") Student student){
        studentService.save(student);
        return "redirect:/students/showStudents";
    }

    @RequestMapping("/edit/{id}")
    public String displayInstructorEditForm(@PathVariable("id") Long id, Model model){
        Student student = studentService.getById(id);
        model.addAttribute("newStudentAtr", student);
        List<Company> companyList = companyService.getAllCompany();
        model.addAttribute("companyListAtr", companyList);
        List<Course> courseList = courseService.getAllCourse();
        model.addAttribute("courseListAtr", courseList);
        return "student-form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteInstructor(@PathVariable("id") Long id){
        studentService.delete(id);
        return "redirect:/students/showStudents";
    }

}

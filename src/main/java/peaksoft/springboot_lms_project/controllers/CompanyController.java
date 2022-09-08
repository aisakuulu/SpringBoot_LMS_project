package peaksoft.springboot_lms_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import peaksoft.springboot_lms_project.entities.Company;
import peaksoft.springboot_lms_project.entities.Course;
import peaksoft.springboot_lms_project.entities.Student;
import peaksoft.springboot_lms_project.service.CompanyService;
import peaksoft.springboot_lms_project.service.CourseService;
import peaksoft.springboot_lms_project.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;
    private final CourseService courseService;
    private final StudentService studentService;

    public CompanyController(CompanyService companyService, CourseService courseService, StudentService studentService) {
        this.companyService = companyService;
        this.courseService = courseService;
        this.studentService = studentService;
    }


    @RequestMapping("/showCompanies")
    public String showAllCompanies(Model model){
        List<Company> companies = companyService.getAllCompany();
        model.addAttribute("companiesAtr", companies);
        return "show-companies";
    }

    @RequestMapping("/new")
    public String displayCompanyForm(Model model){
        List<Course> courseList = courseService.getAllCourse();
        List<Student> studentList = studentService.getAllStudents();
        Company company = new Company();
        model.addAttribute("newCompanyAtr", company);
        model.addAttribute("courseListAtr", courseList);
        model.addAttribute("studentListAtr", studentList);
        return "company-form";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNewCompany(@ModelAttribute("newCompanyAtr") Company company){
        companyService.save(company);
        return "redirect:/companies/showCompanies";
    }

    @RequestMapping("/edit/{id}")
    public String displayCompanyEditForm(@PathVariable("id") Long id, Model model){
        Company company = companyService.getById(id);
        model.addAttribute("newCompanyAtr", company);
        return "company-form";
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.POST)
    public String updatedCompany(@ModelAttribute("companyInfo") Company company,
                                 @PathVariable("id") Long id){
        companyService.updateCompany(id, company);
        return "redirect:/companies/showCompanies";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteCompany(@PathVariable("id") Long id){
        companyService.delete(id);
        return "redirect:/companies/showCompanies";
    }


}

package peaksoft.springboot_lms_project.service;

import org.springframework.stereotype.Service;
import peaksoft.springboot_lms_project.entities.Instructor;
import peaksoft.springboot_lms_project.entities.Student;
import peaksoft.springboot_lms_project.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public Student getById(Long id){
        return studentRepository.getById(id);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}

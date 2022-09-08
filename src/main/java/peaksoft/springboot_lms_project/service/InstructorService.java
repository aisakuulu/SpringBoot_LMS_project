package peaksoft.springboot_lms_project.service;

import org.springframework.stereotype.Service;
import peaksoft.springboot_lms_project.entities.Instructor;
import peaksoft.springboot_lms_project.repository.InstructorRepository;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    public List<Instructor> getAllInstructor(){
        return instructorRepository.findAll();
    }

    public void save(Instructor instructor){
        instructorRepository.save(instructor);
    }

    public Instructor getById(Long id){
        return instructorRepository.getById(id);
    }

    public void delete(Long id){
        instructorRepository.deleteById(id);
    }

    public void updateInstructor(Long id, Instructor updatedInstructor){
        Instructor instructor = instructorRepository.getById(id);
        instructor.setFirstName(updatedInstructor.getFirstName());
        instructor.setLastName(updatedInstructor.getLastName());
        instructor.setPhoneNumber(updatedInstructor.getPhoneNumber());
        instructor.setEmail(updatedInstructor.getEmail());
        instructor.setSpecialization(updatedInstructor.getSpecialization());
        instructorRepository.save(instructor);
    }

}

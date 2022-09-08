package peaksoft.springboot_lms_project.service;

import org.springframework.stereotype.Service;
import peaksoft.springboot_lms_project.entities.Course;
import peaksoft.springboot_lms_project.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    public void save(Course course){
        courseRepository.save(course);
    }

    public Course getById(Long id){
        return courseRepository.getById(id);
    }

    public void delete(Long id){
        courseRepository.deleteById(id);
    }

    public void updateCourse(Long id, Course updatedCourse){
        Course course = courseRepository.getById(id);
        course.setCourseName(updatedCourse.getCourseName());
        course.setDateOfStart(updatedCourse.getDateOfStart());
        course.setDescription(updatedCourse.getDescription());
        course.setDuration(updatedCourse.getDuration());
        course.setImage(updatedCourse.getImage());
        courseRepository.save(course);
    }
}

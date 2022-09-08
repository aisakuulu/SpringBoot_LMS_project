package peaksoft.springboot_lms_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springboot_lms_project.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}
package peaksoft.springboot_lms_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springboot_lms_project.entities.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
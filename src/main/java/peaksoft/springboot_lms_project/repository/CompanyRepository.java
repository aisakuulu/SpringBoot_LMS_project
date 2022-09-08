package peaksoft.springboot_lms_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springboot_lms_project.entities.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {




}
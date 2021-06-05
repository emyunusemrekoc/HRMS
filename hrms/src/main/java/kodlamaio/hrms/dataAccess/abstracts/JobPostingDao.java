package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	JobPosting findById(int id);
	List<JobPosting> findAllByIsActive(boolean isActive);
	List<JobPosting> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive);
	List<JobPosting> findAllByIsActiveOrderByCreatedDateAsc(boolean isActive);
	List<JobPosting> findAllByIsActiveAndEmployer_CompanyName(boolean isActive, String employerName);

}

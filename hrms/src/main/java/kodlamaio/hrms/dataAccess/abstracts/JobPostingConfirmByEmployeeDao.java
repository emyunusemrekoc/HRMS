package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPostingConfirmByEmployee;

public interface JobPostingConfirmByEmployeeDao extends JpaRepository<JobPostingConfirmByEmployee, Integer>{
	
	JobPostingConfirmByEmployee findByJobPostingId(int jobPostingId);
	List<JobPostingConfirmByEmployee> findAllByIsConfirmed(boolean isConfirmed);

}

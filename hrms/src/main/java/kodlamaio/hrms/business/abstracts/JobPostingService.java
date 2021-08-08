package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingGetDto;

public interface JobPostingService {
	
	
	Result add(JobPostingAddDto jobPostingAddDto);
	Result delete(int id);
	Result isActive(int id,int employerId,boolean isActive);
	DataResult<List<JobPostingGetDto>> findAllByIsActive();
	DataResult<List<JobPostingGetDto>> findAllByIsActiveOrderByCreatedDateDesc();
	DataResult<List<JobPostingGetDto>> findAllByIsActiveOrderByCreatedDateAsc();
	DataResult<List<JobPostingGetDto>>  findAllByIsActiveAndEmployer_CompanyName(String employerName);
	DataResult<List<JobPosting>> findAll();
	DataResult <JobPosting> findById(int jobPostingId);
	

}

package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {
	
	
	Result add(JobPostingAddDto jobPostingAddDto);
	Result delete(int id);
	Result isActive(int id,int employerId,boolean isActive);
	DataResult<List<JobPostingDto>> findAllByIsActive();
	DataResult<List<JobPostingDto>> findAllByIsActiveOrderByCreatedDateDesc();
	DataResult<List<JobPostingDto>> findAllByIsActiveOrderByCreatedDateAsc();
	DataResult<List<JobPostingDto>>  findAllByIsActiveAndEmployer_CompanyName(String employerName);
	DataResult<List<JobPosting>> findAll();
	

}

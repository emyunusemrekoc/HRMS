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
	Result isActive(int id,boolean isActive);
	DataResult<List<JobPostingDto>> findAllByIsActive(boolean isActive);
	DataResult<List<JobPostingDto>> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive);
	DataResult<List<JobPostingDto>> findAllByIsActiveOrderByCreatedDateAsc(boolean isActive);
	DataResult<List<JobPostingDto>>  findAllByIsActiveAndEmployer_CompanyName(boolean isActive, String employerName);
	DataResult<List<JobPosting>> findAll();
	

}

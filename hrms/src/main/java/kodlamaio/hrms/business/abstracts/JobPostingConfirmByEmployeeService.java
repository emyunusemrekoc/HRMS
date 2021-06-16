package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingConfirmByEmployeeGetDto;

public interface JobPostingConfirmByEmployeeService {
	
	Result  isConfirmedByEmployee(int jobPostingId, int employeeId,boolean isConfirmed);
	void  confirmTableSetter(JobPosting jobPosting);
	DataResult<List<JobPostingConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed);

}

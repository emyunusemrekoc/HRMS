package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobType;

public interface JobTypeService {
	
	Result add(JobType jobType);
	DataResult<List<JobType>> findAll();
}

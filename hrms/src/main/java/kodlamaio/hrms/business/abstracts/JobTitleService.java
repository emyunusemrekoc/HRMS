package kodlamaio.hrms.business.abstracts;

import java.util.List;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Inheritance(strategy = InheritanceType.JOINED)
public interface JobTitleService {
	
	DataResult<List<JobTitle>> findAll();
	Result add(JobTitle jobTitle);
}

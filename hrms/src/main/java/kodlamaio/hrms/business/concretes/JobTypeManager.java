package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTypeDao;
import kodlamaio.hrms.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService{

	private JobTypeDao jobTypeDao;
	
	
	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao) {
		super();
		this.jobTypeDao = jobTypeDao;
	}

	@Override
	public Result add(JobType jobType) {
		jobTypeDao.save(jobType);
		return new SuccessResult("Çalışma tipi eklendi");
	}
	
	@Override
	public DataResult<List<JobType>> findAll() {
		
		return new SuccessDataResult<List<JobType>>(jobTypeDao.findAll(),"Tüm çalışma tipleri listelendi");
	}

}

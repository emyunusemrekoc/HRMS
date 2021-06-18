package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingConfirmByEmployeeService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingConfirmByEmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.JobPostingConfirmByEmployee;
import kodlamaio.hrms.entities.dtos.JobPostingConfirmByEmployeeGetDto;
@Service
public class JobPostingConfirmByEmployeeManager implements JobPostingConfirmByEmployeeService{

	private JobPostingConfirmByEmployeeDao jobPostingConfirmByEmployeeDao;
	private EmployeeDao employeeDao;
	private DtoConverterService dtoConverterService;
	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingConfirmByEmployeeManager(JobPostingConfirmByEmployeeDao jobPostingConfirmByEmployeeDao,
			EmployeeDao employeeDao, DtoConverterService dtoConverterService,JobPostingDao jobPostingDao) {
		super();
		this.jobPostingConfirmByEmployeeDao = jobPostingConfirmByEmployeeDao;
		this.employeeDao = employeeDao;
		this.dtoConverterService = dtoConverterService;
		this.jobPostingDao = jobPostingDao;
	}
	
	
	@Override
	public Result isConfirmedByEmployee(int jobPostingId, int employeeId, boolean isConfirmed) {
		Employee employee = employeeDao.findById(employeeId);
		
		JobPostingConfirmByEmployee confirmByEmployee = this.jobPostingConfirmByEmployeeDao.findByJobPostingId(jobPostingId);
		confirmByEmployee.setEmployee(employee);
		confirmByEmployee.setConfirmed(isConfirmed);
		confirmByEmployee.setConfirmedDate(LocalDateTime.now());
		jobPostingConfirmByEmployeeDao.save(confirmByEmployee);
		
		
		JobPosting passivePosting = jobPostingDao.findById(jobPostingId);
		passivePosting.setActive(isConfirmed);
		jobPostingDao.save(passivePosting);
			
	
		
	
	return new SuccessResult("İşveren başarılı bir şekilde onaylandı");
	}
	

	@Override
	public DataResult<List<JobPostingConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed) {
		return new SuccessDataResult<List<JobPostingConfirmByEmployeeGetDto>>(dtoConverterService.entityToDto(jobPostingConfirmByEmployeeDao.findAllByIsConfirmed(isConfirmed),JobPostingConfirmByEmployeeGetDto.class)
				,"Onay listesi oluşturuldu");
	}
	
	@Override
	public void confirmTableSetter(JobPosting jobPosting) {
		JobPostingConfirmByEmployee confirmByEmployee = new JobPostingConfirmByEmployee();
		confirmByEmployee.setJobPosting(jobPosting);
		confirmByEmployee.setConfirmed(false);
		jobPostingConfirmByEmployeeDao.save(confirmByEmployee);
	}
	
}
	
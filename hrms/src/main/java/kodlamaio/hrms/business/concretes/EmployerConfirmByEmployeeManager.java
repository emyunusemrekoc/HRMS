package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerConfirmByEmployeeService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerConfirmByEmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerConfirmByEmployee;
import kodlamaio.hrms.entities.dtos.CandidateSkillDto;
import kodlamaio.hrms.entities.dtos.EmployerConfirmByEmployeeGetDto;
@Service
public class EmployerConfirmByEmployeeManager implements EmployerConfirmByEmployeeService {

	private EmployerConfirmByEmployeeDao employerConfirmByEmployeeDao;
	private EmployeeDao employeeDao;
	private DtoConverterService dtoConverterService;
	
	
	@Autowired
	public EmployerConfirmByEmployeeManager(EmployerConfirmByEmployeeDao employerConfirmByEmployeeDao,EmployeeDao employeeDao,DtoConverterService dtoConverterService) {
		super();
		this.employerConfirmByEmployeeDao = employerConfirmByEmployeeDao;
		this.employeeDao = employeeDao;
		this.dtoConverterService = dtoConverterService;
		}
	
	@Override
	public Result isConfirmedByEmployee(int employerId,int employeeId,boolean isConfirmed) {
			Employee employee = employeeDao.findById(employeeId);
			//confirmTableSetter(employerId);
			EmployerConfirmByEmployee confirmByEmployee = this.employerConfirmByEmployeeDao.findByEmployerId(employerId);
			confirmByEmployee.setEmployee(employee);
			confirmByEmployee.setConfirmed(isConfirmed);
			confirmByEmployee.setConfirmedDate(LocalDateTime.now());
			this.employerConfirmByEmployeeDao.save(confirmByEmployee);
			
		
		return new SuccessResult("İşveren onaylaması düzenlendi");
		
	}

	@Override
	public DataResult<List<EmployerConfirmByEmployee>> findAll() {
		
		return new SuccessDataResult<List<EmployerConfirmByEmployee>>(employerConfirmByEmployeeDao.findAll(),"İşveren onayları listelendi");
	}

	@Override
	public DataResult<List<EmployerConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed) {
		
		return new SuccessDataResult<List<EmployerConfirmByEmployeeGetDto>>(dtoConverterService.entityToDto(employerConfirmByEmployeeDao.findAllByIsConfirmed(isConfirmed),EmployerConfirmByEmployeeGetDto.class)
				,"Onay listesi oluşturuldu");
	}
	
	@Override
	public void confirmTableSetter(Employer employer) {
		
		EmployerConfirmByEmployee confirmByEmployee = new EmployerConfirmByEmployee();
		confirmByEmployee.setEmployer(employer);
		confirmByEmployee.setConfirmed(false);
		this.employerConfirmByEmployeeDao.save(confirmByEmployee);
		
	}

	

}

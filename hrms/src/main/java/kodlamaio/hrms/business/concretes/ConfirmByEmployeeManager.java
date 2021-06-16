package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmByEmployeeService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmByEmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.ConfirmByEmployeeGetDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;
@Service
public class ConfirmByEmployeeManager implements ConfirmByEmployeeService {

	private ConfirmByEmployeeDao confirmByEmployeeDao;
	private EmployeeDao employeeDao;
	private DtoConverterService dtoConverterService;
	
	
	@Autowired
	public ConfirmByEmployeeManager(ConfirmByEmployeeDao confirmByEmployeeDao,EmployeeDao employeeDao,DtoConverterService dtoConverterService) {
		super();
		this.confirmByEmployeeDao = confirmByEmployeeDao;
		this.employeeDao = employeeDao;
		this.dtoConverterService = dtoConverterService;
		}
	
	@Override
	public Result isConfirmedByEmployee(int employerId,int employeeId,boolean isConfirmed) {
			Employee employee = employeeDao.findById(employeeId);
			//confirmTableSetter(employerId);
			ConfirmByEmployee confirmByEmployee = this.confirmByEmployeeDao.findByEmployerId(employerId);
			confirmByEmployee.setEmployee(employee);
			confirmByEmployee.setConfirmed(isConfirmed);
			confirmByEmployee.setConfirmedDate(LocalDateTime.now());
			this.confirmByEmployeeDao.save(confirmByEmployee);
			
		
		return new SuccessResult("İşveren başarılı bir şekilde onaylandı");
		
	}

	@Override
	public DataResult<List<ConfirmByEmployee>> findAll() {
		
		return new SuccessDataResult<List<ConfirmByEmployee>>(confirmByEmployeeDao.findAll(),"İşveren onayları listelendi");
	}

	@Override
	public DataResult<List<ConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed) {
		
		return new SuccessDataResult<List<ConfirmByEmployeeGetDto>>(dtoConverterService.entityToDto(confirmByEmployeeDao.findAllByIsConfirmed(isConfirmed),ConfirmByEmployeeGetDto.class)
				,"Onay listesi oluşturuldu");
	}
	
	@Override
	public void confirmTableSetter(Employer employer) {
		
		ConfirmByEmployee confirmByEmployee = new ConfirmByEmployee();
		confirmByEmployee.setEmployer(employer);
		confirmByEmployee.setConfirmed(false);
		this.confirmByEmployeeDao.save(confirmByEmployee);
	}

	

}

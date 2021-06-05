package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmByEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmByEmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class ConfirmByEmployeeManager implements ConfirmByEmployeeService {

	private ConfirmByEmployeeDao confirmByEmployeeDao;
	private EmployeeDao employeeDao;
	
	
	@Autowired
	public ConfirmByEmployeeManager(ConfirmByEmployeeDao confirmByEmployeeDao,EmployeeDao employeeDao) {
		super();
		this.confirmByEmployeeDao = confirmByEmployeeDao;
		this.employeeDao = employeeDao;
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
	public void confirmTableSetter(Employer employer) {
		
		ConfirmByEmployee confirmByEmployee = new ConfirmByEmployee();
		confirmByEmployee.setEmployer(employer);
		confirmByEmployee.setConfirmed(false);
		this.confirmByEmployeeDao.save(confirmByEmployee);
	}

	

}

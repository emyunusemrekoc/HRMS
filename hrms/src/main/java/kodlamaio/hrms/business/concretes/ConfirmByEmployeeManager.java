package kodlamaio.hrms.business.concretes;

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
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class ConfirmByEmployeeManager implements ConfirmByEmployeeService {

	private ConfirmByEmployeeDao confirmByEmployeeDao;
	private EmployeeDao employeeDao;
	private EmployerDao employerDao;
	
	@Autowired
	public ConfirmByEmployeeManager(ConfirmByEmployeeDao confirmByEmployeeDao, EmployeeDao employeeDao,EmployerDao employerDao) {
		super();
		this.confirmByEmployeeDao = confirmByEmployeeDao;
		this.employeeDao = employeeDao;
		this.employerDao = employerDao;
	}

	@Override
	public Result isConfirmedByEmployee(Employer employer,Employee employee) {
		
		this.employeeDao.findAll();
		this.employerDao.findAll();
		
		
//		ConfirmByEmployee confirmByEmployee = new ConfirmByEmployee();
//		confirmByEmployee.setConfirmed(true);
//		confirmByEmployee.getEmployer();
//		confirmByEmployee.getEmployee();
//		confirmByEmployeeDao.save(confirmByEmployee);
		
		return new SuccessResult("İşveren başarılı bir şekilde onaylandı");
		
	}

	@Override
	public DataResult<List<ConfirmByEmployee>> findAll() {
		
		return new SuccessDataResult<List<ConfirmByEmployee>>(confirmByEmployeeDao.findAll(),"İşveren onayları listelendi");
	}

}

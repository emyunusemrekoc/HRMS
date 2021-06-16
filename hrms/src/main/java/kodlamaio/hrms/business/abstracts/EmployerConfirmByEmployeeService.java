package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerConfirmByEmployeeGetDto;

public interface EmployerConfirmByEmployeeService {
	
	DataResult<List<EmployerConfirmByEmployee>> findAll();
	Result  isConfirmedByEmployee(int employerId, int employeeId,boolean isConfirmed);
	void  confirmTableSetter(Employer employer);
	DataResult<List<EmployerConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed);
}

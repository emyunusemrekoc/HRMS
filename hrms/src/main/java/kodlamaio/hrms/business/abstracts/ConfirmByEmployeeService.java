package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employer;

public interface ConfirmByEmployeeService {
	
	DataResult<List<ConfirmByEmployee>> findAll();
	Result  isConfirmedByEmployee(int employerId, int employeeId,boolean isConfirmed);
	void  confirmTableSetter(Employer employer);
}

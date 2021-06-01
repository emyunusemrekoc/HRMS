package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

public interface ConfirmByEmployeeService {

	Result isConfirmedByEmployee(Employer employer,Employee employee);
	DataResult<List<ConfirmByEmployee>> findAll();
}

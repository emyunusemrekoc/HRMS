package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.ConfirmByEmployeeGetDto;

public interface ConfirmByEmployeeService {
	
	DataResult<List<ConfirmByEmployee>> findAll();
	Result  isConfirmedByEmployee(int employerId, int employeeId,boolean isConfirmed);
	void  confirmTableSetter(Employer employer);
	DataResult<List<ConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed);
}

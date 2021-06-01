package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.mapstruct.ValueMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ConfirmByEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/confirmByEmployee")
public class ConfirmByEmployeesController {

	private ConfirmByEmployeeService confirmByEmployeeService;

	@Autowired
	public ConfirmByEmployeesController(ConfirmByEmployeeService confirmByEmployeeService) {
		super();
		this.confirmByEmployeeService = confirmByEmployeeService;
	}

	@GetMapping("/findAll")
	public DataResult<List<ConfirmByEmployee>> findAll() {
		return confirmByEmployeeService.findAll();
	}
	
	@PostMapping("/isConfirmedByEmployee")
	public Result isConfirmedByEmployee(@RequestBody Employer employer,@RequestBody Employee employee) {
		return confirmByEmployeeService.isConfirmedByEmployee(employer, employee);
	}
}

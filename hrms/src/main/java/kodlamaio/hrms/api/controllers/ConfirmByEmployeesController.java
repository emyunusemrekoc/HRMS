package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ConfirmByEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;

@RestController
@RequestMapping("/api/confirmByEmployees")
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
	public Result isConfirmedByEmployee(int employerId, int employeeId,boolean isConfirmed) {
		return confirmByEmployeeService.isConfirmedByEmployee(employerId, employeeId, isConfirmed);
	}
}

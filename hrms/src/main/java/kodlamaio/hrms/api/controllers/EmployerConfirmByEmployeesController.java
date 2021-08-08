package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerConfirmByEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerConfirmByEmployee;
import kodlamaio.hrms.entities.dtos.EmployerConfirmByEmployeeGetDto;
@CrossOrigin
@RestController
@RequestMapping("/api/employerConfirmByEmployees")
public class EmployerConfirmByEmployeesController {

	private EmployerConfirmByEmployeeService employerConfirmByEmployeeService;

	@Autowired
	public EmployerConfirmByEmployeesController(EmployerConfirmByEmployeeService employerConfirmByEmployeeService) {
		super();
		this.employerConfirmByEmployeeService = employerConfirmByEmployeeService;
	}

	@GetMapping("/findAll")
	public DataResult<List<EmployerConfirmByEmployee>> findAll() {
		return employerConfirmByEmployeeService.findAll();
	}
	
	@GetMapping("/findAllByIsConfirmed")
	public DataResult<List<EmployerConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed){
	
		return employerConfirmByEmployeeService.findAllByIsConfirmed(isConfirmed);
	}
	
	@PutMapping("/isConfirmedByEmployee")
	public Result isConfirmedByEmployee(int employerId, int employeeId,boolean isConfirmed) {
		
		return employerConfirmByEmployeeService.isConfirmedByEmployee(employerId, employeeId, isConfirmed);
	}
	
}

package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingConfirmByEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobPostingConfirmByEmployeeGetDto;
@CrossOrigin
@RestController
@RequestMapping("/api/jobPostingConfirmByEmployees")
public class JobPostingConfirmByEmployeesController {
	
	private JobPostingConfirmByEmployeeService jobPostingConfirmByEmployeeService;

	@Autowired
	public JobPostingConfirmByEmployeesController(
			JobPostingConfirmByEmployeeService jobPostingConfirmByEmployeeService) {
		super();
		this.jobPostingConfirmByEmployeeService = jobPostingConfirmByEmployeeService;
	}

	@GetMapping("/findAllByIsConfirmed")
	public DataResult<List<JobPostingConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed){
	
		return jobPostingConfirmByEmployeeService.findAllByIsConfirmed(isConfirmed);
	}
	
	@PutMapping("/isConfirmedByEmployee")
	public Result isConfirmedByEmployee(int jobPostingId, int employeeId,boolean isConfirmed) {
		
		return jobPostingConfirmByEmployeeService.isConfirmedByEmployee(jobPostingId, employeeId, isConfirmed);
	}
}

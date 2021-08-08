package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobType;

@RestController
@RequestMapping("/api/jobTypes")
@CrossOrigin
public class JobTypesController {
	
	private JobTypeService jobTypeService;

	@Autowired
	public JobTypesController(JobTypeService jobTypeService) {
		super();
		this.jobTypeService = jobTypeService;
	}
	
	@PostMapping("/add")
	Result add(@RequestBody JobType jobType) {
		
		return jobTypeService.add(jobType);
		
		}
	@GetMapping("/findAll")
	DataResult<List<JobType>> findAll(){
		
		return jobTypeService.findAll();
	}

}

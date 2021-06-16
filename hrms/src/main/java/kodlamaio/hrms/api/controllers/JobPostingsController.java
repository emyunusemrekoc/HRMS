package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

@RestController
@RequestMapping("/api/jobPostings")
@CrossOrigin
public class JobPostingsController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

	@PostMapping("/add")
	Result add(@RequestBody JobPostingAddDto jobPostingAddDto) {
		return this.jobPostingService.add(jobPostingAddDto);
	}

	@DeleteMapping("/delete")
	Result delete(@RequestParam int id) {
		return this.jobPostingService.delete(id);

	}

	@PutMapping("/isActive")
	Result isActive(@RequestParam int id,@RequestParam int employerId, boolean isActive) {
		return this.jobPostingService.isActive(id, employerId, isActive);

	}

	@GetMapping("/findAllByIsActive")
	DataResult<List<JobPostingDto>> findAllByIsActive() {
		return this.jobPostingService.findAllByIsActive();

	}

	@GetMapping("/findAllByIsActiveOrderByCreatedDateDesc")
	DataResult<List<JobPostingDto>> findAllByIsActiveOrderByCreatedDateDesc() {
		return this.jobPostingService.findAllByIsActiveOrderByCreatedDateDesc();
	}
	
	@GetMapping("/findAllByIsActiveOrderByCreatedDateAsc")
	DataResult<List<JobPostingDto>> findAllByIsActiveOrderByCreatedDateAsc(){
	return this.jobPostingService.findAllByIsActiveOrderByCreatedDateAsc();
	}
	
	@GetMapping("/findAllByIsActiveAndEmployer_CompanyName")
	DataResult<List<JobPostingDto>> findAllByIsActiveAndEmployer_CompanyName(String companyName) {
		return this.jobPostingService.findAllByIsActiveAndEmployer_CompanyName( companyName);
	}
	
	@GetMapping("/findAll")
	DataResult<List<JobPosting>> findAll(){
		return this.jobPostingService.findAll();
		
	}

}

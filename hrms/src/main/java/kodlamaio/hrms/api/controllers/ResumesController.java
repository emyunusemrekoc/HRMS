package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;
import kodlamaio.hrms.entities.dtos.ResumeUpdateDto;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
	
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid ResumeAddDto resumeAddDto) {
		return resumeService.add(resumeAddDto);
	}
	@PutMapping("/update")
	Result update(@RequestBody @Valid ResumeUpdateDto resumeUpdateDto,int candidateId,int resumeId) {
		return resumeService.update(resumeUpdateDto, candidateId,resumeId);
		
	}
	@GetMapping("/findByCandidateIdAndResumeId")
	Result findByCandidateIdAndResumeId(int candidateId,int resumeId){
		return resumeService.findByCandidateIdAndResumeId(candidateId,resumeId);
		
	}
	
	@GetMapping("/findAllByCandidateId")
	DataResult<List<ResumeGetDto>> findAllByCandidateId(int candidateId){
		return resumeService.findAllByCandidateId(candidateId);
		
	}
	@GetMapping("/findAll")
	DataResult<List<ResumeGetDto>> findAll(){
		return resumeService.findAll();
		
	}
	

}

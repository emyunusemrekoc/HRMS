package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeEducationDto;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

@RestController
@RequestMapping("/api/resumeEducations")
public class ResumeEducationsController {
	
	private ResumeEducationService resumeEducationService;

	@Autowired
	public ResumeEducationsController(ResumeEducationService resumeEducationService) {
		super();
		this.resumeEducationService = resumeEducationService;
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody ResumeEducationDto resumeEducationDto) {
		return resumeEducationService.add(resumeEducationDto);
	}
	
	@GetMapping("/findAllByResumeId")
	DataResult<List<ResumeEducationDto>> findAllByResumeId(int resumeId) {
		return resumeEducationService.findAllByResumeId(resumeId);
	}
	
	@GetMapping("/findAllByResumeIdOrderByEndDateDesc")
	DataResult<List<ResumeEducationDto>> findAllByResumeIdOrderByEndDateDesc(int resumeId){
		return resumeEducationService.findAllByResumeIdOrderByEndDateDesc(resumeId);
	}
}

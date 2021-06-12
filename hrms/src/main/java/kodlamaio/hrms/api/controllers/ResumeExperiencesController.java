package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeExperienceDto;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

@RestController
@RequestMapping("/api/resumeExperiences")
public class ResumeExperiencesController {
	
	private ResumeExperienceService resumeExperienceService;

	public ResumeExperiencesController(ResumeExperienceService resumeExperienceService) {
		super();
		this.resumeExperienceService = resumeExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeExperienceDto resumeExperienceDto) {
		return resumeExperienceService.add(resumeExperienceDto);
	}
	@GetMapping("/findAllByResumeId")
	DataResult<List<ResumeExperienceDto>> findAllByResumeId(int resumeId) {
		return resumeExperienceService.findAllByResumeId(resumeId);
	}
	@GetMapping("/findAllByResumeIdOrderByEndDateDesc")
	DataResult<List<ResumeExperienceDto>> findAllByResumeIdOrderByEndDateDesc(int resumeId){
		return resumeExperienceService.findAllByResumeIdOrderByEndDateDesc(resumeId);
	}

}

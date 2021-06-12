package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

@RestController
@RequestMapping("/api/resumeSkills")
public class ResumeSkillsController {

	private ResumeSkillService resumeSkillService;
	
	@Autowired
	public ResumeSkillsController(ResumeSkillService resumeSkillService) {
		super();
		this.resumeSkillService = resumeSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeSkillDto resumeSkillDto) {
		return resumeSkillService.add(resumeSkillDto);
	}
	
	@GetMapping("/findAllByResumeId")
	DataResult<List<ResumeSkillDto>> findAllByResumeId(int resumeId) {
		return resumeSkillService.findAllByResumeId(resumeId);
	}
}

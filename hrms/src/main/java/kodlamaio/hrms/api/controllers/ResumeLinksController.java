package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeLinkDto;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

@RestController
@RequestMapping("/api/resumeLinks")
public class ResumeLinksController {
	
	private ResumeLinkService resumeLinkService;
	
	
	@Autowired
	public ResumeLinksController(ResumeLinkService resumeLinkService) {
		super();
		this.resumeLinkService = resumeLinkService;
	}

	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeLinkDto resumeLinkDto) {
		return resumeLinkService.add(resumeLinkDto);
	}
	
	@GetMapping("/findAllByResumeId")
	DataResult<List<ResumeLinkDto>> findAllByResumeId(int resumeId) {
		return resumeLinkService.findAllByResumeId(resumeId);
	}
}

package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeLanguageDto;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

@RestController
@RequestMapping("/api/resumeLanguages")
public class ResumeLanguagesController {
	
	private ResumeLanguageService resumeLanguageService;
	
	@Autowired
	public ResumeLanguagesController(ResumeLanguageService resumeLanguageService) {
		super();
		this.resumeLanguageService = resumeLanguageService;
	}



	@PostMapping("/add")
	public Result add(@RequestBody @Valid ResumeLanguageDto resumeLanguageDto) {
		return resumeLanguageService.add(resumeLanguageDto);
	}

	@GetMapping("/findAllByResumeId")
	DataResult<List<ResumeLanguageDto>> findAllByResumeId(int resumeId) {
		return resumeLanguageService.findAllByResumeId(resumeId);
	}
}

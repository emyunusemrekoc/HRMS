package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeCoverLetterDto;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

@RestController
@RequestMapping("/api/resumeCoverLetters")
public class ResumeCoverLettersController {

	private ResumeCoverLetterService resumeCoverLetterService;

	@Autowired
	public ResumeCoverLettersController(ResumeCoverLetterService resumeCoverLetterService) {
		super();
		this.resumeCoverLetterService = resumeCoverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeCoverLetterDto resumeCoverLetterDto) {
		return resumeCoverLetterService.add(resumeCoverLetterDto);
	}
	
	@GetMapping("/findAllByResumeId")
	DataResult<List<ResumeCoverLetterDto>> findAllByResumeId(int resumeId) {
		return resumeCoverLetterService.findAllByResumeId(resumeId);
	}
	
}

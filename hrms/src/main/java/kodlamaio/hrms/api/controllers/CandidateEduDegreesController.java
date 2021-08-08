package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateEduDegreeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateEduDegreeDto;
@CrossOrigin
@RestController
@RequestMapping("/api/candidateEduDegrees")
public class CandidateEduDegreesController {

	private CandidateEduDegreeService candidateEduDegreeService;

	@Autowired
	public CandidateEduDegreesController(CandidateEduDegreeService candidateEduDegreeService) {
		super();
		this.candidateEduDegreeService = candidateEduDegreeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateEduDegreeDto candidateEduDegreeDto) {
		return candidateEduDegreeService.add(candidateEduDegreeDto);
	}
	
	@GetMapping("/findAll")
	DataResult<List<CandidateEduDegreeDto>> findAll() {
		return candidateEduDegreeService.findAll();
	}
}

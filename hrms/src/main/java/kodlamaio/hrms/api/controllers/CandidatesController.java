package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/findAll")
	public DataResult<List<Candidate>> findAll() {
		return candidateService.findAll();
	}

	@PostMapping("/add")
	public Result Add(@RequestBody Candidate candidate) {
		return candidateService.add(candidate);
	}
	
		
}

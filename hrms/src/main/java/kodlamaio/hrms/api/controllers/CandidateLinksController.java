package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateLinkDto;
@CrossOrigin
@RestController
@RequestMapping("/api/candidateLinks")
public class CandidateLinksController {
	
	private CandidateLinkService candidateLinkService;
	
	
	@Autowired
	public CandidateLinksController(CandidateLinkService candidateLinkService) {
		super();
		this.candidateLinkService = candidateLinkService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateLinkDto candidateLinkDto) {
		Result result=candidateLinkService.add(candidateLinkDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result); 
	}
	
	@GetMapping("/findAllByCandidateId")
	DataResult<List<CandidateLinkDto>> findAllByCandidateId(int candidateId) {
		return candidateLinkService.findAllByCandidateId(candidateId);
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<?> deleteById(@RequestParam int candidateLinkId) {
		Result result=candidateLinkService.deleteById(candidateLinkId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result); 
	}
}

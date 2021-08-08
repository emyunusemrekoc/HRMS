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

import kodlamaio.hrms.business.abstracts.CandidateCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCoverLetter;
import kodlamaio.hrms.entities.dtos.CandidateCoverLetterDto;
@CrossOrigin
@RestController
@RequestMapping("/api/candidateCoverLetters")
public class CandidateCoverLettersController {

	private CandidateCoverLetterService candidateCoverLetterService;

	@Autowired
	public CandidateCoverLettersController(CandidateCoverLetterService candidateCoverLetterService) {
		super();
		this.candidateCoverLetterService = candidateCoverLetterService;
	}
	
	@PostMapping("/add")
	 public ResponseEntity<?> add(@RequestBody CandidateCoverLetterDto candidateCoverLetterDto) {
		Result result=candidateCoverLetterService.add(candidateCoverLetterDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/findAllByCandidateId")
	DataResult<List<CandidateCoverLetterDto>> findAllByCandidateId(int candidateId) {
		return candidateCoverLetterService.findAllByCandidateId(candidateId);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody CandidateCoverLetterDto candidateCoverLetterDto) {
		return candidateCoverLetterService.delete(candidateCoverLetterDto);
	}
	
	@GetMapping("/findByCandidateId")
	DataResult<CandidateCoverLetter> findByCandidateId(@RequestParam int candidateId){
		return candidateCoverLetterService.findByCandidateId(candidateId);
	}
}

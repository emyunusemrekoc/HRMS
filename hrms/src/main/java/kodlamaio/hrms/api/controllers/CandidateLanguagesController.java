package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

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

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateLanguageDto;
@CrossOrigin
@RestController
@RequestMapping("/api/candidateLanguages")
public class CandidateLanguagesController {
	
	private CandidateLanguageService candidateLanguageService;
	
	@Autowired
	public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateLanguageService = candidateLanguageService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid CandidateLanguageDto candidateLanguageDto) {
		Result result=candidateLanguageService.add(candidateLanguageDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result); 
		
	}

	@GetMapping("/findAllByCandidateId")
	DataResult<List<CandidateLanguageDto>> findAllByCandidateId(int candidateId) {
		return candidateLanguageService.findAllByCandidateId(candidateId);
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<?> deleteById(@RequestParam int candidateLanguageId) {
		Result result=candidateLanguageService.deleteById(candidateLanguageId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result); 
	}
}

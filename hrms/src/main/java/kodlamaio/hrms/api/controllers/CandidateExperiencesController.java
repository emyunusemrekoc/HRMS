package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateExperienceDto;
import kodlamaio.hrms.entities.dtos.CandidateExperienceGetDto;
@CrossOrigin
@RestController
@RequestMapping("/api/candidateExperiences")
public class CandidateExperiencesController {
	
	private CandidateExperienceService candidateExperienceService;

	public CandidateExperiencesController(CandidateExperienceService candidateExperienceService) {
		super();
		this.candidateExperienceService = candidateExperienceService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateExperienceDto candidateExperienceDto) {
		Result result=candidateExperienceService.add(candidateExperienceDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
		
	}
	
	@GetMapping("/findAllByCandidateId")
	DataResult<List<CandidateExperienceGetDto>> findAllByCandidateId(int candidateId) {
		return candidateExperienceService.findAllByCandidateId(candidateId);
	}
	
	@GetMapping("/findAllByCandidateIdOrderByEndDateDesc")
	DataResult<List<CandidateExperienceGetDto>> findAllByCandidateIdOrderByEndDateDesc(int candidateId){
		return candidateExperienceService.findAllByCandidateIdOrderByEndDateDesc(candidateId);
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<?> deleteById(@RequestParam int candidateExperienceId) {
		Result result=candidateExperienceService.deleteById(candidateExperienceId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result); 
	}

}

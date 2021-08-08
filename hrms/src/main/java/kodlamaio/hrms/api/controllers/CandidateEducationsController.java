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

import kodlamaio.hrms.business.abstracts.CandidateEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateEducationDto;
import kodlamaio.hrms.entities.dtos.CandidateEducationGetDto;
@CrossOrigin
@RestController
@RequestMapping("/api/candidateEducations")
public class CandidateEducationsController {
	
	private CandidateEducationService candidateEducationService;

	@Autowired
	public CandidateEducationsController(CandidateEducationService candidateEducationService) {
		super();
		this.candidateEducationService = candidateEducationService;
	}
	

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateEducationDto candidateEducationDto) {
		Result result=candidateEducationService.add(candidateEducationDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
		
	}
	
	@GetMapping("/findAllByCandidateId")
	DataResult<List<CandidateEducationGetDto>> findAllByCandidateId(int candidateId) {
		return candidateEducationService.findAllByCandidateId(candidateId);
	}
	
	@GetMapping("/findAllByCandidateIdOrderByEndDateDesc")
	DataResult<List<CandidateEducationGetDto>> findAllByCandidateIdOrderByEndDateDesc(int candidateId){
		return candidateEducationService.findAllByCandidateIdOrderByEndDateDesc(candidateId);
	}
	
	@DeleteMapping("/deleteById")
	public  ResponseEntity<?> deleteById(@RequestParam int candidateEducationId) {
		Result result=candidateEducationService.deleteById(candidateEducationId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
		
	}
}

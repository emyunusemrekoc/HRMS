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

import kodlamaio.hrms.business.abstracts.CandidateSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateSkillDto;
@CrossOrigin
@RestController
@RequestMapping("/api/candidateSkills")
public class CandidateSkillsController {

	private CandidateSkillService candidateSkillService;
	
	@Autowired
	public CandidateSkillsController(CandidateSkillService candidateSkillService) {
		super();
		this.candidateSkillService = candidateSkillService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateSkillDto candidateSkillDto) {
		Result result=candidateSkillService.add(candidateSkillDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/findAllByCandidateId")
	public DataResult<List<CandidateSkillDto>> findAllByCandidateId(int candidateId) {
		return candidateSkillService.findAllByCandidateId(candidateId);
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<?> deleteById(@RequestParam int candidateSkillId) {
		Result result=candidateSkillService.deleteById(candidateSkillId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
		
	}
}

package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.core.adapters.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/userverify")
public class VerificationCodesController {
	
	private VerificationService verificationService;
	
	@Autowired
	public VerificationCodesController(VerificationService verificationService) {
		super();
		this.verificationService = verificationService;
	}
	
	@GetMapping("/verify/{verificationCode}")  //@PathVariable : degeri pathden almak için
	public Result verifiedUser(@PathVariable String verificationCode) {
		return verificationService.verifiedUser(verificationCode);
	}
	
	

}

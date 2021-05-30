package kodlamaio.hrms.core.adapters.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	DataResult<List<VerificationCode>> findAll();
	String generateVerificationCode(User user);
	VerificationCode findByVerificationCode(String verificationCode);
		
	
	

}

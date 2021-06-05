package kodlamaio.hrms.business.validations.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface VerificationService {
	
	Result verifiedUser(String verificationCode);
	
}

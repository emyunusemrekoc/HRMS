package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface VerificationService {
	
	Result verifiedUser(String verificationCode);

}

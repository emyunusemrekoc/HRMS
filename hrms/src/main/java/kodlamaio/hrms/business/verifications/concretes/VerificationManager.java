package kodlamaio.hrms.business.verifications.concretes;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.verifications.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationManager implements VerificationService{
	
	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result verifiedUser(String verificationCode) {
		if (!verificationCodeDao.existsByVerificationCodeEquals(verificationCode)) {

			
			
			return new ErrorResult("Kullanıcı aktivasyonu başarısız");
			
		} 
		else {

			VerificationCode code = verificationCodeDao.findByVerificationCode(verificationCode);
			code.setVerified(true);
			code.setVerifiedDate(LocalDateTime.now());
			verificationCodeDao.save(code);
			
			
			
			
			return new SuccessResult("Kullanıcı aktivasyonu gerçekleşti");
		}
	}

	
}

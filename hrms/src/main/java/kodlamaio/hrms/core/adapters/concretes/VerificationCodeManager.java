package kodlamaio.hrms.core.adapters.concretes;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;

	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public DataResult<List<VerificationCode>> findAll() {

		return new SuccessDataResult<List<VerificationCode>>(verificationCodeDao.findAll(), "Başarıyla listelendi");
	}

	private String generatedCode = "";

	@Override
	public String generateVerificationCode(User user) {
		for (int i = 0; i == 0; i = 0) {
			generatedCode = randomCodeGenerator(20);
			if (verificationCodeDao.findByVerificationCode(generatedCode) == null) {
				break;
			}

		}

		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setVerificationCode(generatedCode);
		verificationCode.setUser(user);
		verificationCodeDao.save(verificationCode);
		return generatedCode;

	}


	@Override
	public VerificationCode findByVerificationCode(String verificationCode) {

		return this.verificationCodeDao.findByVerificationCode(verificationCode);
	}

	private final String content = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private SecureRandom mixer = new SecureRandom();

	private String randomCodeGenerator(int length) {
		StringBuilder randomStringBuilder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			randomStringBuilder.append(content.charAt(mixer.nextInt(content.length())));
		}
		return randomStringBuilder.toString();
	}
}

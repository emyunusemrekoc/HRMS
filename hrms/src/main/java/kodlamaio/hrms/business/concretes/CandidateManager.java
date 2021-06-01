package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;
import kodlamaio.hrms.core.adapters.abstracts.FakeSendEmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.validations.abstracts.RegexService;
import kodlamaio.hrms.core.validations.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.validations.abstracts.VerificationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private FakeMernisService fakeMernisService;
	private CandidateDao candidateDao;
	private VerificationCodeService verificationCodeService;
	private RegexService regexService;
	private FakeSendEmailService fakeSendEmailService;


	@Autowired
	public CandidateManager(FakeMernisService fakeMernisService, CandidateDao candidateDao,
			VerificationCodeService verificationCodeService, RegexService regexService,
			FakeSendEmailService fakeSendEmailService) {
		super();
		this.fakeMernisService = fakeMernisService;
		this.candidateDao = candidateDao;
		this.verificationCodeService = verificationCodeService;
		this.regexService = regexService;
		this.fakeSendEmailService = fakeSendEmailService;
		
	}


	@Override
	public DataResult<List<Candidate>> findAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),
				"iş arayanlar başarılı bir şekilde listelendi.");
	}

	
	@Override
	public Result add(Candidate candidate) {
		if (candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty()
				|| candidate.getIdentificationNumber().isEmpty() || candidate.getDateOfBirth().isEmpty()
				|| candidate.getEmail().isEmpty() || candidate.getPassword().isEmpty() || 
				candidate.getFirstName().isBlank() || candidate.getLastName().isBlank()) {
			
			return new ErrorResult("Boş alan bırakmayınız");
		}

		else if (!regexService.isPasswordFormat(candidate.getPassword())) {
			return new ErrorResult(
					"Şifreniz en az 8 karakterden oluşmalıdır.En az bir büyük harf,bir küçük harf,bir rakam ve özel karakter içermelidir.");
		}

		else if (!regexService.isDateOfBirthFormat(candidate.getDateOfBirth())) {
			return new ErrorResult("Lütfen doğum tarihinizi GG-AA-YYYY formatında giriniz.");
		}
		
		else if (!regexService.isEmailValid(candidate.getEmail())) {
			
			return new ErrorResult("Lütfen email adresinizi email formatında giriniz ");
		}

		else if (!fakeMernisService.checkIfRealPerson(candidate.getIdentificationNumber())) {
			return new ErrorResult("Kimlik bilgileriniz e-devlet doğrulamasından geçemedi");
		}

		else if (candidateDao.findByEmailEquals(candidate.getEmail()) != null) {
			return new ErrorResult("Bu mail adresi daha önceden kayıtlı");
		}

		else if (candidateDao.findByIdentificationNumberEquals(candidate.getIdentificationNumber()) != null) {
			return new ErrorResult("Bu kimlik numarası daha önceden kayıtlı");
		} 
		else {
			this.candidateDao.save(candidate);
			this.verificationCodeService.generateVerificationCode(candidate);
			this.fakeSendEmailService.SendEmail(candidate.getEmail());
			
			
			return new SuccessResult("Kullanıcı sisteme kaydedildi.Fakat doğrulama yapılmadı. " + candidate.getEmail()
								+ " Adresine doğrulama kodu gönderildi");
			}
		}
		
	}




package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCoverLetterService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserPhotoService;
import kodlamaio.hrms.business.verifications.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;
import kodlamaio.hrms.core.adapters.abstracts.FakeSendEmailService;
import kodlamaio.hrms.core.utilities.regex.abstracts.RegexService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private FakeMernisService fakeMernisService;
	private CandidateDao candidateDao;
	private VerificationCodeService verificationCodeService;
	private RegexService regexService;
	private FakeSendEmailService fakeSendEmailService;
	private UserPhotoService userPhotoService;
	private CandidateCoverLetterService candidateCoverLetterService;


	@Autowired
	public CandidateManager(FakeMernisService fakeMernisService, CandidateDao candidateDao,
			VerificationCodeService verificationCodeService, RegexService regexService,
			FakeSendEmailService fakeSendEmailService,UserPhotoService userPhotoService,
			CandidateCoverLetterService candidateCoverLetterService) {
		super();
		this.fakeMernisService = fakeMernisService;
		this.candidateDao = candidateDao;
		this.verificationCodeService = verificationCodeService;
		this.regexService = regexService;
		this.fakeSendEmailService = fakeSendEmailService;
		this.userPhotoService = userPhotoService;
		this.candidateCoverLetterService = candidateCoverLetterService;
	}


	@Override
	public DataResult<List<Candidate>> findAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),
				"i?? arayanlar ba??ar??l?? bir ??ekilde listelendi.");
	}

	
	@Override
	public Result add(Candidate candidate) {
		if (candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty()
				|| candidate.getIdentificationNumber().isEmpty() || candidate.getDateOfBirth()==null
				|| candidate.getEmail().isEmpty() || candidate.getPassword().isEmpty() || 
				candidate.getFirstName().isBlank() || candidate.getLastName().isBlank()) {
			
			return new ErrorResult("Bo?? alan b??rakmay??n??z");
		}

		else if (!regexService.isPasswordFormat(candidate.getPassword())) {
			return new ErrorResult(
					"??ifreniz en az 8 karakterden olu??mal??d??r.En az bir b??y??k harf,bir k??????k harf,bir rakam ve ??zel karakter i??ermelidir.");
		}
		else if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("??ifreler birbiri ile uyumsuz");
		}
		
		else if (!regexService.isEmailValid(candidate.getEmail())) {
			
			return new ErrorResult("L??tfen email adresinizi email format??nda giriniz ");
		}

		else if (!fakeMernisService.checkIfRealPerson(candidate.getIdentificationNumber())) {
			return new ErrorResult("Kimlik bilgileriniz e-devlet do??rulamas??ndan ge??emedi");
		}

		else if (candidateDao.findByEmailEquals(candidate.getEmail()) != null ) {
			return new ErrorResult("Bu mail adresi daha ??nceden kay??tl??");
		}

		else if (candidateDao.findByIdentificationNumberEquals(candidate.getIdentificationNumber()) != null) {
			return new ErrorResult("Bu kimlik numaras?? daha ??nceden kay??tl??");
		} 
		
		
		else {
			this.candidateDao.save(candidate);
			this.verificationCodeService.generateVerificationCode(candidate);
			this.fakeSendEmailService.SendEmail(candidate.getEmail());
			this.userPhotoService.photoTableSetter(candidate);
			this.candidateCoverLetterService.coverLetterTableSetter(candidate);
			
			
			return new SuccessResult("Kullan??c?? sisteme kaydedildi.Fakat do??rulama yap??lmad??. " + candidate.getEmail()
								+ " Adresine do??rulama kodu g??nderildi");
			}
		}


	@Override
	public DataResult<Candidate> findById(int candidateId) {
	
		return new SuccessDataResult<Candidate>(candidateDao.findById(candidateId),"???? arayan getirildi");
	}
		
	}




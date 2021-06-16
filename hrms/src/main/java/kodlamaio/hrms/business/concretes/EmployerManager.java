package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerConfirmByEmployeeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.verifications.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.adapters.abstracts.FakeSendEmailService;
import kodlamaio.hrms.core.utilities.regex.abstracts.RegexService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private VerificationCodeService verificationCodeService;
	private RegexService regexService;
	private FakeSendEmailService fakeSendEmailService;
	private EmployerConfirmByEmployeeService confirmByEmployeeService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,VerificationCodeService verificationCodeService,
			RegexService regexService,FakeSendEmailService fakeSendEmailService,EmployerConfirmByEmployeeService confirmByEmployeeService) {
		super();
		this.employerDao = employerDao;
		this.verificationCodeService = verificationCodeService;
		this.regexService = regexService;
		this.fakeSendEmailService = fakeSendEmailService;
		this.confirmByEmployeeService = confirmByEmployeeService;
	}

	@Override
	public DataResult<List<Employer>> findAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		
		String[] emailSplit = employer.getEmail().split("@");
		
		if ( employer.getEmail().isEmpty() || employer.getPassword().isEmpty()
				||employer.getCompanyName().isEmpty() || employer.getWebAdress().isEmpty() ||
				employer.getCompanyName().isBlank() || employer.getWebAdress().isBlank() || 
				employer.getPhoneNumber().isEmpty() || employer.getPhoneNumber().isBlank() )
		{
			
			return new ErrorResult("Boş alan bırakmayınız");
		}

		else if (!regexService.isPasswordFormat(employer.getPassword())) {
			return new ErrorResult(
					"Şifreniz en az 8 karakterden oluşmalıdır.En az bir büyük harf,bir küçük harf,bir rakam ve özel karakter içermelidir.");
		}
		else if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Şifreler birbiri ile uyumsuz");
		}
		else if (!regexService.isPhoneNumberFormat(employer.getPhoneNumber())) {
			return new ErrorResult(
					"Lütfen uygun formatta telefon numarası giriniz");
		}
		
		else if (!regexService.isEmailValid(employer.getEmail())) {
			 
			 return new ErrorResult("Lütfen email adresinizi email formatında giriniz ");
			 }
		
		else if(!emailSplit[1].equals(employer.getWebAdress())) {
        	
            return new ErrorResult("Mail adresinizin domaini ile şirketinizin domaini eşleşmiyor");
        }
        
		else if (employerDao.findByEmailEquals(employer.getEmail()) != null) {
			return new ErrorResult("Bu mail adresi daha önceden kayıtlı");
		}
		
		else if (employerDao.findByPhoneNumberEquals(employer.getPhoneNumber()) != null) {
			return new ErrorResult("Bu telefon numarası daha önceden kayıtlı");
		}
		
		else if (employerDao.findByWebAdressEquals(employer.getWebAdress()) != null) {
			return new ErrorResult("Bu web adresi daha önceden kayıtlı");
		}

		else {
			this.employerDao.save(employer);
			this.verificationCodeService.generateVerificationCode(employer);
			this.fakeSendEmailService.SendEmail(employer.getEmail());
			this.confirmByEmployeeService.confirmTableSetter(employer);
		
			return new SuccessResult("Kullanıcı sisteme kaydedildi.Fakat mail doğrulaması yapılmadı. " + employer.getEmail()
			+ " Adresine doğrulama kodu gönderildi");
		}
	}
	
	


}
	



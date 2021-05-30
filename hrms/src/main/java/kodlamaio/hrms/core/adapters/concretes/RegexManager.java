package kodlamaio.hrms.core.adapters.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.RegexService;

@Service
public class RegexManager implements RegexService {

	
	@Override
	public boolean isEmailValid(String emailInput) {
		String emailPattern = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();

	}
	@Override
	public boolean isFirstNameFormat(String firstNameFormat) {
		String regex = "[A-Z][a-zA-Z]*";

	    Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstNameFormat);
        return matcher.matches();
	}

	@Override
	public boolean isLastNameFormat(String lastNameFormat) {
		String regex = "[A-Z]+[a-zA-Z]*";

	    Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lastNameFormat);
        return matcher.matches();
	}

	@Override
	public boolean isDateOfBirthFormat(String dateOfBirthFormat) {
		String regex = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";

	    Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateOfBirthFormat);
        return matcher.matches();
	}

    	@Override
    	public boolean isPhoneNumberFormat(String phoneNumberFormat) {
    		  String regex = "^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$";

    		    Pattern pattern = Pattern.compile(regex);
    	        Matcher matcher = pattern.matcher(phoneNumberFormat);
    	        return matcher.matches();
    	}
		@Override
		public boolean isPasswordFormat(String passwordFormat) {
			String regex = "^(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*\\d)(?=\\S*([^\\w\\s]|[_]))\\S{8,}$";

		    Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(passwordFormat);
	        return matcher.matches();
		}
}

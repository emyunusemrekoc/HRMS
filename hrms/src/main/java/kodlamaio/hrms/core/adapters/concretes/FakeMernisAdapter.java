package kodlamaio.hrms.core.adapters.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;
@Service
public class FakeMernisAdapter implements FakeMernisService{
	
	private  String tcNoPattern = "^[0-9]+$";
	
	public boolean checkIfRealPerson(String tcNo) {
		
		if (tcNo.length() != 11) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(tcNoPattern);
		return pattern.matcher(tcNo).find();
	}
	

}

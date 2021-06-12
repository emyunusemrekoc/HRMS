package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.regex.abstracts.RegexService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	private RegexService regexService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,RegexService regexService) {
		super();
		this.employeeDao = employeeDao;
		this.regexService = regexService;
	}

	@Override
	public DataResult<List<Employee>> findAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Çalışanlar listelendi.");
	}

	@Override
	public Result add(Employee employee) {
		if (!employee.getPassword().equals(employee.getPasswordRepeat())) {
			return new ErrorResult("Şifreler birbiri ile uyumsuz");
		}
		
		else if (!regexService.isPasswordFormat(employee.getPassword())) {
			return new ErrorResult(
					"Şifreniz en az 8 karakterden oluşmalıdır.En az bir büyük harf,bir küçük harf,bir rakam ve özel karakter içermelidir.");
		}
		
		else if (!regexService.isEmailValid(employee.getEmail())) {
			 
			 return new ErrorResult("Lütfen email adresinizi email formatında giriniz ");
			 }
		
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan sisteme başarılı bir şekilde kaydedildi");
	}

}

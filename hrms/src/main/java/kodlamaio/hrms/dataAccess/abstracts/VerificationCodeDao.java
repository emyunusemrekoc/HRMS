package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer>{

	VerificationCode findByVerificationCode(String verificationCode);
	VerificationCode findByVerificationCodeEquals(String verificationCode);

	
}

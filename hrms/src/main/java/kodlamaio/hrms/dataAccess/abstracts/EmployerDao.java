package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
//	List<Employer> findAllByEmployer(String employer);
	Employer findByEmailEquals(String email);
	Employer findByPhoneNumberEquals(String phoneNumber);
	Employer findByWebAdressEquals(String webAdress);


}

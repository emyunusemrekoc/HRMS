package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerConfirmByEmployee;

public interface EmployerConfirmByEmployeeDao extends JpaRepository<EmployerConfirmByEmployee, Integer>{
	
	EmployerConfirmByEmployee findByEmployerId(int employerId);
	List<EmployerConfirmByEmployee> findAllByIsConfirmed(boolean isConfirmed);

}

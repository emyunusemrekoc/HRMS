package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;

public interface ConfirmByEmployeeDao extends JpaRepository<ConfirmByEmployee, Integer>{
	
	ConfirmByEmployee findByEmployerId(int employerId);
	List<ConfirmByEmployee> findAllByIsConfirmed(boolean isConfirmed);

}

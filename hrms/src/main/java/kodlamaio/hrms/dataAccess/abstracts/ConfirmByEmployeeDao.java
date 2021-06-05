package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;

public interface ConfirmByEmployeeDao extends JpaRepository<ConfirmByEmployee, Integer>{
	

//	ConfirmByEmployee findByEmployee_Id(int id);
	ConfirmByEmployee findByEmployerId(int employerId);
//	ConfirmByEmployee findByEmployer_IdAndEmployee_Id(int employerId,int employeeId);
}

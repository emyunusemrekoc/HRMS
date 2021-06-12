package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeEduDegree;

public interface ResumeEduDegreeDao extends JpaRepository<ResumeEduDegree, Integer>{
	
	
}

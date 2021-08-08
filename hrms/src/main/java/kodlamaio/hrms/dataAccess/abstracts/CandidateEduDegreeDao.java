package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateEduDegree;

public interface CandidateEduDegreeDao extends JpaRepository<CandidateEduDegree, Integer>{
	
	
}

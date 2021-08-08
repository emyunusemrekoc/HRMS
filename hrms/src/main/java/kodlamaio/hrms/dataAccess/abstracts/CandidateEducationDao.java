package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer>{
	
	List<CandidateEducation> findAllByCandidateId(int candidateId);
	List<CandidateEducation> findAllByCandidateIdOrderByEndDateDesc(int candidateId);

}

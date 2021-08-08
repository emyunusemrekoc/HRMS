package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCoverLetter;

public interface CandidateCoverLetterDao extends JpaRepository<CandidateCoverLetter, Integer>{
	
	List<CandidateCoverLetter> findAllByCandidateId(int candidateId);
	CandidateCoverLetter findByCandidateId(int candidateId);

}

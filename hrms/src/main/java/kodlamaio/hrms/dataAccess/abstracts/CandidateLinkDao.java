package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateLink;

public interface CandidateLinkDao extends JpaRepository<CandidateLink, Integer>{
	
	List<CandidateLink> findAllByCandidateId(int candidateId);

}

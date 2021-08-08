package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	Candidate findByEmailEquals(String email);
	
	Candidate findById(int id);

	Candidate findByIdentificationNumberEquals(String idenficationNumber);
	
	boolean existsByIdentificationNumber(String idenficationNumber);

}

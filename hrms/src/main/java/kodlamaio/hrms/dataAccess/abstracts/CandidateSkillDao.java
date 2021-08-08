package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateSkill;

public interface CandidateSkillDao extends JpaRepository<CandidateSkill, Integer>{
	
	//ResumeSkill findByResumeId(int resumeId);
	List<CandidateSkill> findAllByCandidateId(int candidateId);
	
	

}

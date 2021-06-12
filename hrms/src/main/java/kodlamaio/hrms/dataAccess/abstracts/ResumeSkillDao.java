package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeSkill;

public interface ResumeSkillDao extends JpaRepository<ResumeSkill, Integer>{
	
	//ResumeSkill findByResumeId(int resumeId);
	List<ResumeSkill> findAllByResumeId(int resumeId);

}

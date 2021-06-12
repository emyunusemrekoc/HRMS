package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeLanguage;
import kodlamaio.hrms.entities.concretes.ResumeSkill;

public interface ResumeLanguageDao extends JpaRepository<ResumeLanguage, Integer>{
	
	List<ResumeLanguage> findAllByResumeId(int resumeId);

}

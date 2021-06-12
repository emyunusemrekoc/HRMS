package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeEducation;

public interface ResumeEducationDao extends JpaRepository<ResumeEducation, Integer>{
	
	List<ResumeEducation> findAllByResumeId(int resumeId);
	List<ResumeEducation> findAllByResumeIdOrderByEndDateDesc(int resumeId);

}

package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeCoverLetter;

public interface ResumeCoverLetterDao extends JpaRepository<ResumeCoverLetter, Integer>{
	
	List<ResumeCoverLetter> findAllByResumeId(int resumeId);

}

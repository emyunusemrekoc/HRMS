package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeEducation;
import kodlamaio.hrms.entities.dtos.ResumeEducationDto;

public interface ResumeEducationService {
	
	Result add(ResumeEducationDto resumeEducationDto);
	DataResult<List<ResumeEducationDto>> findAllByResumeId(int resumeId);
	DataResult<List<ResumeEducationDto>> findAllByResumeIdOrderByEndDateDesc(int resumeId);
	Result addAll(List<ResumeEducation> resumeEducations);
	


}

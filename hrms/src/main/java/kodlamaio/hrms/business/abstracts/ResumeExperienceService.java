package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeEducationDto;
import kodlamaio.hrms.entities.dtos.ResumeExperienceDto;

public interface ResumeExperienceService {
	Result add(ResumeExperienceDto resumeLanguageDto);
	DataResult<List<ResumeExperienceDto>> findAllByResumeId(int resumeId);
	DataResult<List<ResumeExperienceDto>> findAllByResumeIdOrderByEndDateDesc(int resumeId);

}

package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;
import kodlamaio.hrms.entities.dtos.ResumeLanguageDto;

public interface ResumeLanguageService {
	
	Result add(ResumeLanguageDto resumeLanguageDto);
	DataResult<List<ResumeLanguageDto>> findAllByResumeId(int resumeId);
	Result addAll(List<ResumeLanguage> resumeLanguages);
}

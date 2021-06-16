package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeCoverLetter;
import kodlamaio.hrms.entities.dtos.ResumeCoverLetterDto;

public interface ResumeCoverLetterService {
	
	Result add(ResumeCoverLetterDto resumeCoverLetterDto);
	DataResult<List<ResumeCoverLetterDto>> findAllByResumeId(int resumeId);
	Result addAll(List<ResumeCoverLetter> resumeCoverLetters);

}

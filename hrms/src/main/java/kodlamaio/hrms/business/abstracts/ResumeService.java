package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeDto;
import kodlamaio.hrms.entities.dtos.ResumeUpdateDto;

public interface ResumeService {

	Result add(ResumeDto resumeDto);
	Result update(ResumeUpdateDto resumeUpdateDto,int candidateId,int resumeId);
	DataResult<List<ResumeDto>> findAllByCandidateId(int candidateId);
	Result findByCandidateIdAndResumeId(int candidateId,int resumeId);
	DataResult<List<ResumeDto>> findAll();
}
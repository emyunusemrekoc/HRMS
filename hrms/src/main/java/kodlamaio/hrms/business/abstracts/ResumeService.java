package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;
import kodlamaio.hrms.entities.dtos.ResumeUpdateDto;

public interface ResumeService {

	Result add(ResumeAddDto resumeAddDto);
	Result update(ResumeUpdateDto resumeUpdateDto,int candidateId,int resumeId);
	DataResult<List<ResumeGetDto>> findAllByCandidateId(int candidateId);
	Result findByCandidateIdAndResumeId(int candidateId,int resumeId);
	DataResult<List<ResumeGetDto>> findAll();
}
package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateEducation;
import kodlamaio.hrms.entities.dtos.CandidateEducationDto;
import kodlamaio.hrms.entities.dtos.CandidateEducationGetDto;

public interface CandidateEducationService {
	
	Result add(CandidateEducationDto candidateEducationDto);
	DataResult<List<CandidateEducationGetDto>> findAllByCandidateId(int candidateId);
	DataResult<List<CandidateEducationGetDto>> findAllByCandidateIdOrderByEndDateDesc(int candidateId);
	Result addAll(List<CandidateEducation> candidateEducations);
	Result deleteById(int candidateEducationId);
	


}

package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateExperience;
import kodlamaio.hrms.entities.dtos.CandidateExperienceDto;
import kodlamaio.hrms.entities.dtos.CandidateExperienceGetDto;

public interface CandidateExperienceService {
	Result add(CandidateExperienceDto candidateLanguageDto);
	DataResult<List<CandidateExperienceGetDto>> findAllByCandidateId(int candidateId);
	DataResult<List<CandidateExperienceGetDto>> findAllByCandidateIdOrderByEndDateDesc(int candidateId);
	Result addAll(List<CandidateExperience> candidateExperiences);
	Result deleteById(int candidateExperienceId);

}

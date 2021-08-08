package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.CandidateLanguageDto;

public interface CandidateLanguageService {
	
	Result add(CandidateLanguageDto candidateLanguageDto);
	DataResult<List<CandidateLanguageDto>> findAllByCandidateId(int candidateId);
	Result addAll(List<CandidateLanguage> candidateLanguages);
	Result deleteById(int candidateLanguageId);
}

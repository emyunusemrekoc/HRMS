package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLink;
import kodlamaio.hrms.entities.dtos.CandidateLinkDto;

public interface CandidateLinkService {
	
	Result add(CandidateLinkDto candidateLinkDto);
	DataResult<List<CandidateLinkDto>> findAllByCandidateId(int candidateId);
	Result addAll(List<CandidateLink> candidateLinks);
	Result deleteById(int candidateLinkId);
}

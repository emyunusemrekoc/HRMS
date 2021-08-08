package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateCoverLetter;
import kodlamaio.hrms.entities.dtos.CandidateCoverLetterDto;

public interface CandidateCoverLetterService {
	
	Result add(CandidateCoverLetterDto candidateCoverLetterDto);
	DataResult<List<CandidateCoverLetterDto>> findAllByCandidateId(int candidateId);
	Result addAll(List<CandidateCoverLetter> candidateCoverLetters);
	Result delete(CandidateCoverLetterDto candidateCoverLetterDto);
	DataResult<CandidateCoverLetter> findByCandidateId(int candidateId);
	public void coverLetterTableSetter(Candidate candidate)
;
}

package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSkill;
import kodlamaio.hrms.entities.dtos.CandidateSkillDto;

public interface CandidateSkillService {

	Result add(CandidateSkillDto candidateSkillDto);
	DataResult<List<CandidateSkillDto>> findAllByCandidateId(int candidateId);
	Result addAll(List<CandidateSkill> candidateSkills);
	Result deleteById(int candidateSkillId);

}

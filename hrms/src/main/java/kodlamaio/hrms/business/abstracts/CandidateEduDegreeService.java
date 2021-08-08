package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateEduDegreeDto;

public interface CandidateEduDegreeService {
	Result add(CandidateEduDegreeDto candidateEduDegreeDto);
	DataResult<List<CandidateEduDegreeDto>> findAll();
	

}

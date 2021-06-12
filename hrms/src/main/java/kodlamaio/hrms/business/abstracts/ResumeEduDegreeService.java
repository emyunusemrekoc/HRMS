package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeEduDegreeDto;

public interface ResumeEduDegreeService {
	Result add(ResumeEduDegreeDto resumeEduDegreeDto);
	DataResult<List<ResumeEduDegreeDto>> findAll();

}

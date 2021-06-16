package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLink;
import kodlamaio.hrms.entities.dtos.ResumeLinkDto;

public interface ResumeLinkService {
	
	Result add(ResumeLinkDto resumeLinkDto);
	DataResult<List<ResumeLinkDto>> findAllByResumeId(int resumeId);
	Result addAll(List<ResumeLink> resumeLinks);
}

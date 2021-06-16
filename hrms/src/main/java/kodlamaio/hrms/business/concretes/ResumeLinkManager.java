package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeLinkDao;
import kodlamaio.hrms.entities.concretes.ResumeLink;
import kodlamaio.hrms.entities.dtos.ResumeLinkDto;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;
@Service
public class ResumeLinkManager implements ResumeLinkService{
	

	private ResumeLinkDao resumeLinkDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public ResumeLinkManager(ResumeLinkDao resumeLinkDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeLinkDao = resumeLinkDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeLinkDto resumeLinkDto) {
		
		//resumeLinkDao.save(resumeLink);
		resumeLinkDao.save((ResumeLink) dtoConverterService.dtoToEntity(resumeLinkDto, ResumeLink.class));
		return new SuccessResult("Link eklendi");
	}

	@Override
	public DataResult<List<ResumeLinkDto>> findAllByResumeId(int resumeId) {
		
		return new SuccessDataResult<List<ResumeLinkDto>>(dtoConverterService.entityToDto(resumeLinkDao.findAllByResumeId(resumeId),ResumeLinkDto.class),"Linkler listelendi");
	}

	@Override
	public Result addAll(List<ResumeLink> resumeLinks) {
		resumeLinkDao.saveAll(resumeLinks);
		return new SuccessResult("Linkler eklendi");
	}

}

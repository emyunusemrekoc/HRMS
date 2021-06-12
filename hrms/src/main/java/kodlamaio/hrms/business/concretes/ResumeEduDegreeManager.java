package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeEduDegreeService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeEduDegreeDao;
import kodlamaio.hrms.entities.concretes.ResumeEduDegree;
import kodlamaio.hrms.entities.dtos.ResumeEduDegreeDto;
@Service
public class ResumeEduDegreeManager implements ResumeEduDegreeService	{
	
	private ResumeEduDegreeDao resumeEduDegreeDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public ResumeEduDegreeManager(ResumeEduDegreeDao resumeEduDegreeDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeEduDegreeDao = resumeEduDegreeDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeEduDegreeDto resumeEduDegreeDto) {
		

		resumeEduDegreeDao.save((ResumeEduDegree)dtoConverterService.dtoToEntity(resumeEduDegreeDto, ResumeEduDegree.class));
		return new SuccessResult("Eğitim derecesi eklendi");
	}

	@Override
	public DataResult<List<ResumeEduDegreeDto>> findAll() {
		
		return new SuccessDataResult<List<ResumeEduDegreeDto>>(dtoConverterService.entityToDto(resumeEduDegreeDao.findAll(),ResumeEduDegreeDto.class));
	
	}
}

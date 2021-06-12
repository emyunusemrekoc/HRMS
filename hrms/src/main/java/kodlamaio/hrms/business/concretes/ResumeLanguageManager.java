package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeLanguageDao;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;
import kodlamaio.hrms.entities.dtos.ResumeLanguageDto;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;
@Service
public class ResumeLanguageManager implements ResumeLanguageService{

	private ResumeLanguageDao resumeLanguageDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao,DtoConverterService dtoConverterService) {
		super();
		this.resumeLanguageDao = resumeLanguageDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeLanguageDto resumeLanguageDto) {
		
		resumeLanguageDao.save((ResumeLanguage)dtoConverterService.dtoToEntity(resumeLanguageDto, ResumeLanguage.class));
		return new SuccessResult("Dil eklendi");
	}
	
	@Override
	public DataResult<List<ResumeLanguageDto>> findAllByResumeId(int resumeId) {
		
		return new SuccessDataResult<List<ResumeLanguageDto>>(dtoConverterService.entityToDto(resumeLanguageDao.findAllByResumeId(resumeId),ResumeLanguageDto.class),"Diller listelendi");
	}

}

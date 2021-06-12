package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeExperienceDao;
import kodlamaio.hrms.entities.concretes.ResumeExperience;
import kodlamaio.hrms.entities.dtos.ResumeEducationDto;
import kodlamaio.hrms.entities.dtos.ResumeExperienceDto;

@Service
public class ResumeExperienceManager implements ResumeExperienceService{
	
	private ResumeExperienceDao resumeExperienceDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public ResumeExperienceManager(ResumeExperienceDao resumeExperienceDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeExperienceDao = resumeExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeExperienceDto resumeExperienceDto) {
		
		if (resumeExperienceDto.getEndDate() != null && !resumeExperienceDto.getStartedDate().before(resumeExperienceDto.getEndDate())) {
			return new ErrorResult("Bitiş tarihi, başlama tarihiniden önce olamaz"); 
		}
		
		resumeExperienceDao.save((ResumeExperience)dtoConverterService.dtoToEntity(resumeExperienceDto, ResumeExperience.class));
		return new SuccessResult("Deneyim eklendi");
	}
	

	@Override
	public DataResult<List<ResumeExperienceDto>> findAllByResumeId(int resumeId) {
		
		return new SuccessDataResult<List<ResumeExperienceDto>>(dtoConverterService.entityToDto(resumeExperienceDao.findAllByResumeId(resumeId),ResumeExperienceDto.class),"Deneyimler listelendi");
	}

	@Override
	public DataResult<List<ResumeExperienceDto>> findAllByResumeIdOrderByEndDateDesc(int resumeId) {
		
		return new SuccessDataResult<List<ResumeExperienceDto>>(dtoConverterService.entityToDto(resumeExperienceDao.findAllByResumeIdOrderByEndDateDesc(resumeId),ResumeExperienceDto.class)," Deneyimler yıllara göre(azalan) listelendi");
	}

}

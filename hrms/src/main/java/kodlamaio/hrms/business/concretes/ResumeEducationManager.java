package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeEducationService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeEducationDao;
import kodlamaio.hrms.entities.concretes.ResumeEducation;
import kodlamaio.hrms.entities.dtos.ResumeEducationDto;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

@Service
public class ResumeEducationManager implements ResumeEducationService{

	private ResumeEducationDao resumeEducationDao;
	private DtoConverterService dtoConverterService;
	
	
	public ResumeEducationManager(ResumeEducationDao resumeEducationDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeEducationDao = resumeEducationDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeEducationDto resumeEducationDto) {
		
		if (resumeEducationDto.getEndDate() != null && !resumeEducationDto.getStartedDate().before(resumeEducationDto.getEndDate())) {
			return new ErrorResult("Bitiş tarihi, başlama tarihiniden önce olamaz"); 
		}
		
		resumeEducationDao.save((ResumeEducation)dtoConverterService.dtoToEntity(resumeEducationDto, ResumeEducation.class));
		return new SuccessResult("Eğitim bilgisi eklendi");
	}

	@Override
	public DataResult<List<ResumeEducationDto>> findAllByResumeId(int resumeId) {
		
		return new SuccessDataResult<List<ResumeEducationDto>>(dtoConverterService.entityToDto(resumeEducationDao.findAllByResumeId(resumeId),ResumeEducationDto.class),"Eğitimler listelendi");
	}

	@Override
	public DataResult<List<ResumeEducationDto>> findAllByResumeIdOrderByEndDateDesc(int resumeId) {
		return new SuccessDataResult<List<ResumeEducationDto>>(dtoConverterService.entityToDto(resumeEducationDao.findAllByResumeIdOrderByEndDateDesc(resumeId),ResumeEducationDto.class),"Eğitimler mezuniyet yılına göre listelendi");
	}

}

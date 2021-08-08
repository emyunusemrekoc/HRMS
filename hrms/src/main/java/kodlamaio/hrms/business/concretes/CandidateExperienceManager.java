package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateExperienceService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateExperience;
import kodlamaio.hrms.entities.dtos.CandidateExperienceDto;
import kodlamaio.hrms.entities.dtos.CandidateExperienceGetDto;

@Service
public class CandidateExperienceManager implements CandidateExperienceService{
	
	private CandidateExperienceDao candidateExperienceDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao, DtoConverterService dtoConverterService) {
		super();
		this.candidateExperienceDao = candidateExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CandidateExperienceDto candidateExperienceDto) {
		
//		if (candidateExperienceDto.getEndDate() != null && !candidateExperienceDto.getStartedDate().before(candidateExperienceDto.getEndDate())) {
//			return new ErrorResult("Bitiş tarihi, başlama tarihiniden önce olamaz"); 
//		}
		
		candidateExperienceDao.save((CandidateExperience)dtoConverterService.dtoToEntity(candidateExperienceDto, CandidateExperience.class));
		return new SuccessResult("Deneyim eklendi");
	}
	

	@Override
	public DataResult<List<CandidateExperienceGetDto>> findAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CandidateExperienceGetDto>>(dtoConverterService.entityToDto(candidateExperienceDao.findAllByCandidateId(candidateId),CandidateExperienceGetDto.class),"Deneyimler listelendi");
	}

	@Override
	public DataResult<List<CandidateExperienceGetDto>> findAllByCandidateIdOrderByEndDateDesc(int candidateId) {
		
		return new SuccessDataResult<List<CandidateExperienceGetDto>>(dtoConverterService.entityToDto(candidateExperienceDao.findAllByCandidateIdOrderByEndDateDesc(candidateId),CandidateExperienceGetDto.class)," Deneyimler yıllara göre(azalan) listelendi");
	}

	@Override
	public Result addAll(List<CandidateExperience> candidateExperiences) {
		candidateExperienceDao.saveAll(candidateExperiences);
		return new SuccessResult("Tecrübe bilgileri eklendi");
	}

	@Override
	public Result deleteById(int candidateExperienceId) {
		candidateExperienceDao.deleteById(candidateExperienceId);
		//candidateExperienceDao.delete((CandidateExperience)dtoConverterService.dtoToEntity(candidateExperienceDto, CandidateExperience.class));
		return new SuccessResult("Deneyim silindi");
	}

}

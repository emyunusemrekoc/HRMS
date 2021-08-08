package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateEducationService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateEducationDao;
import kodlamaio.hrms.entities.concretes.CandidateEducation;
import kodlamaio.hrms.entities.dtos.CandidateEducationDto;
import kodlamaio.hrms.entities.dtos.CandidateEducationGetDto;

@Service
public class CandidateEducationManager implements CandidateEducationService{

	private CandidateEducationDao candidateEducationDao;
	private DtoConverterService dtoConverterService;
	
	
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao, DtoConverterService dtoConverterService) {
		super();
		this.candidateEducationDao = candidateEducationDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CandidateEducationDto candidateEducationDto) {
		
//		if (candidateEducationDto.getEndDate() != null && !candidateEducationDto.getStartedDate().before(candidateEducationDto.getEndDate())) {
//			return new ErrorResult("Bitiş tarihi, başlama tarihiniden önce olamaz"); 
//		}
		
		candidateEducationDao.save((CandidateEducation)dtoConverterService.dtoToEntity(candidateEducationDto, CandidateEducation.class));
		return new SuccessResult("Eğitim bilgisi eklendi");
	}

	@Override
	public DataResult<List<CandidateEducationGetDto>> findAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CandidateEducationGetDto>>(dtoConverterService.entityToDto(candidateEducationDao.findAllByCandidateId(candidateId),CandidateEducationGetDto.class),"Eğitimler listelendi");
	}

	@Override
	public DataResult<List<CandidateEducationGetDto>> findAllByCandidateIdOrderByEndDateDesc(int candidateId) {
		return new SuccessDataResult<List<CandidateEducationGetDto>>(dtoConverterService.entityToDto(candidateEducationDao.findAllByCandidateIdOrderByEndDateDesc(candidateId),CandidateEducationGetDto.class),"Eğitimler mezuniyet yılına göre listelendi");
	}

	@Override
	public Result addAll(List<CandidateEducation> candidateEducations) {
		candidateEducationDao.saveAll(candidateEducations);
		return new SuccessResult("Eğitim bilgileri eklendi");
	}

	@Override
	public Result deleteById(int candidateEducationId) {
//		candidateEducationDao.delete((CandidateEducation)dtoConverterService.dtoToEntity(candidateEducationDto, CandidateEducation.class));
		candidateEducationDao.deleteById(candidateEducationId);
		return new SuccessResult("Eğitim bilgisi silindi");
	}

}

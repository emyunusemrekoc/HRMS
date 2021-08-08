package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.CandidateLanguageDto;
@Service
public class CandidateLanguageManager implements CandidateLanguageService{

	private CandidateLanguageDao candidateLanguageDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao,DtoConverterService dtoConverterService) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CandidateLanguageDto candidateLanguageDto) {
		
		candidateLanguageDao.save((CandidateLanguage)dtoConverterService.dtoToEntity(candidateLanguageDto, CandidateLanguage.class));
		return new SuccessResult("Dil eklendi");
	}
	
	@Override
	public DataResult<List<CandidateLanguageDto>> findAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CandidateLanguageDto>>(dtoConverterService.entityToDto(candidateLanguageDao.findAllByCandidateId(candidateId),CandidateLanguageDto.class),"Diller listelendi");
	}

	
	@Override
	public Result addAll(List<CandidateLanguage> candidateLanguage) {
		candidateLanguageDao.saveAll(candidateLanguage);
			return new SuccessResult("Diller eklendi");
	}

	@Override
	public Result deleteById(int candidateLanguageId) {
		candidateLanguageDao.deleteById(candidateLanguageId);
		//candidateLanguageDao.delete((CandidateLanguage)dtoConverterService.dtoToEntity(candidateLanguageDto, CandidateLanguage.class));
		return new SuccessResult("Dil silindi");
	}

}


package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateLinkService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLinkDao;
import kodlamaio.hrms.entities.concretes.CandidateLink;
import kodlamaio.hrms.entities.dtos.CandidateLinkDto;
@Service
public class CandidateLinkManager implements CandidateLinkService{
	

	private CandidateLinkDao candidateLinkDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateLinkManager(CandidateLinkDao candidateLinkDao, DtoConverterService dtoConverterService) {
		super();
		this.candidateLinkDao = candidateLinkDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CandidateLinkDto candidateLinkDto) {
		
		//resumeLinkDao.save(resumeLink);
		candidateLinkDao.save((CandidateLink) dtoConverterService.dtoToEntity(candidateLinkDto, CandidateLink.class));
		return new SuccessResult("Link eklendi");
	}

	@Override
	public DataResult<List<CandidateLinkDto>> findAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CandidateLinkDto>>(dtoConverterService.entityToDto(candidateLinkDao.findAllByCandidateId(candidateId),CandidateLinkDto.class),"Linkler listelendi");
	}

	@Override
	public Result addAll(List<CandidateLink> candidateLinks) {
		candidateLinkDao.saveAll(candidateLinks);
		return new SuccessResult("Linkler eklendi");
	}

	@Override
	public Result deleteById(int candidateLinkId) {
		candidateLinkDao.deleteById(candidateLinkId);
		//candidateLinkDao.delete((CandidateLink) dtoConverterService.dtoToEntity(candidateLinkId, CandidateLink.class));
		return new SuccessResult("Link silindi");
	}

}

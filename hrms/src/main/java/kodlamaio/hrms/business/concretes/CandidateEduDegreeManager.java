package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateEduDegreeService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateEduDegreeDao;
import kodlamaio.hrms.entities.concretes.CandidateEduDegree;
import kodlamaio.hrms.entities.dtos.CandidateEduDegreeDto;
@Service
public class CandidateEduDegreeManager implements CandidateEduDegreeService	{
	
	private CandidateEduDegreeDao candidateEduDegreeDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateEduDegreeManager(CandidateEduDegreeDao candidateEduDegreeDao, DtoConverterService dtoConverterService) {
		super();
		this.candidateEduDegreeDao = candidateEduDegreeDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CandidateEduDegreeDto candidateEduDegreeDto) {
		

		candidateEduDegreeDao.save((CandidateEduDegree)dtoConverterService.dtoToEntity(candidateEduDegreeDto, CandidateEduDegree.class));
		return new SuccessResult("Eğitim derecesi eklendi");
	}

	@Override
	public DataResult<List<CandidateEduDegreeDto>> findAll() {
		
		return new SuccessDataResult<List<CandidateEduDegreeDto>>(dtoConverterService.entityToDto(candidateEduDegreeDao.findAll(),CandidateEduDegreeDto.class));
	
	}
}

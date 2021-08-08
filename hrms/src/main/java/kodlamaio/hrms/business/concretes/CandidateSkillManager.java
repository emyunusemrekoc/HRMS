package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateSkillService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSkillDao;
import kodlamaio.hrms.entities.concretes.CandidateSkill;
import kodlamaio.hrms.entities.dtos.CandidateSkillDto;

@Service
public class CandidateSkillManager implements CandidateSkillService {

	private CandidateSkillDao candidateSkillDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateSkillManager(CandidateSkillDao candidateSkillDao, DtoConverterService dtoConverterService) {
		super();
		this.candidateSkillDao = candidateSkillDao;
		this.dtoConverterService = dtoConverterService;
	}
	
	@Override
	public Result add(CandidateSkillDto candidateSkillDto) {
		
		candidateSkillDao.save((CandidateSkill) dtoConverterService.dtoToEntity(candidateSkillDto, CandidateSkill.class));
		
		return new SuccessResult("Yetenek eklendi");
	}

	@Override
	public DataResult<List<CandidateSkillDto>> findAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CandidateSkillDto>>(dtoConverterService.entityToDto(candidateSkillDao.findAllByCandidateId(candidateId),CandidateSkillDto.class),"Yetenekler listelendi");
	}

	@Override
	public Result addAll(List<CandidateSkill> candidateSkills) {
		candidateSkillDao.saveAll(candidateSkills);
		return new SuccessResult("Yetenekler eklendi");
	}

	@Override
	public Result deleteById(int candidateSkillId) {
		candidateSkillDao.deleteById(candidateSkillId);
		//candidateSkillDao.delete((CandidateSkill) dtoConverterService.dtoToEntity(candidateSkillDto, CandidateSkill.class));
		
		return new SuccessResult("Yetenek silindi");
	}

	

}

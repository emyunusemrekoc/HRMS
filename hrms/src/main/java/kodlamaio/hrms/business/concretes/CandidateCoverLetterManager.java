package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCoverLetterService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCoverLetterDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateCoverLetter;
import kodlamaio.hrms.entities.dtos.CandidateCoverLetterDto;
@Service
public class CandidateCoverLetterManager implements CandidateCoverLetterService{

	private CandidateCoverLetterDao candidateCoverLetterDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateCoverLetterManager(CandidateCoverLetterDao candidateCoverLetterDao,
			DtoConverterService dtoConverterService) {
		super();
		this.candidateCoverLetterDao = candidateCoverLetterDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CandidateCoverLetterDto candidateCoverLetterDto) {
		CandidateCoverLetter coverLetter = candidateCoverLetterDao.findByCandidateId(candidateCoverLetterDto.getCandidateId());
		coverLetter.setCoverLetter(candidateCoverLetterDto.getCoverLetter());
		candidateCoverLetterDao.save(coverLetter);
		//candidateCoverLetterDao.save((CandidateCoverLetter)dtoConverterService.dtoToEntity(candidateCoverLetterDto, CandidateCoverLetter.class));
		return new SuccessResult("Ön yazı eklendi");
	}

	@Override
	public DataResult<List<CandidateCoverLetterDto>> findAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CandidateCoverLetterDto>>(dtoConverterService.entityToDto(candidateCoverLetterDao.findAllByCandidateId(candidateId),CandidateCoverLetterDto.class),"Ön yazılar listelendi");
	}

	@Override
	public Result addAll(List<CandidateCoverLetter> candidateCoverLetters) {
		candidateCoverLetterDao.saveAll(candidateCoverLetters);
		return new SuccessResult("Önyazı bilgisi eklendi");
	}

	@Override
	public Result delete(CandidateCoverLetterDto candidateCoverLetterDto) {
		candidateCoverLetterDao.delete((CandidateCoverLetter)dtoConverterService.dtoToEntity(candidateCoverLetterDto, CandidateCoverLetter.class));
		return new SuccessResult("Ön yazı silindi");
	}

	@Override
	public DataResult<CandidateCoverLetter> findByCandidateId(int candidateId) {
		
		return new SuccessDataResult<CandidateCoverLetter>(candidateCoverLetterDao.findByCandidateId(candidateId));
	}
	
	@Override
	public void coverLetterTableSetter(Candidate candidate) {
		
		CandidateCoverLetter candidateCoverLetter = new CandidateCoverLetter();
		candidateCoverLetter.setCandidate(candidate);
		this.candidateCoverLetterDao.save(candidateCoverLetter);
	}


}

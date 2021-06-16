package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeCoverLetterService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeCoverLetterDao;
import kodlamaio.hrms.entities.concretes.ResumeCoverLetter;
import kodlamaio.hrms.entities.dtos.ResumeCoverLetterDto;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;
@Service
public class ResumeCoverLetterManager implements ResumeCoverLetterService{

	private ResumeCoverLetterDao resumeCoverLetterDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public ResumeCoverLetterManager(ResumeCoverLetterDao resumeCoverLetterDao,
			DtoConverterService dtoConverterService) {
		super();
		this.resumeCoverLetterDao = resumeCoverLetterDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeCoverLetterDto resumeCoverLetterDto) {
		resumeCoverLetterDao.save((ResumeCoverLetter)dtoConverterService.dtoToEntity(resumeCoverLetterDto, ResumeCoverLetter.class));
		return new SuccessResult("Ön yazı eklendi");
	}

	@Override
	public DataResult<List<ResumeCoverLetterDto>> findAllByResumeId(int resumeId) {
		
		return new SuccessDataResult<List<ResumeCoverLetterDto>>(dtoConverterService.entityToDto(resumeCoverLetterDao.findAllByResumeId(resumeId),ResumeCoverLetterDto.class),"Ön yazılar listelendi");
	}

	@Override
	public Result addAll(List<ResumeCoverLetter> resumeCoverLetters) {
		resumeCoverLetterDao.saveAll(resumeCoverLetters);
		return new SuccessResult("Önyazı bilgisi eklendi");
	}

}

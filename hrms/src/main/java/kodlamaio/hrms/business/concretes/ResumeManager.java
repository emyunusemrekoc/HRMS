package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeCoverLetterService;
import kodlamaio.hrms.business.abstracts.ResumeEducationService;
import kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;
import kodlamaio.hrms.entities.dtos.ResumeUpdateDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private DtoConverterService dtoConverterService;
	private ResumeLanguageService resumeLanguageService;
	private ResumeSkillService resumeSkillService;
	private ResumeLinkService resumeLinkService;
	private ResumeExperienceService resumeExperienceService;
	private ResumeEducationService resumeEducationService;
	private ResumeCoverLetterService resumeCoverLetterService;
	
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, DtoConverterService dtoConverterService,
			ResumeLanguageService resumeLanguageService, ResumeSkillService resumeSkillService,
			ResumeLinkService resumeLinkService, ResumeExperienceService resumeExperienceService,
			ResumeEducationService resumeEducationService, ResumeCoverLetterService resumeCoverLetterService) {
		super();
		this.resumeDao = resumeDao;
		this.dtoConverterService = dtoConverterService;
		this.resumeLanguageService = resumeLanguageService;
		this.resumeSkillService = resumeSkillService;
		this.resumeLinkService = resumeLinkService;
		this.resumeExperienceService = resumeExperienceService;
		this.resumeEducationService = resumeEducationService;
		this.resumeCoverLetterService = resumeCoverLetterService;
	}

	@Override
	public Result add(ResumeDto resumeDto) {
		
		if(resumeDao.findByResumeNameAndCandidateId(resumeDto.getResumeName(),resumeDto.getCandidateId())==null) {
		
		resumeDto.setCreatedDate(LocalDateTime.now());
		resumeDao.save((Resume) dtoConverterService.dtoToEntity(resumeDto, Resume.class));
		
		//resumeAddDto.getLanguages().forEach(cvEducation -> cvEducation.setResume(resumeDao.findByCandidateId(resumeAddDto.getCandidateId())));
		resumeDto.getLanguages().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeDto.getResumeName(),resumeDto.getCandidateId())));
		resumeLanguageService.addAll(resumeDto.getLanguages());
		
		resumeDto.getSkills().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeDto.getResumeName(),resumeDto.getCandidateId())));
		resumeSkillService.addAll(resumeDto.getSkills());
		
		resumeDto.getLinks().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeDto.getResumeName(),resumeDto.getCandidateId())));
		resumeLinkService.addAll(resumeDto.getLinks());
		
		resumeDto.getExperiences().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeDto.getResumeName(),resumeDto.getCandidateId())));
		resumeExperienceService.addAll(resumeDto.getExperiences());
		
		resumeDto.getEducations().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeDto.getResumeName(),resumeDto.getCandidateId())));
		resumeEducationService.addAll(resumeDto.getEducations());
		
		resumeDto.getCoverLetters().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeDto.getResumeName(),resumeDto.getCandidateId())));
		resumeCoverLetterService.addAll(resumeDto.getCoverLetters());
		
		return new SuccessResult("Özgeçmiş eklendi");
		}{
			return new ErrorResult("Aynı isimde iki tane cv olamaz");
		}
	}

	@Override
	public Result update(ResumeUpdateDto resumeUpdateDto, int candidateId, int resumeId) {
		ResumeDto updateDto = (ResumeDto) dtoConverterService.dtoToEntity(resumeDao.findByIdAndCandidateId(resumeId,candidateId), ResumeDto.class);
		updateDto.setAbout(resumeUpdateDto.getAbout());
		updateDto.setResumeName(resumeUpdateDto.getResumeName());
		updateDto.setUpdatedDate(LocalDateTime.now());
	
		
		resumeDao.save((Resume) dtoConverterService.dtoToEntity(updateDto, Resume.class));
		return new SuccessResult("Özgeçmiş güncellendi");
	}



	@Override
	public DataResult<List<ResumeDto>> findAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<ResumeDto>>(dtoConverterService.entityToDto(resumeDao.findAllByCandidateId(candidateId),ResumeDto.class),"Cvler listelendi");
	}

	@Override
	public Result findByCandidateIdAndResumeId(int candidateId,int resumeId) {
		
		return new SuccessDataResult<List<ResumeDto>>(dtoConverterService.entityToDto(resumeDao.findByCandidateIdAndId(candidateId,resumeId),ResumeDto.class),"Cv listelendi");
	}


	@Override
	public DataResult<List<ResumeDto>> findAll() {
		return new SuccessDataResult<List<ResumeDto>>(dtoConverterService.entityToDto(resumeDao.findAll(),ResumeDto.class),"Cvler listelendi");
	}


}

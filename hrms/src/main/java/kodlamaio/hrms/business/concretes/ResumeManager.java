package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;
import kodlamaio.hrms.entities.dtos.ResumeUpdateDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private DtoConverterService dtoConverterService;
	

	@Autowired
	public ResumeManager(ResumeDao resumeDao,DtoConverterService dtoConverterService) {
		super();
		this.resumeDao = resumeDao;
		this.dtoConverterService = dtoConverterService;
		
	}

	
	
	@Override
	public Result add(ResumeAddDto resumeAddDto) {
		
		
		resumeAddDto.setCreatedDate(LocalDateTime.now());
		
		resumeDao.save((Resume) dtoConverterService.dtoToEntity(resumeAddDto, Resume.class));
		return new SuccessResult("Özgeçmiş eklendi");
	}

	@Override
	public Result update(ResumeUpdateDto resumeUpdateDto, int candidateId, int resumeId) {
		ResumeAddDto updateDto = (ResumeAddDto) dtoConverterService.dtoToEntity(resumeDao.findByIdAndCandidateId(resumeId,candidateId), ResumeAddDto.class);
		updateDto.setAbout(resumeUpdateDto.getAbout());
		updateDto.setResumeName(resumeUpdateDto.getResumeName());
		updateDto.setUpdatedDate(LocalDateTime.now());
	
		
		resumeDao.save((Resume) dtoConverterService.dtoToEntity(updateDto, Resume.class));
		return new SuccessResult("Özgeçmiş güncellendi");
	}



	@Override
	public DataResult<List<ResumeGetDto>> findAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<ResumeGetDto>>(dtoConverterService.entityToDto(resumeDao.findAllByCandidateId(candidateId),ResumeGetDto.class),"Cvler listelendi");
	}

	@Override
	public Result findByCandidateIdAndResumeId(int candidateId,int resumeId) {
		
		return new SuccessDataResult<List<ResumeGetDto>>(dtoConverterService.entityToDto(resumeDao.findByCandidateIdAndId(candidateId,resumeId),ResumeGetDto.class),"Cv listelendi");
	}


	@Override
	public DataResult<List<ResumeGetDto>> findAll() {
		return new SuccessDataResult<List<ResumeGetDto>>(dtoConverterService.entityToDto(resumeDao.findAll(),ResumeGetDto.class),"Cvler listelendi");
	}








}

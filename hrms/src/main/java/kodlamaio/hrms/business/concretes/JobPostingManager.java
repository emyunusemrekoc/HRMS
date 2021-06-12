package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	private DtoConverterService dtoConverterService;

	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, DtoConverterService dtoConverterService) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.dtoConverterService = dtoConverterService;
	}



	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		this.jobPostingDao.save( (JobPosting) dtoConverterService.dtoToEntity(jobPostingAddDto,JobPosting.class));
		return new SuccessResult("İş ilanı başarılı bir şekilde oluşturuldu");
	}

	@Override
	public Result delete(int id) { 
		if(this.jobPostingDao.findById(id)==null) {
			return new ErrorResult("İlan bulunamadı");
		}
		else {
		
			this.jobPostingDao.deleteById(id);
		return new SuccessResult("İş ilanı başarılı bir şekilde silindi");
		}
	}
	
	@Override
	public DataResult<List<JobPostingDto>> findAllByIsActive(boolean isActive) {
		
		return new SuccessDataResult<List<JobPostingDto>>(dtoConverterService.entityToDto(jobPostingDao.findAllByIsActive(true),JobPostingDto.class)
				,"Aktif olan tüm ilanlar(Firma adı, açık pozisyon sayısı, yayın tarihi, son başvuru tarihi) listelendi");
	}

	@Override
	public DataResult<List<JobPostingDto>> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive) {
		
		return new SuccessDataResult<List<JobPostingDto>>(dtoConverterService.entityToDto(jobPostingDao.findAllByIsActiveOrderByCreatedDateDesc(true),JobPostingDto.class)
				,"Aktif olan tüm ilanlar(Firma adı, açık pozisyon sayısı, yayın tarihi, son başvuru tarihi) tarih(Yeniden Eskiye)  göre listelendi");
	}


	@Override
	public DataResult<List<JobPostingDto>> findAllByIsActiveOrderByCreatedDateAsc(boolean isActive) {
		return new SuccessDataResult<List<JobPostingDto>>(dtoConverterService.entityToDto(jobPostingDao.findAllByIsActiveOrderByCreatedDateAsc(true),JobPostingDto.class)
				,"Aktif olan tüm ilanlar(Firma adı, açık pozisyon sayısı, yayın tarihi, son başvuru tarihi) tarihe(Eskiden Yeniye) göre listelendi");
	}
	
	@Override
	public DataResult<List<JobPostingDto>> findAllByIsActiveAndEmployer_CompanyName(boolean isActive,String employerName) {
		
		return new SuccessDataResult<List<JobPostingDto>>(dtoConverterService.entityToDto(jobPostingDao.findAllByIsActiveAndEmployer_CompanyName(true,employerName),JobPostingDto.class)
				,"Firmanın aktif olan tüm ilanları(Firma adı, açık pozisyon sayısı, yayın tarihi, son başvuru tarihi)  listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> findAll() {
		
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll(),"Bütün ilanlarListelendi");
	}
	
	@Override
	public Result isActive(int id,int employerId,boolean isActive) {
		JobPosting posting = jobPostingDao.findByIdAndEmployerId(id, employerId);
		if(!posting.isActive() && isActive) {
		
		
		posting.setActive(true);
		this.jobPostingDao.save(posting);
		
		return new SuccessResult("İlan aktif duruma getirildi");
		}else if(posting.isActive() && !isActive) {
			
		posting.setActive(false);
		this.jobPostingDao.save(posting);
		
		return new SuccessResult("İlan pasif duruma getirildi"); 
	}
		else if(posting.isActive() && isActive) {
			return new ErrorResult("İlan zaten aktif");
		}
		else if(!posting.isActive() && !isActive) {
			return new ErrorResult("İlan zaten pasif");
		}
		
		
		else {
			return new ErrorResult("Null değer girdiniz");
		}
	}




	
}

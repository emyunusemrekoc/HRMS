package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingConfirmByEmployeeService;
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
import kodlamaio.hrms.entities.dtos.JobPostingGetDto;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	private DtoConverterService dtoConverterService;
	private JobPostingConfirmByEmployeeService jobPostingConfirmByEmployeeService; 

	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, DtoConverterService dtoConverterService,
			JobPostingConfirmByEmployeeService jobPostingConfirmByEmployeeService)
	{
		super();
		this.jobPostingDao = jobPostingDao;
		this.dtoConverterService = dtoConverterService;
		this.jobPostingConfirmByEmployeeService = jobPostingConfirmByEmployeeService;
	}



	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		
		jobPostingAddDto.setCreatedDate(LocalDate.now());
		JobPosting jobPosting = (JobPosting) dtoConverterService.dtoToEntity(jobPostingAddDto,JobPosting.class);
		jobPosting.setId(jobPostingAddDto.getId());
		jobPosting.setActive(false);
		
		jobPostingDao.save( jobPosting);
		jobPostingConfirmByEmployeeService.confirmTableSetter(jobPosting);
		
		return new SuccessResult("İş ilanı başarılı bir şekilde oluşturuldu, onay için hrms çalışanlarına gönderildi.");
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
	public DataResult<List<JobPostingGetDto>> findAllByIsActive() {
		
		return new SuccessDataResult<List<JobPostingGetDto>>(dtoConverterService.entityToDto(jobPostingDao.findAllByIsActive(true),JobPostingGetDto.class)
				,"Aktif olan tüm ilanlar(Firma adı, açık pozisyon sayısı, yayın tarihi, son başvuru tarihi) listelendi");
	}

	@Override
	public DataResult<List<JobPostingGetDto>> findAllByIsActiveOrderByCreatedDateDesc() {
		
		return new SuccessDataResult<List<JobPostingGetDto>>(dtoConverterService.entityToDto(jobPostingDao.findAllByIsActiveOrderByCreatedDateDesc(true),JobPostingGetDto.class)
				,"Aktif olan tüm ilanlar(Firma adı, açık pozisyon sayısı, yayın tarihi, son başvuru tarihi) tarih(Yeniden Eskiye)  göre listelendi");
	}


	@Override
	public DataResult<List<JobPostingGetDto>> findAllByIsActiveOrderByCreatedDateAsc() {
		return new SuccessDataResult<List<JobPostingGetDto>>(dtoConverterService.entityToDto(jobPostingDao.findAllByIsActiveOrderByCreatedDateAsc(true),JobPostingGetDto.class)
				,"Aktif olan tüm ilanlar(Firma adı, açık pozisyon sayısı, yayın tarihi, son başvuru tarihi) tarihe(Eskiden Yeniye) göre listelendi");
	}
	
	@Override
	public DataResult<List<JobPostingGetDto>> findAllByIsActiveAndEmployer_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobPostingGetDto>>(dtoConverterService.entityToDto(jobPostingDao.findAllByIsActiveAndEmployer_CompanyName(true,companyName),JobPostingGetDto.class)
				,"Firmanın aktif olan tüm ilanları(Firma adı, açık pozisyon sayısı, yayın tarihi, son başvuru tarihi)  listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> findAll() {
		
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll(),"Bütün ilanlarListelendi");
	}
	
	@Override
	public Result isActive(int id,int employerId,boolean isActive) {
		JobPosting posting = jobPostingDao.findByIdAndEmployerId(id, employerId);
//		if(!posting.isActive() && isActive) {
//		
//		
//		posting.setActive(true);
//		this.jobPostingDao.save(posting);
//		
//		return new SuccessResult("İlan aktif duruma getirildi");
//		}
//		else if(posting.isActive() && isActive) {
//		return new ErrorResult("İlan zaten aktif");
//	}
	 	if(posting.isActive() && !isActive) {
			
		posting.setActive(false);
		this.jobPostingDao.save(posting);
		
		return new SuccessResult("İlan pasif duruma getirildi"); 
	}

		else if(!posting.isActive() && !isActive) {
			return new ErrorResult("İlan zaten pasif");
		}
		
		
		else {
			return new ErrorResult("Null değer girdiniz");
		}
	}



	@Override
	public DataResult<JobPosting> findById(int jobPostingId) {
		
		return new SuccessDataResult<JobPosting>(jobPostingDao.findById(jobPostingId));
	}








	
}

package kodlamaio.hrms.business.concretes;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.UserPhotoService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.cloudinary.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
@Service
public class UserPhotoManager implements UserPhotoService{

	private UserDao userDao;
	private CloudinaryService cloudinaryService;
	

	public UserPhotoManager(UserDao userDao, CloudinaryService cloudinaryService) {
		super();
		this.userDao = userDao;
		this.cloudinaryService = cloudinaryService;
	}
	@Override
	public Result addPhoto(MultipartFile file, int userId) {
	
		//if(userDao.find)==null)
		
			@SuppressWarnings("unchecked")
			Map<String, String> uploader = (Map<String, String>) 
					cloudinaryService.save(file).getData(); 
			String imageUrl= uploader.get("url");
			User userPhoto = userDao.findById(userId);
			userPhoto.setPhotoUrl(imageUrl);
			userDao.save(userPhoto);
			return new SuccessResult("Fotoğraf ekleme başarılı");
					
	}
	
	@Override
	public Result deletePhoto(MultipartFile file, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

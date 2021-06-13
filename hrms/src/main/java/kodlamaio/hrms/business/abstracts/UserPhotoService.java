package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.Result;

public interface UserPhotoService {

	Result addPhoto(MultipartFile file, int userId);
	Result deletePhoto(MultipartFile file, int userId);
	public void photoTableSetter(User user);
}

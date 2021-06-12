package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.UserPhotoService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/userPhotos")
public class UserPhotosController {
	
	private UserPhotoService userPhotoService;

	@Autowired
	public UserPhotosController(UserPhotoService userPhotoService) {
		super();
		this.userPhotoService = userPhotoService;
	}
	
	@PutMapping("/addPhoto")
	public Result addPhoto(MultipartFile file, int userId) {
		
		return userPhotoService.addPhoto(file, userId);
	}

}

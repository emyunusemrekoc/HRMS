package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserPhoto;

public interface UserPhotoDao extends JpaRepository<UserPhoto, Integer>{
	
	UserPhoto findByUserId(int userId);

}

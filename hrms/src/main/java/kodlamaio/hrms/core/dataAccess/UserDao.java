package kodlamaio.hrms.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	//User findByEmail(String email); // verilen email kaydini getirir
	
	List<User> findAllByEmail(String email); // hepsini getirir
	User findById(int userId);

}

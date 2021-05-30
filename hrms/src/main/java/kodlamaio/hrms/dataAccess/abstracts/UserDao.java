package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	//User findByEmail(String email); // verilen email kaydini getirir
	
	List<User> findAllByEmail(String email); // hepsini getirir

}

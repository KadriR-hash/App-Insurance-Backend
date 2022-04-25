package tn.enicarthage.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.springboot.Entity.Role;
import tn.enicarthage.springboot.Entity.User;
import tn.enicarthage.springboot.Repository.RegisterRepository;

@Service
public class RegisterService{

	@Autowired
	private RegisterRepository repo;
	
	public User saveUser ( User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public User fetchUserByEmailAndPassword(String email,String password) {
		return repo.findByEmailAndPassword(email,password);
	}

	public List<User> findAllUsers() {
			return repo.findAll();
	}
	public List<User> fetchUserByRole(Role role){
		return repo.findByRole(role);
		
	}


}

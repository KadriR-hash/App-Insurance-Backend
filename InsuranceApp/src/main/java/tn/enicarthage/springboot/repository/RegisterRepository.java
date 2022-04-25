package tn.enicarthage.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.enicarthage.springboot.Entity.Role;
import tn.enicarthage.springboot.Entity.User;

public interface RegisterRepository extends JpaRepository<User,Long> {

	public User findByEmail(String email);

	public User findByEmailAndPassword(String email, String password);

	public List<User> findByRole(Role role);

	

}

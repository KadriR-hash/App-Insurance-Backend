package tn.enicarthage.springboot.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/*import org.springframework.web.bind.annotation.CrossOrigin;*/
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.enicarthage.springboot.Entity.Role;
import tn.enicarthage.springboot.Entity.User;
import tn.enicarthage.springboot.Service.RegisterService;

@RestController
public class RegisterController {

		@Autowired
		private RegisterService service;
		
		@PostMapping("/registeruser")
		/*@CrossOrigin(origins ="http://localhost:4200")*/
		public User RegisterUser (@RequestBody User user) throws Exception {
			String tempemail = user.getEmail();
			
			user.setRole(Role.Simpleuser);
			
			if (tempemail != null && !"".equals(tempemail)) {
				User userobj = service.fetchUserByEmail(tempemail);
				if (userobj != null) {
					throw new Exception("user with "+tempemail+"is already existing .");
				}
			}
			User userObj = null;
			userObj = service.saveUser(user);
			return userObj;
		
		} 
		
		@PostMapping("/login")
		/*@CrossOrigin(origins ="http://localhost:4200")*/
		public User loginUser (@RequestBody User user) throws Exception {
			String tempEmail = user.getEmail();
			String tempPass = user.getPassword();
			User userObj = null;
			if (tempEmail != null && tempPass != null) {
				 userObj = service.fetchUserByEmailAndPassword(tempEmail, tempPass);
				
			}
			if (userObj == null) {
				throw new Exception("Bad Credentials");
			}
			return userObj;
		}
		
		@CrossOrigin(origins ="http://localhost:4200")
		@GetMapping("/finduser/{user}")
		public Long findUserId (@PathVariable("user") User user) {
			Long user_id = service.fetchUserByEmail(user.getEmail()).getId();
			return user_id;
			
		}
		
		
		
		@GetMapping("/listusers")
	    public ResponseEntity<List<User>> getAllUser(){
	        List<User> users = service.findAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }
		
		
		
}		


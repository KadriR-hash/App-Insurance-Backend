package tn.enicarthage.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.springboot.EnrollementRequest;
import tn.enicarthage.springboot.Entity.Enrollement;
import tn.enicarthage.springboot.Service.EnrollementService;

@RestController
public class EnrollementController {
		@Autowired
		private  EnrollementService enrollementService ;

		public EnrollementController (EnrollementService enrollementService) {
			this.enrollementService =enrollementService;
		}
		
	/*	@PostMapping("/addEnroll")
		 public ResponseEntity<Enrollement> addEnrollement(@RequestBody Enrollement enrollement){
			
			 Enrollement newEnrol = enrollementService.addEnrollement(enrollement);
		     return new ResponseEntity<>(newEnrol,HttpStatus.CREATED);
		}*/
		
		@PostMapping("/addEnroll")
		public Enrollement addEnrollement(@RequestBody EnrollementRequest request ) {
			return enrollementService.addEnrollement(request);
		}
		
		
				 
		@GetMapping("/allEnrolls")
	    public ResponseEntity<List<Enrollement>> getAllEnrollements(){
	        List<Enrollement> enrollements = enrollementService.findAllEnrollement();  	        
	        return new ResponseEntity<>(enrollements, HttpStatus.OK);
	    }
		

		
		
		
		
}

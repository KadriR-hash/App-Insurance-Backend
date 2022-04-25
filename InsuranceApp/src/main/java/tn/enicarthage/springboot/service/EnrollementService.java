package tn.enicarthage.springboot.Service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.enicarthage.springboot.EnrollementRequest;
import tn.enicarthage.springboot.Entity.Enrollement;
import tn.enicarthage.springboot.Entity.Plan;
import tn.enicarthage.springboot.Entity.User;
import tn.enicarthage.springboot.Repository.EnrollementRepository;
import tn.enicarthage.springboot.Repository.PlanRepo;
import tn.enicarthage.springboot.Repository.RegisterRepository;


@Service
@Transactional
public class EnrollementService {
	@Autowired
	private  EnrollementRepository enrollementRepo;
	private  PlanRepo planRepo;
	private  RegisterRepository  registerRepo;
    
    public EnrollementService(EnrollementRepository enrollementRepo,PlanRepo planRepo,RegisterRepository  registerRepo) {
        this.enrollementRepo = enrollementRepo;
        this.planRepo=planRepo;
        this.registerRepo=registerRepo;
    }
   
   /* 
    public Enrollement addEnrollement(Enrollement enrollement){
    return enrollementRepo.save(enrollement);
    }*/
    
    public Enrollement addEnrollement(EnrollementRequest request) {
    	
    	Long user_id =request.getUser_id();
    	Long plan_id =request.getPlan_id() ;
    	
    	String date = request.getDate();  
    	Long Telenum =request.getTelenum();
    	String adrrs = request.getAdrrs();
    	
       if (user_id == null) {
            throw new IllegalArgumentException("Id of User you want  is  null");}
        if (plan_id == null) {
            throw new IllegalArgumentException("Id of Plan you want  is  null");}
   
        Plan plan = planRepo.findById(plan_id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find plan with this id: " + plan_id));
        User user = registerRepo.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find user with this id: " + user_id));
               
    	Enrollement enrollement =new Enrollement();
    	
    	enrollement.setUserc(user);
    	enrollement.setPlanc(plan);
    	
    	
    	enrollement.setDate(date);
    	enrollement.setAdrrs(adrrs);
    	enrollement.setTelenum(Telenum);
    	
    
		return enrollementRepo.save(enrollement);
    	
    }
    
    public List<Enrollement> findAllEnrollement(){
        return enrollementRepo.findAll();
    }
    
    
    
    
}

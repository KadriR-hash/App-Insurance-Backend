package tn.enicarthage.springboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import tn.enicarthage.springboot.model.*;
import tn.enicarthage.springboot.exception.*;
import tn.enicarthage.springboot.repository.*;

@Service
@Transactional
public class PlanService {
    private final PlanRepo planRepo ;
    
    @Autowired
    public PlanService(PlanRepo planRepo) {
        this.planRepo = planRepo;
    }

    public Plan addPlan(Plan plan){
    return planRepo.save(plan);
    }
    public List<Plan> findAllPlan(){
        return planRepo.findAll();
    }
    public Plan updatePlan(Plan plan){
        return planRepo.save(plan);
    }
    public Plan findPlanById(Long id) {
        return planRepo.findPlanById(id).orElseThrow(()-> new UserNotFoundException("Plan by Id"+id+"was not found"));
    }

    public void deletePlan(Long id){
    	planRepo.deletePlanById(id);
    }

}

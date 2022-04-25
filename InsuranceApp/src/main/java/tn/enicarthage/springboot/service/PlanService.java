package tn.enicarthage.springboot.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import tn.enicarthage.springboot.Entity.Plan;
import tn.enicarthage.springboot.Exception.UserNotFoundException;
import tn.enicarthage.springboot.Repository.PlanRepo;



@Service
@Transactional
public class PlanService {
	@Autowired
    private  PlanRepo planRepo ;
    
    
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

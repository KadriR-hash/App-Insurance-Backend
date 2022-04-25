package tn.enicarthage.springboot.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.enicarthage.springboot.Entity.Plan;
import tn.enicarthage.springboot.Service.PlanService;

import java.util.List;

//CONTROLLER

@RestController
@RequestMapping("/plan")
public class PlanController {
	@Autowired
    private  PlanService planService;
    
    public PlanController(PlanService planService) {
		
		this.planService = planService;
	}
    
	@GetMapping("/all")
    public ResponseEntity<List<Plan>> getAllPlan(){
        List<Plan> plans = planService.findAllPlan();
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }
    @GetMapping("find/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable("id") Long id){
        Plan plan = planService.findPlanById(id);
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Plan> addPlan(@RequestBody Plan plan){

        Plan newPlan = planService.addPlan(plan);
        return new ResponseEntity<>(newPlan,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Plan> updatePlan(@RequestBody Plan plan){
        Plan updatePlan = planService.updatePlan(plan);
        return new ResponseEntity<>(updatePlan,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlan(@PathVariable("id") Long id){
        planService.deletePlan(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}

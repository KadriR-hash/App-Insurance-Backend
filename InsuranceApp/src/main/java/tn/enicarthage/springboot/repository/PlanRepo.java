package tn.enicarthage.springboot.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import tn.enicarthage.springboot.Entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Long> {
	
    void deletePlanById(Long id);//Query method : spring understands it !
    
    Optional<Plan> findPlanById(Long id);
}

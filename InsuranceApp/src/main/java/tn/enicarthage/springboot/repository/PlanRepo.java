package tn.enicarthage.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.springboot.model.Plan;

public interface PlanRepo extends JpaRepository<Plan, Long> {
	
    void deletePlanById(Long id);//Query method : spring understands it !
    
    Optional<Plan> findPlanById(Long id);
}

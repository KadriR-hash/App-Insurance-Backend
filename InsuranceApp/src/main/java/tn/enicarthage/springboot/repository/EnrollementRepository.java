package tn.enicarthage.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.enicarthage.springboot.Entity.Enrollement;



public interface EnrollementRepository extends JpaRepository<Enrollement, Long>{
	
}
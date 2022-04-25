package tn.enicarthage.springboot.Entity;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;

@Entity
@Builder
@Table(name = "T_enrollements")
@JsonIgnoreProperties("inspection")
public class Enrollement implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long En_id;

	@Column(name="Date_of_Birth")
	private String date;
	@Column(name = "Phone_number")
	private Long Telenum;
	@Column(name = "Current_Adresse")
	private String adrrs;

	@JsonBackReference(value="user-enrollement")
	@ManyToOne(fetch = FetchType.EAGER  ,cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User userc;
	
	@JsonBackReference(value="plan-enrollement")
	@ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	@JoinColumn(name = "plan_id")
	private Plan planc;
	

	public Enrollement() {

	}



	public Enrollement(Long En_id, String date, Long Telenum, String adrrs, User userc, Plan planc) {
		
		this.En_id = En_id;
		this.date = date;
		this.Telenum = Telenum;
		this.adrrs = adrrs;
		this.userc = userc;
		this.planc = planc;
	}
	public Enrollement( String date, Long Telenum, String adrrs) {
		
	
		this.date = date;
		this.Telenum = Telenum;
		this.adrrs = adrrs;

	}



	public Long getEn_id() {
		return En_id;
	}



	public void setEn_id(Long En_id) {
		this.En_id = En_id;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public Long getTelenum() {
		return Telenum;
	}



	public void setTelenum(Long Telenum) {
		this.Telenum = Telenum;
	}



	public String getAdrrs() {
		return adrrs;
	}



	public void setAdrrs(String adrrs) {
		this.adrrs = adrrs;
	}



	public User getUserc() {
		return userc;
	}



	public void setUserc(User userc) {
		this.userc = userc;
	}



	public Plan getPlanc() {
		return planc;
	}



	public void setPlanc(Plan planc) {
		this.planc = planc;
	}



	@Override
	public String toString() {
		return "Enrollement [En_id=" + En_id + ", date=" + date + ", Telenum=" + Telenum + ", adrrs=" + adrrs
				+ ", userc=" + userc + ", planc=" + planc + "]";
	}



	
	
	



}

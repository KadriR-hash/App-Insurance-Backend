package tn.enicarthage.springboot.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author hpUser
 *
 */
@Entity
public class Plan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
	private Long id;
	private String provider;
	@Column(nullable = false)
	private Float price;
	private String feature;
	private String doctorcoverage;
	private String drugcoverage;
	private String imageUrl;
	
	
public Plan() {}


public Plan(Long id, String provider, Float price, String feature, String doctorcoverage, String drugcoverage,String imageUrl) {
	
	this.id = id;
	this.provider = provider;
	this.price = price;
	this.feature = feature;
	this.doctorcoverage = doctorcoverage;
	this.drugcoverage = drugcoverage;
	this.imageUrl = imageUrl;
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getProvider() {
	return provider;
}



public void setProvider(String provider) {
	this.provider = provider;
}



public Float getPrice() {
	return price;
}



public void setPrice(Float price) {
	this.price = price;
}



public String getFeature() {
	return feature;
}



public void setFeature(String feature) {
	this.feature = feature;
}



public String getDoctorcoverage() {
	return doctorcoverage;
}



public void setDoctorcoverage(String doctorcoverage) {
	this.doctorcoverage = doctorcoverage;
}



public String getDrugcoverage() {
	return drugcoverage;
}



public void setDrugcoverage(String drugcoverage) {
	this.drugcoverage = drugcoverage;
}



public String getImageUrl() {
	return imageUrl;
}



public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}



@Override
public String toString() {
	return "Plan [id=" + id + ", provider=" + provider + ", price=" + price + ", feature=" + feature+ ", doctorcoverage=" + doctorcoverage + ", drugcoverage=" + drugcoverage + ", imageUrl=" + imageUrl + "]";
}




	
}

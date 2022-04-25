package tn.enicarthage.springboot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollementRequest {

	private String date;
	private Long Telenum;
	private String adrrs;
	private Long user_id;
	private Long plan_id;

	public EnrollementRequest() {

	}

	public EnrollementRequest(String date, Long telenum, String adrrs, Long user_id, Long plan_id) {

		this.date = date;
		this.Telenum = telenum;
		this.adrrs = adrrs;
		this.user_id = user_id;
		this.plan_id = plan_id;
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

	public void setTelenum(Long telenum) {
		Telenum = telenum;
	}

	public String getAdrrs() {
		return adrrs;
	}

	public void setAdrrs(String adrrs) {
		this.adrrs = adrrs;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(Long plan_id) {
		this.plan_id = plan_id;
	}

}

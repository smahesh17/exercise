package test.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Model that holds the Ad capmaign details
 * @author Mahesh
 *
 */
@Entity
public class Ad implements Serializable {

	@Id
	@NotNull
	@Column(name = "partner_id", nullable = false)
	private String partner_id;


	@NotNull
	@Column(name = "duration", nullable = false)
	private long duration;
	

	@NotNull
	@Column(name = "ad_content", nullable = false)	
	private String ad_content;

	Ad() {

	}

	public Ad(String partner_id, Long duration, String ad_content) {
		this.partner_id = partner_id;
		this.duration = duration;
		this.ad_content = ad_content;
	}

	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getAd_content() {
		return ad_content;
	}

	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
}

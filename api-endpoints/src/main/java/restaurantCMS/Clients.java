package restaurantCMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="ClientDetails")
@EntityListeners(AuditingEntityListener.class)

public class Clients {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable=false)
	private Long mobile;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String paymentMethod;
	
	@Column(nullable=false)
	private Float billAmount;
	
	@Column(nullable=false)
	private String date;
	
	public String getDate() {
		return date;
	}

	public Clients(Long mobile, String email, String name, String paymentMethod, Float billAmount,
			String date) {
		super();
		this.mobile = mobile;
		this.email = email;
		this.name = name;
		this.paymentMethod = paymentMethod;
		this.billAmount = billAmount;
		this.date = date;
	}

	public Clients() {
		// TODO Auto-generated constructor stub
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Float billAmount) {
		this.billAmount = billAmount;
	}


	
}

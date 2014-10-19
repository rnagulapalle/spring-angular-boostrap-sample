package com.eoutletz.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "Payment_Type")
public class PaymentType implements Serializable {

	private static final long serialVersionUID = -6778310087309472867L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
	
	@Column(name = "type", nullable = false)
	private String type;
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paymentType")
	private Set<Order> orders = new HashSet<Order>(0);
	
	   @Column(name = "create_date	",
	            nullable = false,
	            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	    @Generated(value = GenerationTime.INSERT)
	    protected Date createdTime;

	    @Column(name = "update_date",
	            nullable = false,
	            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	    @Generated(value = GenerationTime.ALWAYS)
	    protected Date updatedTime;

	    public Date getCreatedTime() {
	        return createdTime;
	    }

	    public Date getUpdatedTime() {
	        return updatedTime;
	    }

		public void setCreatedTime(Date createdTime) {
			this.createdTime = createdTime;
		}

		public void setUpdatedTime(Date updatedTime) {
			this.updatedTime = updatedTime;
		}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}

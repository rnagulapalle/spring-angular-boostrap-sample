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
@Table(name = "Order_Status")
public class OrderStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
	
	@Column(name = "status", nullable = false)
	private Integer status;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderStatus")
	private Set<OrderTracking> orderTrackings = new HashSet<OrderTracking>(0);
	
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


	public Set<OrderTracking> getOrderTrackings() {
		return orderTrackings;
	}

	public void setOrderTrackings(Set<OrderTracking> orderTrackings) {
		this.orderTrackings = orderTrackings;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}

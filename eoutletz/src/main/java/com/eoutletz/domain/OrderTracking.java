package com.eoutletz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "Order_Tracking",
uniqueConstraints = { @UniqueConstraint(columnNames = { "tracking_number", "order_id", "order_status_id" }) })
public class OrderTracking implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
	
	@Column(name = "tracking_number", nullable = false)
	private String trackingNumber;
	
	@Column(name = "comments")
	private String comments;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Orders order;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_status_id")
	private OrderStatus orderStatus;
	
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


	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
}

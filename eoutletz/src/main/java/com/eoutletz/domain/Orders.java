package com.eoutletz.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Orders")
public class Orders implements Serializable, Comparable<Orders> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_type_id")
	private PaymentType paymentType;

	@Column(name = "amount")
	protected Long amount;

	@Column(name = "tracking_number")
	@NotBlank
	private String trackingNumber;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "partner_id")
	private Partner partner;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_status_id")
	private OrderStatus orderStatus;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")
	private Set<Product> products = new HashSet<Product>(0);

	@Column(name = "create_date	", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Generated(value = GenerationTime.INSERT)
	protected Date createdTime;

	@Column(name = "update_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public int compareTo(Orders orders) {

		Date updatedTime = ((Orders) orders).getUpdatedTime();

		// ascending order
		return this.updatedTime.compareTo(updatedTime);

		// descending order
		// return compareQuantity - this.quantity;
	}

	public static Comparator<Orders> OrdersUpdateTimeComparator = new Comparator<Orders>() {

		public int compare(Orders orders1, Orders orders2) {

			Date updatedTime1 = orders1.getUpdatedTime();
			Date updatedTime2 = orders2.getUpdatedTime();

			// ascending order
			return updatedTime2.compareTo(updatedTime1);

			// descending order
			// return fruitName2.compareTo(fruitName1);
		}

	};

	public static Comparator<Orders> OrdersCreatedTimeComparator = new Comparator<Orders>() {

		public int compare(Orders orders1, Orders orders2) {

			Date createdTime1 = orders1.getCreatedTime();
			Date createdTime2 = orders2.getCreatedTime();

			// ascending order
			return createdTime1.compareTo(createdTime2);

			// descending order
			// return fruitName2.compareTo(fruitName1);
		}

	};

	public static <T extends Comparable<? super T>> List<Orders> asSortedList(
			Collection<T> c) {
		List<Orders> list = (List<Orders>) new ArrayList<T>(c);
		Collections.sort(list, OrdersCreatedTimeComparator);
		return list;
	}
}
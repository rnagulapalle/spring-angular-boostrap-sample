package com.eoutletz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Product")
public class Product implements Serializable, Comparable<Product> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;

	@Column(name = "name", nullable = false)
	@NotEmpty
	private String name;

	@Column(name = "sku", nullable = false)
	private String sku;

	@Column(name = "price", nullable = false)
	@NotNull
	private BigDecimal price;

	@Column(name = "description", nullable = false)
	@NotEmpty
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "partner_id")
	private Partner partner;

	@Column(name = "quantity", nullable = false)
	@NotNull
	private Long quantity;

	@Column(name = "msrp", nullable = false)
	private BigDecimal msrp;

	@Column(name = "units_in_stock", nullable = true)
	private Long unitsInStock;

	@Column(name = "units_in_order", nullable = true)
	private Long unitsInOrder;

	@Column(name = "unit_price", nullable = true)
	private BigDecimal unitPrice;
	
	@Column(name = "likes", nullable = true)
	private Long likes;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Product_Category", joinColumns = { @JoinColumn(name = "product_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "category_id", nullable = false, updatable = false) })
	private Set<Category> categories = new HashSet<Category>(0);
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Product_User_Likes", joinColumns = { @JoinColumn(name = "product_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
	private Set<User> userLikes = new HashSet<User>(0);
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Product_User_Reviews", joinColumns = { @JoinColumn(name = "product_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
	private Set<User> userReviews = new HashSet<User>(0);

	// @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinTable(name = "Product_Color", joinColumns = { @JoinColumn(name =
	// "product_id", nullable = false, updatable = false) }, inverseJoinColumns
	// = { @JoinColumn(name = "color_id", nullable = false, updatable = false)
	// })
	// private Set<Color> colors = new HashSet<Color>(0);

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "size_id")
	private Size size;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_cost_id")
	private ShippingCharge shippingCharge;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sale_percentage")
	private Sale sale;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Product_Order", joinColumns = { @JoinColumn(name = "product_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "order_id", nullable = false, updatable = false) })
	private Set<Orders> orders = new HashSet<Orders>(0);

	@OneToMany(targetEntity = Image.class, fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Image> images = new HashSet<Image>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String decription) {
		this.description = decription;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getMsrp() {
		return msrp;
	}

	public void setMsrp(BigDecimal msrp) {
		this.msrp = msrp;
	}

	public Long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(Long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	// public Set<Color> getColors() {
	// return colors;
	// }
	//
	// public void setColors(Set<Color> colors) {
	// this.colors = colors;
	// }

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public ShippingCharge getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(ShippingCharge shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Set<User> getUserLikes() {
		return userLikes;
	}

	public void setUserLikes(Set<User> userLikes) {
		this.userLikes = userLikes;
	}

	public Set<User> getUserReviews() {
		return userReviews;
	}

	public void setUserReviews(Set<User> userReviews) {
		this.userReviews = userReviews;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	@Override
	public int compareTo(Product product) {

		Date updatedTime = ((Product) product).getUpdatedTime();

		// ascending order
		return this.updatedTime.compareTo(updatedTime);

		// descending order
		// return compareQuantity - this.quantity;
	}

	public static Comparator<Product> ProductUpdateTimeComparator = new Comparator<Product>() {

		public int compare(Product prod1, Product prod2) {

			Date updatedTime1 = prod1.getUpdatedTime();
			Date updatedTime2 = prod2.getUpdatedTime();

			// ascending order
			return updatedTime2.compareTo(updatedTime1);

			// descending order
			// return fruitName2.compareTo(fruitName1);
		}

	};
	
	public static <T extends Comparable<? super T>> List<Product> asSortedList(Collection<T> c) {
	  List<Product> list = (List<Product>) new ArrayList<T>(c);
	  Collections.sort(list, ProductUpdateTimeComparator);
	  return list;
	}
}

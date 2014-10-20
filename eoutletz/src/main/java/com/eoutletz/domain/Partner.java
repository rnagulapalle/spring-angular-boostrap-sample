package com.eoutletz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "Partner")
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "name")
	private String name;
	

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "partner")
//	private Set<PartnerContact> partnerContacts = new HashSet<PartnerContact>(0);
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "partner")
//	private Set<Product> products = new HashSet<Product>(0);

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
	
//	public Set<PartnerContact> getPartnerContacts() {
//		return partnerContacts;
//	}
//	public void setPartnerContacts(Set<PartnerContact> partnerContacts) {
//		this.partnerContacts = partnerContacts;
//	}
	
//	public Set<Product> getProducts() {
//		return products;
//	}
//	
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}
}

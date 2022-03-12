package com.maxtrain.capstone.product;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maxtrain.capstone.request.Request;
import com.maxtrain.capstone.requestline.Requestline;
import com.maxtrain.capstone.vendor.Vendor;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(name="UIDX_partnbr", columnNames={"partnbr"}))
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=30, nullable=false)
	private String partnbr;
	@Column(length=30, nullable=false)
	private String name;
	@Column(columnDefinition="decimal(9,2) not null default 0")
	private double price;
	@Column(length=30, nullable=false)
	private String unit;
	@Column(length=255, nullable=true)
	private String photoPath;
	
	@JsonBackReference
	@ManyToOne(optional=false)
	@JoinColumn(name="vendorId")
	private Vendor vendor;
	
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
//	@JsonManagedReference
//	@OneToMany(mappedBy="requestline")
//	private List<Requestline> requestlines;
//
//	public List<Requestline> getRequestlines() {
//		return requestlines;
//	}
//
//	public void setRequestlines(List<Requestline> requestlines) {
//		this.requestlines = requestlines;
//	}

	public Product() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartnbr() {
		return partnbr;
	}

	public void setPartnbr(String partnbr) {
		this.partnbr = partnbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	
}

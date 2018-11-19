package com.teamsankya.shoppingcart.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductBean {
	@Id
	@Column(name="id_product")
	private int product_Id;
	@Column(name="name")
	private String product_Name;
	@Column(name="price")
	private double product_Price;
	@Column(name="description")
	private String product_disc;
	@Column(name="imgloc")
	private String product_Imgloc;
	
	public String getProduct_Imgloc() {
		return product_Imgloc;
	}
	public void setProduct_Imgloc(String imgloc) {
		this.product_Imgloc = imgloc;
	}
	public String getProduct_disc() {
		return product_disc;
	}
	public void setProduct_disc(String pdisc) {
		this.product_disc = pdisc;
	}
	public int getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(int pId) {
		this.product_Id = pId;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String pName) {
		this.product_Name = pName;
	}
	public double getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(double pPrice) {
		this.product_Price = pPrice;
	}
	@Override
	public String toString() {
		return "Product [pId=" + product_Id + ", pName=" + product_Name + ", pPrice=" + product_Price + ", pdisc=" + product_disc + "]";
	}
	

}

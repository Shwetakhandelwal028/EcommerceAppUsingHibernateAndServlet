package com.shweta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="e_items")
public class Items {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="item_id")
	private long itemId;
    
    @Column(name="quantity")
	private int quantity;
    
    @Column(name="item_name")
	private String itemName;
    
    @Column(name="total_price")
	private double totalPrice;
    
    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;
    
    public Items() {
    	
    }

	public Items(int quantity, String itemName, double totalPrice) {
		super();
		this.quantity = quantity;
		this.itemName = itemName;
		this.totalPrice = totalPrice;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
    
    
	
	
}


package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CartItem 
{
	@Id
	@GeneratedValue
	private int cartId;
	private int quantity;
	private String userName;
	private String paymentStatus;
	private int subTotal;
	private int productId;
	private int cartItemId;
	
		public int getCartItemId() {
			return cartItemId;
		}
		public void setCartItemId(int cartItemId) {
			this.cartItemId = cartItemId;
		}
		public int getCartId() {
			return cartId;
		}
		public void setCartId(int cartId) {
			this.cartId = cartId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPaymentStatus() {
			return paymentStatus;
		}
		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}
		public int getSubTotal() {
			return subTotal;
		}
		public void setSubTotal(int subTotal) {
			this.subTotal = subTotal;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
	}
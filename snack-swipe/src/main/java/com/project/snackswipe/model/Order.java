package com.project.snackswipe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
public class Order {
	@Id
    private String id;
    private String prnOrEmployeeId;
    private List<CartItem> cart;
    private int totalAmount;
    private String paymentStatus;
   private String qrData;
    private boolean isUsed; // Flag to track QR code usage
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdDate;

    public Order()
    {
    	
    }

	

	

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrnOrEmployeeId() {
		return prnOrEmployeeId;
	}

	public void setPrnOrEmployeeId(String prnOrEmployeeId) {
		this.prnOrEmployeeId = prnOrEmployeeId;
	}

	public List<CartItem> getCart() {
		return cart;
	}

	public void setCart(List<CartItem> cart) {
		this.cart = cart;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}





	public String getQrData() {
		return qrData;
	}





	public void setQrData(String qrData) {
		this.qrData = qrData;
	}
	

    
}

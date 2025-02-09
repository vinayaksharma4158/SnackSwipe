package com.project.snackswipe.model;


public class CartItem {
     
	 private String food;
	    private int quantity;
		
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public String getFood() {
			return food;
		}
		public void setFood(String food) {
			this.food = food;
		}
	    
}
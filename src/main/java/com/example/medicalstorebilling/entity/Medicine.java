package com.example.medicalstorebilling.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "medicines")
public class Medicine {
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;
		
		@Column(name="name")
		private String mName;
		
		@Column(name="manufacturer")
		private String manufacturerName;
		
		@Column(name = "price")
		private double price;
		
		@Column (name = "quantity")
		private int quantity;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getmName() {
			return mName;
		}

		public void setmName(String mName) {
			this.mName = mName;
		}

		public String getManufacturerName() {
			return manufacturerName;
		}

		public void setManufacturerName(String manufacturerName) {
			this.manufacturerName = manufacturerName;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "Medicine [id=" + id + ", mName=" + mName + ", manufacturerName=" + manufacturerName + ", price="
					+ price + ", quantity=" + quantity + "]";
		}
		
		
	
	
}

package com.xyz.bususer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BusRoutes")
public class BusUser {
		
		@Id
		@Column 
		private int routeNumber;
		@Column
		private String sourceCity;
		@Column
		private String destinationCity;
		@Column
		private String status;
		public BusUser() {
			super();
			// TODO Auto-generated constructor stub
		}
		public BusUser(int routeNumber, String sourceCity, String destinationCity, String status) {
			super();
			this.routeNumber = routeNumber;
			this.sourceCity = sourceCity;
			this.destinationCity = destinationCity;
			this.status = status;
		}
		public int getRouteNumber() {
			return routeNumber;
		}
		public void setRouteNumber(int routeNumber) {
			this.routeNumber = routeNumber;
		}
		public String getSourceCity() {
			return sourceCity;
		}
		public void setSourceCity(String sourceCity) {
			this.sourceCity = sourceCity;
		}
		public String getDestinationCity() {
			return destinationCity;
		}
		public void setDestinationCity(String destinationCity) {
			this.destinationCity = destinationCity;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "BusUser [routeNumber=" + routeNumber + ", sourceCity=" + sourceCity + ", destinationCity="
					+ destinationCity + ", status=" + status + "]";
		}
		
		
		
		

}

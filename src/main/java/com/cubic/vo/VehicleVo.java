package com.cubic.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VehicleVo {
	private Long id;
	private String vehicle_make;
	private String vehicle_model;
	private Long vehicle_year;
	private String vehicle_vin;
	private String vehicle_color;
	private String vehicle_status;
	private String vehicle_type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicle_make() {
		return vehicle_make;
	}

	public void setVehicle_make(String vehicle_make) {
		this.vehicle_make = vehicle_make;
	}

	public String getVehicle_model() {
		return vehicle_model;
	}

	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}

	public Long getVehicle_year() {
		return vehicle_year;
	}

	public void setVehicle_year(Long vehicle_year) {
		this.vehicle_year = vehicle_year;
	}

	public String getVehicle_vin() {
		return vehicle_vin;
	}

	public void setVehicle_vin(String vehicle_vin) {
		this.vehicle_vin = vehicle_vin;
	}

	public String getVehicle_color() {
		return vehicle_color;
	}

	public void setVehicle_color(String vehicle_color) {
		this.vehicle_color = vehicle_color;
	}

	public String getVehicle_status() {
		return vehicle_status;
	}

	public void setVehicle_status(String vehicle_status) {
		this.vehicle_status = vehicle_status;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	@Override
	public String toString() {
		return "VehicleVo [id=" + id + ", vehicle_make=" + vehicle_make + ", vehicle_model=" + vehicle_model
				+ ", vehicle_year=" + vehicle_year + ", vehicle_vin=" + vehicle_vin + ", vehicle_color=" + vehicle_color
				+ ", vehicle_status=" + vehicle_status + ", vehicle_type=" + vehicle_type + "]";
	}

}

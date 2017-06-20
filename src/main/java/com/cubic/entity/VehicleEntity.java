package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cubic.service.QueryConstant;

@Entity
@Table(name = "VEHICLE")
@NamedQueries({ @NamedQuery(name = QueryConstant.GET_ALL_VEHICLE, query = "select c from VehicleEntity c"),
		@NamedQuery(name = QueryConstant.QUERY_SEARCH_BY_VEHICLE_VIN, query = "select c from VehicleEntity c where upper(c.vehicle_vin) like upper(?)"),
		@NamedQuery(name = QueryConstant.SEARCH_BY_VEHICLE_NAME, query = "select c from VehicleEntity c where upper(c.vehicle_make) like upper(?) or upper(c.vehicle_model) like upper(?)"),
		@NamedQuery(name = QueryConstant.SEARCH_BY_VEHICLE_MAKE, query = "select c from VehicleEntity c where upper(c.vehicle_make) like upper(?)")

})
public class VehicleEntity {
	@Id
	@SequenceGenerator(name = "veh_Seq", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "veh_Seq")
	@Column(name = "VEHICLE_ID")
	private Long id;
	@Column(name = "VEHICLE_MAKE")
	private String vehicle_make;
	@Column(name = "VEHICLE_MODEL")
	private String vehicle_model;
	@Column(name = "VEHICLE_YEAR")
	private Long vehicle_year;
	@Column(name = "VEHICLE_VIN")
	private String vehicle_vin;
	@Column(name = "VEHICLE_COLOR")
	private String vehicle_color;
	@Column(name = "VEHICLE_STATUS")
	private String vehicle_status;
	@Column(name = "VEHICLE_TYPE")
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
		return "VehicleEntity [id=" + id + ", vehicle_make=" + vehicle_make + ", vehicle_model=" + vehicle_model
				+ ", vehicle_year=" + vehicle_year + ", vehicle_vin=" + vehicle_vin + ", vehicle_color=" + vehicle_color
				+ ", vehicle_status=" + vehicle_status + ", vehicle_type=" + vehicle_type + "]";
	}

}

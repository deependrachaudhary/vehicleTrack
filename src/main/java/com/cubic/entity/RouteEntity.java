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
@Table(name = "VEHICLE_ROUTE")
@NamedQueries({
		@NamedQuery(name = QueryConstant.ROUTE_SEARCH_BY_CITY, query = "select c from RouteEntity c where upper(c.startCity) like upper(?)"),
		@NamedQuery(name = QueryConstant.ROUTE_SEARCH_BY_END_DEST, query = "select c from RouteEntity c where upper(c.endDestination) like upper(?)"),
		@NamedQuery(name = QueryConstant.ROUTE_GETALL_ROUTE, query = "select c from RouteEntity c"),
		@NamedQuery(name = QueryConstant.ROUTE_SEARCH_BY_ROUTENAME, query = "select c from RouteEntity c where upper(c.routeName) like upper(?)")

})
public class RouteEntity {

	@Id
	@SequenceGenerator(name = "rt_seq", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "rt_seq")
	@Column(name = "ROUTE_ID")
	private Long id;
	@Column(name = "ROUTE_START_CITY")
	private String startCity;
	@Column(name = "ROUTE_END_DESTINATION")
	private String endDestination;
	@Column(name = "ROUTE_START_TIME")
	private String startTime;
	@Column(name = "ROUTE_END_TIME")
	private String endTime;
	@Column(name = "ROUTE_NAME")
	private String routeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	public String getEndDestination() {
		return endDestination;
	}

	public void setEndDestination(String endDestination) {
		this.endDestination = endDestination;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	@Override
	public String toString() {
		return "RouteEntity [id=" + id + ", startCity=" + startCity + ", endDestination=" + endDestination
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", routeName=" + routeName + "]";
	}

}

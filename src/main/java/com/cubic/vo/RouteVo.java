package com.cubic.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RouteVo {
	private Long id;
	private String startCity;
	private String endDestination;
	private String startTime;
	private String endTime;
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
		return "RouteVo [id=" + id + ", startCity=" + startCity + ", endDestination=" + endDestination + ", startTime="
				+ startTime + ", endTime=" + endTime + ", routeName=" + routeName + "]";
	}

}

package com.cubic.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RouteVoList {
	private List<RouteVo> routeVos;

	public List<RouteVo> getRouteVos() {
		return routeVos;
	}

	public void setRouteVos(List<RouteVo> routeVos) {
		this.routeVos = routeVos;
	}

}

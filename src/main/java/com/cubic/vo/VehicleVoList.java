package com.cubic.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VehicleVoList {

	private List<VehicleVo> vehicleVo;

	public List<VehicleVo> getVehicleVo() {
		return vehicleVo;
	}

	public void setVehicleVo(List<VehicleVo> vehicleVo) {
		this.vehicleVo = vehicleVo;
	}

}

package com.cubic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.entity.VehicleEntity;
import com.cubic.vo.VehicleVo;

@Component
public class VehicleMapper {
	public VehicleVo mapToVo(final VehicleEntity entity) {
		VehicleVo vo = new VehicleVo();
		vo.setId(entity.getId());
		vo.setVehicle_make(entity.getVehicle_make());
		vo.setVehicle_model(entity.getVehicle_model());
		vo.setVehicle_vin(entity.getVehicle_vin());
		vo.setVehicle_year(entity.getVehicle_year());
		vo.setVehicle_color(entity.getVehicle_color());
		vo.setVehicle_status(entity.getVehicle_status());
		vo.setVehicle_type(entity.getVehicle_type());
		return vo;

	}

	public VehicleEntity mapToEntity(final VehicleVo vo, final VehicleEntity entity) {
		entity.setId(vo.getId());
		entity.setVehicle_color(vo.getVehicle_color());
		entity.setVehicle_make(vo.getVehicle_make());
		entity.setVehicle_model(vo.getVehicle_model());
		entity.setVehicle_status(vo.getVehicle_status());
		entity.setVehicle_vin(vo.getVehicle_vin());
		entity.setVehicle_year(vo.getVehicle_year());
		entity.setVehicle_type(vo.getVehicle_type());

		return entity;

	}

	public List<VehicleVo> mapToList(final List<VehicleEntity> entities) {
		List<VehicleVo> vehVo = new ArrayList<VehicleVo>();
		for (VehicleEntity entity : entities) {
			vehVo.add(mapToVo(entity));
		}

		return vehVo;
	}

}

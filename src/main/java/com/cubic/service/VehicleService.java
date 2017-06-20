package com.cubic.service;

import java.util.List;

import com.cubic.vo.VehicleVo;

public interface VehicleService {
	VehicleVo find(final Long id);

	VehicleVo delete(final Long id);

	VehicleVo insert(VehicleVo vo);

	VehicleVo update(VehicleVo vo);

	List<VehicleVo> getAll();

	List<VehicleVo> search(final String vehicle_make, final String vehicle_model);

	List<VehicleVo> searchByMake(final String vehicle_make);

}

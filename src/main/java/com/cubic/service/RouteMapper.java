package com.cubic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.entity.RouteEntity;
import com.cubic.vo.RouteVo;

@Component
public class RouteMapper {
	public RouteVo mapToVo(final RouteEntity entity) {

		RouteVo vo = new RouteVo();

		vo.setId(entity.getId());
		vo.setStartCity(entity.getStartCity());
		vo.setEndDestination(entity.getEndDestination());
		vo.setStartTime(entity.getStartTime());
		vo.setEndTime(entity.getEndTime());
		vo.setRouteName(entity.getStartCity() + "_" + entity.getEndDestination() + "_" + entity.getStartTime());
		return vo;

	}

	public RouteEntity mapToEntity(final RouteVo vo, final RouteEntity entity) {
		entity.setId(vo.getId());
		entity.setStartCity(vo.getStartCity());
		entity.setEndDestination(vo.getEndDestination());
		entity.setStartTime(vo.getStartTime());
		entity.setEndTime(vo.getEndTime());
		entity.setRouteName(vo.getStartCity() + "_" + vo.getEndDestination() + "_" + vo.getStartTime());
		return entity;

	}

	public List<RouteVo> mapToRouteList(final List<RouteEntity> entities) {
		List<RouteVo> rtVo = new ArrayList<RouteVo>();
		for (RouteEntity entity : entities) {
			rtVo.add(mapToVo(entity));
		}
		return rtVo;

	}
}

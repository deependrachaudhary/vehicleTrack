package com.cubic.service;

import java.util.List;

import com.cubic.vo.RouteVo;

public interface RouteService {

	RouteVo find(final Long id);

	RouteVo delete(final Long id);

	RouteVo insert(RouteVo vo);

	RouteVo update(RouteVo vo);

	List<RouteVo> getAll();

	List<RouteVo> search(final String city);

	List<RouteVo> searchByDes(final String destination);
}

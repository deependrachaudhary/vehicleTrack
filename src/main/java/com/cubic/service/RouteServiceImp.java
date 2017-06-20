package com.cubic.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.RouteEntity;
import com.cubic.validation.VoValidation;
import com.cubic.vo.RouteVo;

@Service
@Transactional
public class RouteServiceImp implements RouteService {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private RouteMapper mapper;
	@Autowired
	private VoValidation voValidation;

	public RouteVo find(Long id) {
		RouteEntity entity = em.find(RouteEntity.class, id);
		RouteVo rtVo = mapper.mapToVo(entity);
		return rtVo;
	}

	public RouteVo delete(Long id) {
		RouteEntity entity = em.find(RouteEntity.class, id);
		em.remove(entity);
		return null;
	}

	public RouteVo insert(RouteVo vo) {

		voValidation.validateRequiredFieldRoute(vo);
		voValidation.validateUniqueRoute(vo);

		RouteEntity entity = mapper.mapToEntity(vo, new RouteEntity());
		em.persist(entity);
		vo.setId(entity.getId());
		vo.setRouteName(entity.getRouteName());
		return vo;
	}

	public RouteVo update(RouteVo vo) {
		voValidation.validateRequiredFieldRoute(vo);
		RouteEntity entity = em.find(RouteEntity.class, vo.getId());
		RouteEntity entity2 = mapper.mapToEntity(vo, entity);
		em.persist(entity2);
		return vo;
	}

	public List<RouteVo> getAll() {
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.ROUTE_GETALL_ROUTE, RouteEntity.class);
		List<RouteEntity> result = query.getResultList();
		List<RouteVo> rtVo = mapper.mapToRouteList(result);
		return rtVo;
	}

	public List<RouteVo> search(String city) {
		String trimedCity = city.trim() + "%";
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.ROUTE_SEARCH_BY_CITY, RouteEntity.class);
		query.setParameter(1, trimedCity);
		List<RouteEntity> result = query.getResultList();
		List<RouteVo> rtVo = mapper.mapToRouteList(result);
		return rtVo;
	}

	public List<RouteVo> searchByDes(String destination) {
		String trimedCity = destination.trim() + "%";
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.ROUTE_SEARCH_BY_END_DEST, RouteEntity.class);
		query.setParameter(1, trimedCity);
		List<RouteEntity> result = query.getResultList();
		List<RouteVo> rtVo = mapper.mapToRouteList(result);
		return rtVo;
	}

}

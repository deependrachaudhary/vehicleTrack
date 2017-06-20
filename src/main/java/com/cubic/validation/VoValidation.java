package com.cubic.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.cubic.entity.RouteEntity;
import com.cubic.entity.VehicleEntity;
import com.cubic.exception.RequiredException;
import com.cubic.service.QueryConstant;
import com.cubic.vo.RouteVo;
import com.cubic.vo.VehicleVo;

@Component
public class VoValidation {

	@PersistenceContext
	private EntityManager em;

	public void validateRequiredFieldForVehicle(final VehicleVo vo) {
		if (vo.getVehicle_make() == null || vo.getVehicle_make().trim().length() == 0 || vo.getVehicle_model() == null
				|| vo.getVehicle_model().trim().length() == 0 || vo.getVehicle_color() == null
				|| vo.getVehicle_color().trim().length() == 0 || vo.getVehicle_type() == null
				|| vo.getVehicle_type().trim().length() == 0 || vo.getVehicle_vin() == null
				|| vo.getVehicle_vin().trim().length() == 0 || vo.getVehicle_year() == null
				|| vo.getVehicle_status() == null || vo.getVehicle_status().trim().length() == 0) {
			throw new RequiredException("All Fields Are Required");
		}
	}

	public void validateUniqeConstraintVehicle(final VehicleVo vo) {
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.QUERY_SEARCH_BY_VEHICLE_VIN,
				VehicleEntity.class);
		query.setParameter(1, vo.getVehicle_vin());
		List<VehicleEntity> result = query.getResultList();
		if (result.size() > 0) {
			throw new RequiredException("Vehicle with this VIN Alreday Exisit...");
		}
	}

	public void validateRequiredFieldRoute(final RouteVo vo) {
		if (vo.getEndDestination() == null || vo.getEndDestination().trim().length() == 0 || vo.getEndTime() == null
				|| vo.getEndTime().trim().length() == 0 || vo.getStartCity() == null
				|| vo.getStartCity().trim().length() == 0 || vo.getStartTime() == null
				|| vo.getStartTime().trim().length() == 0) {
			throw new RequiredException("All Fields Are Required");
		}
	}

	public void validateUniqueRoute(final RouteVo vo) {
		TypedQuery<RouteEntity> query = em.createNamedQuery(QueryConstant.ROUTE_SEARCH_BY_ROUTENAME, RouteEntity.class);
		query.setParameter(1, vo.getStartCity() + "_" + vo.getEndDestination() + "_" + vo.getStartTime());
		List<RouteEntity> result = query.getResultList();
		if (result.size() > 0) {
			throw new RequiredException("This route already exist ");
		}
	}

}

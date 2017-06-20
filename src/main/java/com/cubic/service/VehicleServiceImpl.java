package com.cubic.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.VehicleEntity;
import com.cubic.validation.VoValidation;
import com.cubic.vo.VehicleVo;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private VehicleMapper mapper;
	@Autowired
	private VoValidation voValidation;

	public VehicleVo find(final Long id) {
		VehicleEntity entity = em.find(VehicleEntity.class, id);
		VehicleVo vehVo = mapper.mapToVo(entity);
		return vehVo;
	}

	public VehicleVo delete(final Long id) {
		VehicleEntity entity = em.find(VehicleEntity.class, id);
		em.remove(entity);
		return null;
	}

	public VehicleVo insert(VehicleVo vo) {
		voValidation.validateRequiredFieldForVehicle(vo);
		voValidation.validateUniqeConstraintVehicle(vo);
		VehicleEntity entity = mapper.mapToEntity(vo, new VehicleEntity());
		em.persist(entity);
		vo.setId(entity.getId());
		return vo;
	}

	public VehicleVo update(VehicleVo vo) {
		voValidation.validateRequiredFieldForVehicle(vo);
		VehicleEntity entity = em.find(VehicleEntity.class, vo.getId());
		VehicleEntity vehentity = mapper.mapToEntity(vo, entity);
		em.persist(vehentity);
		return vo;
	}

	public List<VehicleVo> getAll() {
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.GET_ALL_VEHICLE, VehicleEntity.class);
		List<VehicleEntity> entities = query.getResultList();
		List<VehicleVo> vehVo = mapper.mapToList(entities);
		return vehVo;

	}

	public List<VehicleVo> search(String vehicle_make, String vehicle_model) {
		String trimedVehicle_make = vehicle_make.trim() + "%";
		String trimedvehicle_model = vehicle_model.trim() + "%";
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.SEARCH_BY_VEHICLE_NAME,
				VehicleEntity.class);
		query.setParameter(1, trimedVehicle_make);
		query.setParameter(1, trimedvehicle_model);
		List<VehicleEntity> entities = query.getResultList();
		List<VehicleVo> vehVo = mapper.mapToList(entities);
		return vehVo;
	}

	public List<VehicleVo> searchByMake(String vehicle_make) {
		String trimedVehicle_make = vehicle_make.trim() + "%";
		TypedQuery<VehicleEntity> query = em.createNamedQuery(QueryConstant.SEARCH_BY_VEHICLE_MAKE,
				VehicleEntity.class);
		query.setParameter(1, trimedVehicle_make);
		List<VehicleEntity> entities = query.getResultList();
		List<VehicleVo> vehVo = mapper.mapToList(entities);
		return vehVo;
	}

}

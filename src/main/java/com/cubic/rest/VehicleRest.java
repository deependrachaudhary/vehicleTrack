package com.cubic.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.service.VehicleService;
import com.cubic.vo.VehicleVo;
import com.cubic.vo.VehicleVoList;

@Service
@Path("/vehicle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehicleRest {
	@Autowired
	private VehicleService service;

	@GET
	@Path("/{id}")
	public Response find(@PathParam(value = "id") final Long id) {
		VehicleVo vo = service.find(id);
		List<VehicleVo> voList = new ArrayList<VehicleVo>();
		voList.add(vo);
		VehicleVoList listVo = new VehicleVoList();
		listVo.setVehicleVo(voList);
		return Response.ok().entity(listVo).build();

	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam(value = "id") final Long id) {
		service.delete(id);
		return Response.noContent().build();

	}

	@POST
	@Path("/insert")
	public Response insert(VehicleVo vo) {
		VehicleVo vehVo = service.insert(vo);
		return Response.ok().entity(vehVo).build();
	}

	@PUT
	@Path("/update")
	public Response update(VehicleVo vo) {
		VehicleVo vehVo = service.update(vo);
		return Response.ok().entity(vehVo).build();

	}

	@GET
	@Path("/getAll")
	public Response getAll() {
		List<VehicleVo> vehVo = service.getAll();
		VehicleVoList voList = new VehicleVoList();
		voList.setVehicleVo(vehVo);

		return Response.ok().entity(voList).build();
	}

	@GET
	@Path("/search")
	public Response searchByMakeAndModel(@QueryParam(value = "vehicle_Make") String vehicle_make,
			@QueryParam(value = "vehicle_model") String vehicle_model) {

		List<VehicleVo> vehVo = service.search(vehicle_make, vehicle_model);
		VehicleVoList vehVoList = new VehicleVoList();
		vehVoList.setVehicleVo(vehVo);
		return Response.ok().entity(vehVoList).build();

	}

	@GET
	@Path("/searchByMake")
	public Response searchByMake(@QueryParam(value = "vehicle_Make") String vehicle_make) {

		List<VehicleVo> vehVo = service.searchByMake(vehicle_make);
		VehicleVoList vehVoList = new VehicleVoList();
		vehVoList.setVehicleVo(vehVo);
		return Response.ok().entity(vehVoList).build();

	}
}

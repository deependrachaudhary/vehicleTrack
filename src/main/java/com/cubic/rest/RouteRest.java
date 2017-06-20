package com.cubic.rest;

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

import com.cubic.service.RouteService;
import com.cubic.vo.RouteVo;
import com.cubic.vo.RouteVoList;

@Service
@Path("/route")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RouteRest {
	@Autowired
	private RouteService service;

	@GET
	@Path("/{id}")
	public Response find(@PathParam(value = "id") final Long id) {
		RouteVo rtVo = service.find(id);
		return Response.ok().entity(rtVo).build();

	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam(value = "id") final Long id) {
		service.delete(id);
		return Response.noContent().build();

	}

	@POST
	@Path("/insert")
	public Response create(RouteVo vo) {
		RouteVo rtVo = service.insert(vo);
		return Response.ok().entity(rtVo).build();

	}

	@PUT
	@Path("/update")
	public Response update(RouteVo vo) {
		RouteVo rtVo = service.update(vo);
		return Response.ok().entity(rtVo).build();

	}

	@GET
	@Path("/getAll")
	public Response getAllList() {
		List<RouteVo> rtVo = service.getAll();
		RouteVoList voList = new RouteVoList();
		voList.setRouteVos(rtVo);
		return Response.ok().entity(voList).build();

	}

	@GET
	@Path("/search")
	public Response search(@QueryParam(value = "startCity") final String startCity) {
		List<RouteVo> rtVo = service.search(startCity);
		RouteVoList voList = new RouteVoList();
		voList.setRouteVos(rtVo);
		return Response.ok().entity(voList).build();

	}

	@GET
	@Path("/searchByEndDest")
	public Response searchByEndDestionation(@QueryParam(value = "destination") final String destination) {
		List<RouteVo> rtvo = service.searchByDes(destination);
		RouteVoList voList = new RouteVoList();
		voList.setRouteVos(rtvo);
		return Response.ok().entity(voList).build();

	}
}

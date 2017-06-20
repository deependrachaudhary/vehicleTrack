package com.cubic.exceptionhandler;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.cubic.exception.RequiredException;

@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class RequiredExceptionMapper implements ExceptionMapper<RequiredException> {

	public Response toResponse(RequiredException exception) {
		ErrorResponse er = new ErrorResponse();
		er.setErrorCode("ERR-420");
		er.setErrorDesc(exception.getMessage());
		return Response.status(420).entity(er).build();
	}

}

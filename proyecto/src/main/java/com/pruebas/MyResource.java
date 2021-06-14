package com.pruebas;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.Response;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/saludo")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Bienvenido";
    }
    
    @POST
    @Path("{nombre}")
    public Response leerParametro(@PathParam("nombre") String nombre) {
    	return Response.status(200).entity("El nombre recibido es " + nombre).build();    	
    }
    
    @PUT
    @Path("/query")
    public Response leerQueryString(@QueryParam("referencia") String referencia) {
    	return Response.status(200).entity("El valor de referencia es " + referencia).build();    	
    }
}


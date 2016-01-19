package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.FotografiaPublicacionFacade;
import model.FotografiaMascota;
import model.FotografiaPublicacion;

@Path("/fotografiasdepublicaciones")
public class FotografiaPublicacionService {
	
	@EJB 
	FotografiaPublicacionFacade FotografiaPublicacionFacadeEJB;
	
	Logger logger = Logger.getLogger(FotografiaPublicacionService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<FotografiaPublicacion> findAll(){
		return FotografiaPublicacionFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public FotografiaPublicacion find(@PathParam("id") Integer id) {
        return FotografiaPublicacionFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(FotografiaPublicacion entity) {
        FotografiaPublicacionFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, FotografiaPublicacion entity) {
    	entity.setIdFotografiaPublicacion(id.intValue());
        FotografiaPublicacionFacadeEJB.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
    	FotografiaPublicacion fotografiaPublicacionABorrar = FotografiaPublicacionFacadeEJB.find(id);
    	FotografiaPublicacionFacadeEJB.remove(fotografiaPublicacionABorrar);
    }
	

}

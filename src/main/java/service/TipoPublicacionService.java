package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.TipoPublicacionFacade;
import model.Publicacion;
import model.TipoPublicacion;

@Path("/tipopublicacions")
public class TipoPublicacionService {
	
	@EJB 
	TipoPublicacionFacade TipoPublicacionFacadeEJB;
	
	Logger logger = Logger.getLogger(TipoPublicacionService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<TipoPublicacion> findAll(){
		return TipoPublicacionFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TipoPublicacion find(@PathParam("id") Integer id) {
        return TipoPublicacionFacadeEJB.find(id);
    }
	
	@GET
    @Path("publicacionesseguntipo/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Publicacion> publicacionesSegunTipo(@PathParam("id") Integer id) {
        TipoPublicacion publicacionABuscarInfo = TipoPublicacionFacadeEJB.find(id);
        return publicacionABuscarInfo.getPublicacions();
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(TipoPublicacion entity) {
        TipoPublicacionFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, TipoPublicacion entity) {
    	entity.setIdTipoPublicacion(id.intValue());
        TipoPublicacionFacadeEJB.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void delete(@PathParam("id") Integer id, TipoPublicacion entity) {
    	entity.setIdTipoPublicacion(id.intValue());
        TipoPublicacionFacadeEJB.remove(entity);
    }
	
	

}

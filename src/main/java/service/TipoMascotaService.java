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

import facade.TipoMascotaFacade;
import model.TipoDeRecordatorio;
import model.TipoMascota;

@Path("/tipomascotas")
public class TipoMascotaService {
	
	@EJB 
	TipoMascotaFacade TipoMascotaFacadeEJB;
	
	Logger logger = Logger.getLogger(TipoMascotaService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<TipoMascota> findAll(){
		return TipoMascotaFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TipoMascota find(@PathParam("id") Integer id) {
        return TipoMascotaFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(TipoMascota entity) {
        TipoMascotaFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, TipoMascota entity) {
    	entity.setIdTipoMascota(id.intValue());
        TipoMascotaFacadeEJB.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
    	TipoMascota tipoDeMascotaABorrar = TipoMascotaFacadeEJB.find(id);
		TipoMascotaFacadeEJB.remove(tipoDeMascotaABorrar);
    }
	

}

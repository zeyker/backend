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

import facade.FotografiaMascotaFacade;
import model.FotografiaMascota;
import model.FotografiaPerfil;

@Path("/fotografiasdemascotas")
public class FotografiaMascotaService {
	
	@EJB 
	FotografiaMascotaFacade FotografiaMascotaFacadeEJB;
	
	Logger logger = Logger.getLogger(FotografiaMascotaService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<FotografiaMascota> findAll(){
		return FotografiaMascotaFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public FotografiaMascota find(@PathParam("id") Integer id) {
        return FotografiaMascotaFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(FotografiaMascota entity) {
        FotografiaMascotaFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, FotografiaMascota entity) {
    	entity.setIdFotografiaMascota(id.intValue());
        FotografiaMascotaFacadeEJB.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
    	FotografiaMascota fotografiaMascotaABorrar = FotografiaMascotaFacadeEJB.find(id);
    	FotografiaMascotaFacadeEJB.remove(fotografiaMascotaABorrar);
    }
	

}

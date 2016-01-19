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

import facade.MascotaFacade;
import model.FotografiaMascota;
import model.FotografiaPublicacion;
import model.Mascota;

@Path("/mascotas")
public class MascotaService {
	
	@EJB 
	MascotaFacade MascotaFacadeEJB;
	
	Logger logger = Logger.getLogger(MascotaService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Mascota> findAll(){
		return MascotaFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Mascota find(@PathParam("id") Integer id) {
        return MascotaFacadeEJB.find(id);
    }
	
	@GET
    @Path("fotografiasmascota/{id}")
    @Produces({"application/xml", "application/json"})
    public List<FotografiaMascota> fotografiasMascota(@PathParam("id") Integer id) {
        Mascota mascotaABuscarInfo = MascotaFacadeEJB.find(id);
        return mascotaABuscarInfo.getFotografiaMascotas();
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Mascota entity) {
        MascotaFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Mascota entity) {
    	entity.setIdMascota(id.intValue());
        MascotaFacadeEJB.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
    	Mascota mascotaABorrar = MascotaFacadeEJB.find(id);
    	MascotaFacadeEJB.remove(mascotaABorrar);
    }
	

}

package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.ComunaFacade;
import model.Comuna;
import model.Mascota;
import model.Publicacion;
import model.Usuario;

@Path("/comunas")
public class ComunaService {
	
	@EJB 
	ComunaFacade ComunaFacadeEJB;
	
	Logger logger = Logger.getLogger(ComunaService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Comuna> findAll(){
		return ComunaFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Comuna find(@PathParam("id") Integer id) {
        return ComunaFacadeEJB.find(id);
    }
	
	@GET
    @Path("publicacionesdelacomuna/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Publicacion> publicacionesDeLaComuna(@PathParam("id") Integer id) {
        Comuna comunaABuscarInfo = ComunaFacadeEJB.find(id);
        return comunaABuscarInfo.getPublicacions();
    }
	
	@GET
    @Path("usuariosdelacomuna/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Usuario> usuariosDeLaComuna(@PathParam("id") Integer id) {
        Comuna comunaABuscarInfo = ComunaFacadeEJB.find(id);
        return comunaABuscarInfo.getUsuarios();
    }
	
	@GET
    @Path("mascotasdelacomuna/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Mascota> devolverMascotasDeLaComuna(@PathParam("id") Integer id) {
        Comuna comunaABuscarInfo = ComunaFacadeEJB.find(id);
        return ComunaFacadeEJB.mascotasDeLaComuna(comunaABuscarInfo);
        	
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Comuna entity) {
        ComunaFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Comuna entity) {
    	entity.setIdComuna(id.intValue());
        ComunaFacadeEJB.edit(entity);
    }
	

}

package service;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.PublicacionFacade;
import model.FotografiaPublicacion;
import model.Publicacion;
import model.Usuario;

@Path("/publicaciones")
public class PublicacionService {
	
	@EJB 
	PublicacionFacade PublicacionFacadeEJB;
	
	Logger logger = Logger.getLogger(PublicacionService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Publicacion> findAll(){
		return PublicacionFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Publicacion find(@PathParam("id") Integer id) {
        return PublicacionFacadeEJB.find(id);
    }
	
	@GET
    @Path("fotografiasdelapublicacion/{id}")
    @Produces({"application/xml", "application/json"})
    public List<FotografiaPublicacion> fotografiasDeLaPublicacion(@PathParam("id") Integer id) {
        Publicacion publicacionABuscarInfo = PublicacionFacadeEJB.find(id);
        return publicacionABuscarInfo.getFotografiaPublicacions();
    }
	
	@GET
    @Path("comprobarusuariodelapublicacion/{idUsuario}/{idPublicacion}")
	@Produces("text/plain")
    public String buscarUsuarioDeLaPublicacion(@PathParam("idUsuario") Integer idUsuario, @PathParam("idPublicacion") Integer idPublicacion) {
        Publicacion publicacionSolicitada = PublicacionFacadeEJB.find(idPublicacion);
        Usuario usuarioDueno = publicacionSolicitada.getUsuario();
        if (usuarioDueno.getIdUsuario() == idUsuario)
        {
        	return "esDueno";
        }
        return "noEsDueno";
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Publicacion entity) {
        PublicacionFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Publicacion entity) {
    	entity.setIdPublicacion(id.intValue());
        PublicacionFacadeEJB.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
    	Publicacion publicacionABorrar = PublicacionFacadeEJB.find(id);
        PublicacionFacadeEJB.remove(publicacionABorrar);
    }
	

}

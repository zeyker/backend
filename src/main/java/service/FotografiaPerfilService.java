package service;

import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.cloudinary.*;
import com.cloudinary.utils.*;
import facade.FotografiaPerfilFacade;
import model.FotografiaPerfil;
import model.Publicacion;
import java.util.Map;

@Path("/fotografiasdeperfil")
public class FotografiaPerfilService {
	
	@EJB 
	FotografiaPerfilFacade FotografiaPerfilFacadeEJB;
	
	Logger logger = Logger.getLogger(FotografiaPerfilService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<FotografiaPerfil> findAll(){
		return FotografiaPerfilFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public FotografiaPerfil find(@PathParam("id") Integer id) {
        return FotografiaPerfilFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(FotografiaPerfil entity) {
        FotografiaPerfilFacadeEJB.create(entity);
    }

	@POST
	@Path("subirimagen")
	@Consumes({"application/x-www-form-urlencoded"})
    public void subirImagen(File file) {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "dbdn1fern",
				  "api_key", "371799448131225",
				  "api_secret", "Qs1SsiR1MQGplcHvTCdudcki-yE"));
		try {
			cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, FotografiaPerfil entity) {
    	entity.setIdFotografiaPerfil(id.intValue());
        FotografiaPerfilFacadeEJB.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
    	FotografiaPerfil fotografiaPerfilABorrar = FotografiaPerfilFacadeEJB.find(id);
    	FotografiaPerfilFacadeEJB.remove(fotografiaPerfilABorrar);
    }
	

}

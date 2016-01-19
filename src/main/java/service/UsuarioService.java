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

import facade.UsuarioFacade;
import model.FotografiaPerfil;
import model.Mascota;
import model.Publicacion;
import model.Recordatorio;
import model.Usuario;

@Path("/usuarios")
public class UsuarioService {
	
	@EJB 
	UsuarioFacade UsuarioFacadeEJB;
	
	Logger logger = Logger.getLogger(UsuarioService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Usuario> findAll(){
		return UsuarioFacadeEJB.findAll();
	}
	
	@GET
    @Path("buscarusuario/{id}")
    @Produces({"application/xml", "application/json"})
    public Usuario find(@PathParam("id") Integer id) {
        return UsuarioFacadeEJB.find(id);
    }
	
	@GET
    @Path("buscarusuariopornombre/{nombreUsuario}")
    @Produces({"application/xml", "application/json"})
    public Integer buscarUsuarioPorNombre(@PathParam("nombreUsuario") String nombreUsuario) 
	{
        List<Usuario> todosLosUsuarios = UsuarioFacadeEJB.findAll();
        for (Usuario usuario : todosLosUsuarios)
        {
        	if (usuario.getNombreUsuario().equals(nombreUsuario))
        	{
        		return usuario.getIdUsuario();
        	}
        }
        return -1;
       
    }
	
	@GET
    @Path("publicacionesdeusuario/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Publicacion> publicacionesdeusuario(@PathParam("id") Integer id) {
        Usuario usuarioABuscarPublicaciones = UsuarioFacadeEJB.find(id);
        return usuarioABuscarPublicaciones.getPublicacions();
    }
	
	@GET
    @Path("mascotasdeusuario/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Mascota> mascotasDeUsuario(@PathParam("id") Integer id) {
        Usuario usuarioABuscarMascotas = UsuarioFacadeEJB.find(id);
        return usuarioABuscarMascotas.getMascotas();
    }
	
	@GET
    @Path("recordatoriosdeusuario/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Recordatorio> recordatoriosDeUsuario(@PathParam("id") Integer id) {
        Usuario usuarioABuscarRecordatorios = UsuarioFacadeEJB.find(id);
        return usuarioABuscarRecordatorios.getRecordatorios();
    }
	
	@GET
    @Path("fotografiasperfildeusuario/{id}")
    @Produces({"application/xml", "application/json"})
    public List<FotografiaPerfil> fotografiasPerfilDeUsuario(@PathParam("id") Integer id) {
        Usuario usuarioABuscarFotografiaPerfil= UsuarioFacadeEJB.find(id);
        return usuarioABuscarFotografiaPerfil.getFotografiaPerfils();
    }
	
	@POST
	@Path("crearusuario")
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity) {
        UsuarioFacadeEJB.create(entity);
    }
	
	@POST
	@Path("crearusuarioandroid")
    @Consumes({"application/xml", "application/json"})
    public Integer crearUsuarioAndroid(Usuario entity) {
		List<Usuario> todosLosUsuarios = UsuarioFacadeEJB.findAll();
        for (Usuario usuario : todosLosUsuarios)
        {
        	if (usuario.getNombreUsuario().equals(entity.getNombreUsuario()))
        	{
        		return -1;
        	}
        }
        UsuarioFacadeEJB.create(entity);
        for (Usuario usuario : todosLosUsuarios)
        {
        	if (usuario.getNombreUsuario().equals(entity.getNombreUsuario()))
        	{
        		return usuario.getIdUsuario();
        	}
        }
        return -1;
    }

    @PUT
    @Path("editarusuario/{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
    	entity.setIdUsuario(id.intValue());
        UsuarioFacadeEJB.edit(entity);
    }
    
    @POST
    @Path("logearusuario")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Usuario login(Usuario entity) {
        List<Usuario> listasDeUsuarios = UsuarioFacadeEJB.findAll();
        int largo = listasDeUsuarios.size();
        int contador = 0;
        while(contador != largo - 1)
        	{
        	if(listasDeUsuarios.get(contador).getNombreUsuario().equals(entity.getNombreUsuario()) && listasDeUsuarios.get(contador).getContrasena().equals(entity.getContrasena()))
        		{
        			return listasDeUsuarios.get(contador);
        		}
        	contador++;
            }
        	Usuario nuevoUsuario = new Usuario();
        	nuevoUsuario.setNombreUsuario("");
        	nuevoUsuario.setContrasena("");
        	return nuevoUsuario;
    }
	

}

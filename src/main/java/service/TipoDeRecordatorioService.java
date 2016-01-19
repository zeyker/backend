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

import facade.TipoDeRecordatorioFacade;
import model.Recordatorio;
import model.TipoDeRecordatorio;

@Path("/tipoderecordatorios")
public class TipoDeRecordatorioService {
	
	@EJB 
	TipoDeRecordatorioFacade TipoDeRecordatorioFacadeEJB;
	
	Logger logger = Logger.getLogger(TipoDeRecordatorioService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<TipoDeRecordatorio> findAll(){
		return TipoDeRecordatorioFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TipoDeRecordatorio find(@PathParam("id") Integer id) {
        return TipoDeRecordatorioFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(TipoDeRecordatorio entity) {
        TipoDeRecordatorioFacadeEJB.create(entity);
    }
	
	@DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
		TipoDeRecordatorio tipoDeRecordatorioABorrar = TipoDeRecordatorioFacadeEJB.find(id);
    	TipoDeRecordatorioFacadeEJB.remove(tipoDeRecordatorioABorrar);
    }

	

}

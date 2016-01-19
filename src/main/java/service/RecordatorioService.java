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

import facade.RecordatorioFacade;
import model.Mascota;
import model.Recordatorio;

@Path("/recordatorios")
public class RecordatorioService {
	
	@EJB 
	RecordatorioFacade RecordatorioFacadeEJB;
	
	Logger logger = Logger.getLogger(RecordatorioService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Recordatorio> findAll(){
		return RecordatorioFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Recordatorio find(@PathParam("id") Integer id) {
        return RecordatorioFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Recordatorio entity) {
        RecordatorioFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Recordatorio entity) {
    	entity.setIdRecordatorio(id.intValue());
        RecordatorioFacadeEJB.edit(entity);
    }
	
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
    	Recordatorio recordatorioABorrar = RecordatorioFacadeEJB.find(id);
    	RecordatorioFacadeEJB.remove(recordatorioABorrar);
    }

}

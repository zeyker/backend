package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.PublicacionFacade;
import model.Publicacion;

@Stateless
public class PublicacionFacadeEJB extends AbstractFacade<Publicacion> implements PublicacionFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public PublicacionFacadeEJB() {
		super(Publicacion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}

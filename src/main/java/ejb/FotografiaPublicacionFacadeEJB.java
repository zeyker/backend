package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.FotografiaPublicacionFacade;
import model.FotografiaPublicacion;

@Stateless
public class FotografiaPublicacionFacadeEJB extends AbstractFacade<FotografiaPublicacion> implements FotografiaPublicacionFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public FotografiaPublicacionFacadeEJB() {
		super(FotografiaPublicacion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}

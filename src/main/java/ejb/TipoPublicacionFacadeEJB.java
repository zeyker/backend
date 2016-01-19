package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.TipoPublicacionFacade;
import model.TipoPublicacion;

@Stateless
public class TipoPublicacionFacadeEJB extends AbstractFacade<TipoPublicacion> implements TipoPublicacionFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public TipoPublicacionFacadeEJB() {
		super(TipoPublicacion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}

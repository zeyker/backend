package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.TipoMascotaFacade;
import model.TipoMascota;

@Stateless
public class TipoMascotaFacadeEJB extends AbstractFacade<TipoMascota> implements TipoMascotaFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public TipoMascotaFacadeEJB() {
		super(TipoMascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}

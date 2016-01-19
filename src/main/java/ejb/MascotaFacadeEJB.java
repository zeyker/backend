package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.MascotaFacade;
import model.Mascota;

@Stateless
public class MascotaFacadeEJB extends AbstractFacade<Mascota> implements MascotaFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public MascotaFacadeEJB() {
		super(Mascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}

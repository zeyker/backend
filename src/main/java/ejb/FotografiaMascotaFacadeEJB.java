package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.FotografiaMascotaFacade;
import model.FotografiaMascota;

@Stateless
public class FotografiaMascotaFacadeEJB extends AbstractFacade<FotografiaMascota> implements FotografiaMascotaFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public FotografiaMascotaFacadeEJB() {
		super(FotografiaMascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}

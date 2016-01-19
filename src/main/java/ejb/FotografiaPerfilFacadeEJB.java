package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.FotografiaPerfilFacade;
import model.FotografiaPerfil;

@Stateless
public class FotografiaPerfilFacadeEJB extends AbstractFacade<FotografiaPerfil> implements FotografiaPerfilFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public FotografiaPerfilFacadeEJB() {
		super(FotografiaPerfil.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}

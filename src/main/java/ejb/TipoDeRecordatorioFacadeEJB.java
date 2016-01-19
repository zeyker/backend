package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.TipoDeRecordatorioFacade;
import model.TipoDeRecordatorio;

@Stateless
public class TipoDeRecordatorioFacadeEJB extends AbstractFacade<TipoDeRecordatorio> implements TipoDeRecordatorioFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public TipoDeRecordatorioFacadeEJB() {
		super(TipoDeRecordatorio.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}

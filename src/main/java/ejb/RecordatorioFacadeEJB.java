package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.RecordatorioFacade;
import model.Recordatorio;

@Stateless
public class RecordatorioFacadeEJB extends AbstractFacade<Recordatorio> implements RecordatorioFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public RecordatorioFacadeEJB() {
		super(Recordatorio.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}

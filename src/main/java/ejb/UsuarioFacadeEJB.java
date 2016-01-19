package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;

import facade.AbstractFacade;
import facade.UsuarioFacade;
import model.Usuario;

@Stateless
public class UsuarioFacadeEJB extends AbstractFacade<Usuario> implements UsuarioFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public UsuarioFacadeEJB() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	

}

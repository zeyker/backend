package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.ComunaFacade;
import model.Comuna;
import model.Mascota;
import model.Publicacion;
import model.Usuario;

@Stateless
public class ComunaFacadeEJB extends AbstractFacade<Comuna> implements ComunaFacade {
	
	
	@PersistenceContext(unitName = "basededatos")
	private EntityManager em;
	
	public ComunaFacadeEJB() {
		super(Comuna.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	public List<Mascota> mascotasDeLaComuna(Comuna comunaABuscarInfo)
	{
		List<Usuario> usuariosDeLaComuna = comunaABuscarInfo.getUsuarios();
        List<Mascota> listaDeMascotas = new ArrayList<Mascota>();
        for (Usuario usuario : usuariosDeLaComuna)
        {
        	for (Mascota mascotaDelUsuario : usuario.getMascotas())
        	{
        		listaDeMascotas.add(mascotaDelUsuario);
        	}
        }
        return listaDeMascotas;
	}

}

package facade;

import java.util.List;

import javax.ejb.Local;

import model.Comuna;
import model.Mascota;
import model.Publicacion;

@Local
public interface ComunaFacade {

	public void create(Comuna entity);

	public void edit(Comuna entity);

	public void remove(Comuna entity);

	public Comuna find(Object id);

	public List<Comuna> findAll();

	public List<Comuna> findRange(int[] range);

	public int count();
	
	public List<Mascota> mascotasDeLaComuna(Comuna comunaABuscarInfo);

}

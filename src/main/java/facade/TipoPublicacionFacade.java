package facade;

import java.util.List;

import javax.ejb.Local;

import model.TipoPublicacion;

@Local
public interface TipoPublicacionFacade {

	public void create(TipoPublicacion entity);

	public void edit(TipoPublicacion entity);

	public void remove(TipoPublicacion entity);

	public TipoPublicacion find(Object id);

	public List<TipoPublicacion> findAll();

	public List<TipoPublicacion> findRange(int[] range);

	public int count();

}

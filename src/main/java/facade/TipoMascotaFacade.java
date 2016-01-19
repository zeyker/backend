package facade;

import java.util.List;

import javax.ejb.Local;

import model.TipoMascota;

@Local
public interface TipoMascotaFacade {

	public void create(TipoMascota entity);

	public void edit(TipoMascota entity);

	public void remove(TipoMascota entity);

	public TipoMascota find(Object id);

	public List<TipoMascota> findAll();

	public List<TipoMascota> findRange(int[] range);

	public int count();

}

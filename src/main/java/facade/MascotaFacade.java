package facade;

import java.util.List;

import javax.ejb.Local;

import model.Mascota;

@Local
public interface MascotaFacade {

	public void create(Mascota entity);

	public void edit(Mascota entity);

	public void remove(Mascota entity);

	public Mascota find(Object id);

	public List<Mascota> findAll();

	public List<Mascota> findRange(int[] range);

	public int count();

}

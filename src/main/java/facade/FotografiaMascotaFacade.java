package facade;

import java.util.List;

import javax.ejb.Local;

import model.FotografiaMascota;

@Local
public interface FotografiaMascotaFacade {

	public void create(FotografiaMascota entity);

	public void edit(FotografiaMascota entity);

	public void remove(FotografiaMascota entity);

	public FotografiaMascota find(Object id);

	public List<FotografiaMascota> findAll();

	public List<FotografiaMascota> findRange(int[] range);

	public int count();

}

package facade;

import java.util.List;

import javax.ejb.Local;

import model.FotografiaPublicacion;

@Local
public interface FotografiaPublicacionFacade {

	public void create(FotografiaPublicacion entity);

	public void edit(FotografiaPublicacion entity);

	public void remove(FotografiaPublicacion entity);

	public FotografiaPublicacion find(Object id);

	public List<FotografiaPublicacion> findAll();

	public List<FotografiaPublicacion> findRange(int[] range);

	public int count();

}

package facade;

import java.util.List;

import javax.ejb.Local;

import model.Publicacion;

@Local
public interface PublicacionFacade {

	public void create(Publicacion entity);

	public void edit(Publicacion entity);

	public void remove(Publicacion entity);

	public Publicacion find(Object id);

	public List<Publicacion> findAll();

	public List<Publicacion> findRange(int[] range);

	public int count();

}

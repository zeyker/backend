package facade;

import java.util.List;

import javax.ejb.Local;

import model.Recordatorio;

@Local
public interface RecordatorioFacade {

	public void create(Recordatorio entity);

	public void edit(Recordatorio entity);

	public void remove(Recordatorio entity);

	public Recordatorio find(Object id);

	public List<Recordatorio> findAll();

	public List<Recordatorio> findRange(int[] range);

	public int count();

}

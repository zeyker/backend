package facade;

import java.util.List;

import javax.ejb.Local;

import model.TipoDeRecordatorio;

@Local
public interface TipoDeRecordatorioFacade {

	public void create(TipoDeRecordatorio entity);

	public void edit(TipoDeRecordatorio entity);

	public void remove(TipoDeRecordatorio entity);

	public TipoDeRecordatorio find(Object id);

	public List<TipoDeRecordatorio> findAll();

	public List<TipoDeRecordatorio> findRange(int[] range);

	public int count();

}

package facade;

import java.util.List;

import javax.ejb.Local;

import model.FotografiaPerfil;

@Local
public interface FotografiaPerfilFacade {

	public void create(FotografiaPerfil entity);

	public void edit(FotografiaPerfil entity);

	public void remove(FotografiaPerfil entity);

	public FotografiaPerfil find(Object id);

	public List<FotografiaPerfil> findAll();

	public List<FotografiaPerfil> findRange(int[] range);

	public int count();

}

package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fotografia_perfil database table.
 * 
 */
@Entity
@Table(name="fotografia_perfil")
@NamedQuery(name="FotografiaPerfil.findAll", query="SELECT f FROM FotografiaPerfil f")
public class FotografiaPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FOTOGRAFIA_PERFIL")
	private int idFotografiaPerfil;

	@Column(name="ACTIVO_FOTOGRAFIA")
	private byte activoFotografia;

	@Column(name="URL_IMAGEN")
	private String urlImagen;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public FotografiaPerfil() {
	}

	public int getIdFotografiaPerfil() {
		return this.idFotografiaPerfil;
	}

	public void setIdFotografiaPerfil(int idFotografiaPerfil) {
		this.idFotografiaPerfil = idFotografiaPerfil;
	}

	public byte getActivoFotografia() {
		return this.activoFotografia;
	}

	public void setActivoFotografia(byte activoFotografia) {
		this.activoFotografia = activoFotografia;
	}

	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
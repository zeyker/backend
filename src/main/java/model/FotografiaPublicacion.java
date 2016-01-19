package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fotografia_publicacion database table.
 * 
 */
@Entity
@Table(name="fotografia_publicacion")
@NamedQuery(name="FotografiaPublicacion.findAll", query="SELECT f FROM FotografiaPublicacion f")
public class FotografiaPublicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FOTOGRAFIA_PUBLICACION")
	private int idFotografiaPublicacion;

	@Column(name="URL_IMAGEN")
	private String urlImagen;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="ID_PUBLICACION")
	private Publicacion publicacion;

	public FotografiaPublicacion() {
	}

	public int getIdFotografiaPublicacion() {
		return this.idFotografiaPublicacion;
	}

	public void setIdFotografiaPublicacion(int idFotografiaPublicacion) {
		this.idFotografiaPublicacion = idFotografiaPublicacion;
	}

	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

}
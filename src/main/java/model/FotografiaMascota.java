package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fotografia_mascota database table.
 * 
 */
@Entity
@Table(name="fotografia_mascota")
@NamedQuery(name="FotografiaMascota.findAll", query="SELECT f FROM FotografiaMascota f")
public class FotografiaMascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FOTOGRAFIA_MASCOTA")
	private int idFotografiaMascota;

	@Column(name="URL_IMAGEN")
	private String urlImagen;

	//bi-directional many-to-one association to Mascota
	@ManyToOne
	@JoinColumn(name="ID_MASCOTA")
	private Mascota mascota;

	public FotografiaMascota() {
	}

	public int getIdFotografiaMascota() {
		return this.idFotografiaMascota;
	}

	public void setIdFotografiaMascota(int idFotografiaMascota) {
		this.idFotografiaMascota = idFotografiaMascota;
	}

	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Mascota getMascota() {
		return this.mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_mascota database table.
 * 
 */
@Entity
@Table(name="tipo_mascota")
@NamedQuery(name="TipoMascota.findAll", query="SELECT t FROM TipoMascota t")
public class TipoMascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO_MASCOTA")
	private int idTipoMascota;

	@Column(name="PERRO_GATO")
	private byte perroGato;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="tipoMascota")
	private List<Mascota> mascotas;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="tipoMascota")
	private List<Publicacion> publicacions;

	public TipoMascota() {
	}

	public int getIdTipoMascota() {
		return this.idTipoMascota;
	}

	public void setIdTipoMascota(int idTipoMascota) {
		this.idTipoMascota = idTipoMascota;
	}

	public byte getPerroGato() {
		return this.perroGato;
	}

	public void setPerroGato(byte perroGato) {
		this.perroGato = perroGato;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setTipoMascota(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setTipoMascota(null);

		return mascota;
	}

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	public Publicacion addPublicacion(Publicacion publicacion) {
		getPublicacions().add(publicacion);
		publicacion.setTipoMascota(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setTipoMascota(null);

		return publicacion;
	}

}
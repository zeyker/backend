package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_publicacion database table.
 * 
 */
@Entity
@Table(name="tipo_publicacion")
@NamedQuery(name="TipoPublicacion.findAll", query="SELECT t FROM TipoPublicacion t")
public class TipoPublicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO_PUBLICACION")
	private int idTipoPublicacion;

	@Column(name="ADOPCION_PERDIDO_ENCONTRADO")
	private byte adopcionPerdidoEncontrado;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="tipoPublicacion")
	private List<Publicacion> publicacions;

	public TipoPublicacion() {
	}

	public int getIdTipoPublicacion() {
		return this.idTipoPublicacion;
	}

	public void setIdTipoPublicacion(int idTipoPublicacion) {
		this.idTipoPublicacion = idTipoPublicacion;
	}

	public byte getAdopcionPerdidoEncontrado() {
		return this.adopcionPerdidoEncontrado;
	}

	public void setAdopcionPerdidoEncontrado(byte adopcionPerdidoEncontrado) {
		this.adopcionPerdidoEncontrado = adopcionPerdidoEncontrado;
	}

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	public Publicacion addPublicacion(Publicacion publicacion) {
		getPublicacions().add(publicacion);
		publicacion.setTipoPublicacion(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setTipoPublicacion(null);

		return publicacion;
	}

}
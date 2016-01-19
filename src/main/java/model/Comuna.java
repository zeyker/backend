package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comuna database table.
 * 
 */
@Entity
@NamedQuery(name="Comuna.findAll", query="SELECT c FROM Comuna c")
public class Comuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMUNA")
	private int idComuna;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="NOMBRE_COMUNA")
	private String nombreComuna;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="comuna")
	private List<Publicacion> publicacions;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="comuna")
	private List<Usuario> usuarios;

	public Comuna() {
	}

	public int getIdComuna() {
		return this.idComuna;
	}

	public void setIdComuna(int idComuna) {
		this.idComuna = idComuna;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreComuna() {
		return this.nombreComuna;
	}

	public void setNombreComuna(String nombreComuna) {
		this.nombreComuna = nombreComuna;
	}

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	public Publicacion addPublicacion(Publicacion publicacion) {
		getPublicacions().add(publicacion);
		publicacion.setComuna(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setComuna(null);

		return publicacion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setComuna(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setComuna(null);

		return usuario;
	}

}
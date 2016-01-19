package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the publicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Publicacion.findAll", query="SELECT p FROM Publicacion p")
public class Publicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PUBLICACION")
	private int idPublicacion;

	@Column(name="ACTIVO_PUBLICACION")
	private byte activoPublicacion;

	@Lob
	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="EMAIL")
	private String email;

	@Column(name="ESTADO_PUBLICACION")
	private byte estadoPublicacion;

	@Column(name="FECHA_PUBLICACION")
	private Timestamp fechaPublicacion;

	@Column(name="FONO_CONTACTO")
	private String fonoContacto;

	@Column(name="LATITUD")
	private String latitud;

	@Column(name="LONGITUD")
	private String longitud;

	@Column(name="TITULO")
	private String titulo;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="publicacion")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to FotografiaPublicacion
	@OneToMany(mappedBy="publicacion")
	private List<FotografiaPublicacion> fotografiaPublicacions;

	//bi-directional many-to-one association to Comuna
	@ManyToOne
	@JoinColumn(name="ID_COMUNA")
	private Comuna comuna;

	//bi-directional many-to-one association to Mascota
	@ManyToOne
	@JoinColumn(name="ID_MASCOTA")
	private Mascota mascota;

	//bi-directional many-to-one association to TipoPublicacion
	@ManyToOne
	@JoinColumn(name="ID_TIPO_PUBLICACION")
	private TipoPublicacion tipoPublicacion;

	//bi-directional many-to-one association to TipoMascota
	@ManyToOne
	@JoinColumn(name="ID_TIPO_MASCOTA")
	private TipoMascota tipoMascota;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Publicacion() {
	}

	public int getIdPublicacion() {
		return this.idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public byte getActivoPublicacion() {
		return this.activoPublicacion;
	}

	public void setActivoPublicacion(byte activoPublicacion) {
		this.activoPublicacion = activoPublicacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getEstadoPublicacion() {
		return this.estadoPublicacion;
	}

	public void setEstadoPublicacion(byte estadoPublicacion) {
		this.estadoPublicacion = estadoPublicacion;
	}

	public Timestamp getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Timestamp fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getFonoContacto() {
		return this.fonoContacto;
	}

	public void setFonoContacto(String fonoContacto) {
		this.fonoContacto = fonoContacto;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setPublicacion(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setPublicacion(null);

		return comentario;
	}

	public List<FotografiaPublicacion> getFotografiaPublicacions() {
		return this.fotografiaPublicacions;
	}

	public void setFotografiaPublicacions(List<FotografiaPublicacion> fotografiaPublicacions) {
		this.fotografiaPublicacions = fotografiaPublicacions;
	}

	public FotografiaPublicacion addFotografiaPublicacion(FotografiaPublicacion fotografiaPublicacion) {
		getFotografiaPublicacions().add(fotografiaPublicacion);
		fotografiaPublicacion.setPublicacion(this);

		return fotografiaPublicacion;
	}

	public FotografiaPublicacion removeFotografiaPublicacion(FotografiaPublicacion fotografiaPublicacion) {
		getFotografiaPublicacions().remove(fotografiaPublicacion);
		fotografiaPublicacion.setPublicacion(null);

		return fotografiaPublicacion;
	}

	public Comuna getComuna() {
		return this.comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public Mascota getMascota() {
		return this.mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public TipoPublicacion getTipoPublicacion() {
		return this.tipoPublicacion;
	}

	public void setTipoPublicacion(TipoPublicacion tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}

	public TipoMascota getTipoMascota() {
		return this.tipoMascota;
	}

	public void setTipoMascota(TipoMascota tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private int idUsuario;

	@Column(name="ACTIVO_USUARIO")
	private byte activoUsuario;

	@Column(name="CONTRASENA")
	private String contrasena;

	@Column(name="CORREO")
	private String correo;

	@Column(name="IP_ULTIMO_LOGEO")
	private int ipUltimoLogeo;

	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;

	@Column(name="TIMESTAMP_ULTIMO_LOGEO")
	private Timestamp timestampUltimoLogeo;

	@Column(name="TIPO_USUARIO")
	private byte tipoUsuario;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="usuario")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to FotografiaPerfil
	@OneToMany(mappedBy="usuario")
	private List<FotografiaPerfil> fotografiaPerfils;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="usuario")
	private List<Mascota> mascotas;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="usuario")
	private List<Publicacion> publicacions;

	//bi-directional many-to-one association to Recordatorio
	@OneToMany(mappedBy="usuario")
	private List<Recordatorio> recordatorios;

	//bi-directional many-to-one association to Comuna
	@ManyToOne
	@JoinColumn(name="ID_COMUNA")
	private Comuna comuna;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public byte getActivoUsuario() {
		return this.activoUsuario;
	}

	public void setActivoUsuario(byte activoUsuario) {
		this.activoUsuario = activoUsuario;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getIpUltimoLogeo() {
		return this.ipUltimoLogeo;
	}

	public void setIpUltimoLogeo(int ipUltimoLogeo) {
		this.ipUltimoLogeo = ipUltimoLogeo;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Timestamp getTimestampUltimoLogeo() {
		return this.timestampUltimoLogeo;
	}

	public void setTimestampUltimoLogeo(Timestamp timestampUltimoLogeo) {
		this.timestampUltimoLogeo = timestampUltimoLogeo;
	}

	public byte getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(byte tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setUsuario(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setUsuario(null);

		return comentario;
	}

	public List<FotografiaPerfil> getFotografiaPerfils() {
		return this.fotografiaPerfils;
	}

	public void setFotografiaPerfils(List<FotografiaPerfil> fotografiaPerfils) {
		this.fotografiaPerfils = fotografiaPerfils;
	}

	public FotografiaPerfil addFotografiaPerfil(FotografiaPerfil fotografiaPerfil) {
		getFotografiaPerfils().add(fotografiaPerfil);
		fotografiaPerfil.setUsuario(this);

		return fotografiaPerfil;
	}

	public FotografiaPerfil removeFotografiaPerfil(FotografiaPerfil fotografiaPerfil) {
		getFotografiaPerfils().remove(fotografiaPerfil);
		fotografiaPerfil.setUsuario(null);

		return fotografiaPerfil;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setUsuario(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setUsuario(null);

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
		publicacion.setUsuario(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setUsuario(null);

		return publicacion;
	}

	public List<Recordatorio> getRecordatorios() {
		return this.recordatorios;
	}

	public void setRecordatorios(List<Recordatorio> recordatorios) {
		this.recordatorios = recordatorios;
	}

	public Recordatorio addRecordatorio(Recordatorio recordatorio) {
		getRecordatorios().add(recordatorio);
		recordatorio.setUsuario(this);

		return recordatorio;
	}

	public Recordatorio removeRecordatorio(Recordatorio recordatorio) {
		getRecordatorios().remove(recordatorio);
		recordatorio.setUsuario(null);

		return recordatorio;
	}

	public Comuna getComuna() {
		return this.comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

}
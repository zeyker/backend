package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the comentario database table.
 * 
 */
@Entity
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMENTARIO")
	private int idComentario;

	@Column(name="ACTIVO_COMENTARIO")
	private byte activoComentario;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_COMENTARIO")
	private Date fechaComentario;

	@Column(name="HORA_COMENTARIO")
	private Time horaComentario;

	@Lob
	@Column(name="TEXTO_COMENTARIO")
	private String textoComentario;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="ID_PUBLICACION")
	private Publicacion publicacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Comentario() {
	}

	public int getIdComentario() {
		return this.idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public byte getActivoComentario() {
		return this.activoComentario;
	}

	public void setActivoComentario(byte activoComentario) {
		this.activoComentario = activoComentario;
	}

	public Date getFechaComentario() {
		return this.fechaComentario;
	}

	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	public Time getHoraComentario() {
		return this.horaComentario;
	}

	public void setHoraComentario(Time horaComentario) {
		this.horaComentario = horaComentario;
	}

	public String getTextoComentario() {
		return this.textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}

	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
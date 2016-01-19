package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the recordatorio database table.
 * 
 */
@Entity
@NamedQuery(name="Recordatorio.findAll", query="SELECT r FROM Recordatorio r")
public class Recordatorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_RECORDATORIO")
	private int idRecordatorio;

	@Column(name="ACTIVO_RECORDATORIO")
	private byte activoRecordatorio;

	@Column(name="FECHA_RECORDATORIO")
	private Timestamp fechaRecordatorio;

	@Lob
	@Column(name="TEXTO_RECORDATORIO")
	private String textoRecordatorio;

	//bi-directional many-to-one association to Mascota
	@ManyToOne
	@JoinColumn(name="ID_MASCOTA")
	private Mascota mascota;

	//bi-directional many-to-one association to TipoDeRecordatorio
	@ManyToOne
	@JoinColumn(name="ID_TIPORECORDATORIO")
	private TipoDeRecordatorio tipoDeRecordatorio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Recordatorio() {
	}

	public int getIdRecordatorio() {
		return this.idRecordatorio;
	}

	public void setIdRecordatorio(int idRecordatorio) {
		this.idRecordatorio = idRecordatorio;
	}

	public byte getActivoRecordatorio() {
		return this.activoRecordatorio;
	}

	public void setActivoRecordatorio(byte activoRecordatorio) {
		this.activoRecordatorio = activoRecordatorio;
	}

	public Timestamp getFechaRecordatorio() {
		return this.fechaRecordatorio;
	}

	public void setFechaRecordatorio(Timestamp fechaRecordatorio) {
		this.fechaRecordatorio = fechaRecordatorio;
	}

	public String getTextoRecordatorio() {
		return this.textoRecordatorio;
	}

	public void setTextoRecordatorio(String textoRecordatorio) {
		this.textoRecordatorio = textoRecordatorio;
	}

	public Mascota getMascota() {
		return this.mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public TipoDeRecordatorio getTipoDeRecordatorio() {
		return this.tipoDeRecordatorio;
	}

	public void setTipoDeRecordatorio(TipoDeRecordatorio tipoDeRecordatorio) {
		this.tipoDeRecordatorio = tipoDeRecordatorio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
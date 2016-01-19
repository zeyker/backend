package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_de_recordatorio database table.
 * 
 */
@Entity
@Table(name="tipo_de_recordatorio")
@NamedQuery(name="TipoDeRecordatorio.findAll", query="SELECT t FROM TipoDeRecordatorio t")
public class TipoDeRecordatorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPORECORDATORIO")
	private int idTiporecordatorio;

	@Column(name="NOMBRE_TIPORECORDATORIO")
	private String nombreTiporecordatorio;

	//bi-directional many-to-one association to Recordatorio
	@OneToMany(mappedBy="tipoDeRecordatorio")
	private List<Recordatorio> recordatorios;

	public TipoDeRecordatorio() {
	}

	public int getIdTiporecordatorio() {
		return this.idTiporecordatorio;
	}

	public void setIdTiporecordatorio(int idTiporecordatorio) {
		this.idTiporecordatorio = idTiporecordatorio;
	}

	public String getNombreTiporecordatorio() {
		return this.nombreTiporecordatorio;
	}

	public void setNombreTiporecordatorio(String nombreTiporecordatorio) {
		this.nombreTiporecordatorio = nombreTiporecordatorio;
	}

	public List<Recordatorio> getRecordatorios() {
		return this.recordatorios;
	}

	public void setRecordatorios(List<Recordatorio> recordatorios) {
		this.recordatorios = recordatorios;
	}

	public Recordatorio addRecordatorio(Recordatorio recordatorio) {
		getRecordatorios().add(recordatorio);
		recordatorio.setTipoDeRecordatorio(this);

		return recordatorio;
	}

	public Recordatorio removeRecordatorio(Recordatorio recordatorio) {
		getRecordatorios().remove(recordatorio);
		recordatorio.setTipoDeRecordatorio(null);

		return recordatorio;
	}

}
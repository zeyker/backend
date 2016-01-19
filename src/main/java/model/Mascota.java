package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mascota database table.
 * 
 */
@Entity
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MASCOTA")
	private int idMascota;

	@Column(name="ACTIVO_MASCOTA")
	private byte activoMascota;

	@Column(name="CHIP")
	private byte chip;

	@Column(name="EDAD_MASCOTA")
	private int edadMascota;

	@Column(name="ESTERILIZADO")
	private byte esterilizado;

	@Column(name="NOMBRE_MASCOTA")
	private String nombreMascota;

	@Column(name="PERSONALIDAD")
	private String personalidad;
	
	@Column(name="RAZA")
	private String raza;

	@Column(name="SEXO_MASCOTA")
	private byte sexoMascota;

	@Column(name="TIMESTAMP_CREACION_MASCOTA")
	private Timestamp timestampCreacionMascota;

	@Column(name="VACUNA")
	private byte vacuna;

	//bi-directional many-to-one association to FotografiaMascota
	@OneToMany(mappedBy="mascota")
	private List<FotografiaMascota> fotografiaMascotas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to TipoMascota
	@ManyToOne
	@JoinColumn(name="ID_TIPO_MASCOTA")
	private TipoMascota tipoMascota;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="mascota")
	private List<Publicacion> publicacions;

	//bi-directional many-to-one association to Recordatorio
	@OneToMany(mappedBy="mascota")
	private List<Recordatorio> recordatorios;

	public Mascota() {
	}

	public int getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public byte getActivoMascota() {
		return this.activoMascota;
	}

	public void setActivoMascota(byte activoMascota) {
		this.activoMascota = activoMascota;
	}

	public byte getChip() {
		return this.chip;
	}

	public void setChip(byte chip) {
		this.chip = chip;
	}

	public int getEdadMascota() {
		return this.edadMascota;
	}

	public void setEdadMascota(int edadMascota) {
		this.edadMascota = edadMascota;
	}

	public byte getEsterilizado() {
		return this.esterilizado;
	}

	public void setEsterilizado(byte esterilizado) {
		this.esterilizado = esterilizado;
	}

	public String getNombreMascota() {
		return this.nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getPersonalidad() {
		return this.personalidad;
	}

	public void setPersonalidad(String personalidad) {
		this.personalidad = personalidad;
	}

	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public byte getSexoMascota() {
		return this.sexoMascota;
	}

	public void setSexoMascota(byte sexoMascota) {
		this.sexoMascota = sexoMascota;
	}

	public Timestamp getTimestampCreacionMascota() {
		return this.timestampCreacionMascota;
	}

	public void setTimestampCreacionMascota(Timestamp timestampCreacionMascota) {
		this.timestampCreacionMascota = timestampCreacionMascota;
	}

	public byte getVacuna() {
		return this.vacuna;
	}

	public void setVacuna(byte vacuna) {
		this.vacuna = vacuna;
	}

	public List<FotografiaMascota> getFotografiaMascotas() {
		return this.fotografiaMascotas;
	}

	public void setFotografiaMascotas(List<FotografiaMascota> fotografiaMascotas) {
		this.fotografiaMascotas = fotografiaMascotas;
	}

	public FotografiaMascota addFotografiaMascota(FotografiaMascota fotografiaMascota) {
		getFotografiaMascotas().add(fotografiaMascota);
		fotografiaMascota.setMascota(this);

		return fotografiaMascota;
	}

	public FotografiaMascota removeFotografiaMascota(FotografiaMascota fotografiaMascota) {
		getFotografiaMascotas().remove(fotografiaMascota);
		fotografiaMascota.setMascota(null);

		return fotografiaMascota;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoMascota getTipoMascota() {
		return this.tipoMascota;
	}

	public void setTipoMascota(TipoMascota tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	public Publicacion addPublicacion(Publicacion publicacion) {
		getPublicacions().add(publicacion);
		publicacion.setMascota(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setMascota(null);

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
		recordatorio.setMascota(this);

		return recordatorio;
	}

	public Recordatorio removeRecordatorio(Recordatorio recordatorio) {
		getRecordatorios().remove(recordatorio);
		recordatorio.setMascota(null);

		return recordatorio;
	}

}
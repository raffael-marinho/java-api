package model;

import java.sql.Date;

public class Exame {

	private Long id;
	private String descricao;
	private Date dataExame;
	private Long pacienteId;

	public Exame() {
	}

	public Exame(String descricao, Date dataExame, Long pacienteId) {
		this.descricao = descricao;
		this.dataExame = dataExame;
		this.pacienteId = pacienteId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataExame() {
		return dataExame;
	}

	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", descricao=" + descricao + ", dataExame=" + dataExame + ", pacienteId="
				+ pacienteId + "]";
	}
}

package model;

public class Paciente {

	private Long id;
	private String cpf;
	private String nome;

	public Paciente() {
	}

	public Paciente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", cpf=" + cpf + ", nome=" + nome + "]";
	}
}

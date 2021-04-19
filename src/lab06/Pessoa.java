package lab06;

import java.util.Date;
import java.util.Set;

import estados.EstadoPessoa;
import estados.NaoHabilitada;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private String endereco;
	private String numSUS;
	private String email;
	private String telefone;
	private String profissao;
	private String comorbidades;
	private int idade;
	private Date dataPrimeiraDose;
	
	private EstadoPessoa estado;

	public Pessoa(String nome, String cpf, String endereco, String numSUS, String email,
			String telefone, String profissao, String comorbidades, int idade) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.numSUS = numSUS;
		this.email = email;
		this.telefone = telefone;
		this.profissao = profissao;
		this.comorbidades = comorbidades;
		this.idade = idade;
		this.estado = new NaoHabilitada();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumSUS() {
		return numSUS;
	}

	public void setNumSUS(String numSUS) {
		this.numSUS = numSUS;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getComorbidades() {
		return this.comorbidades;
	}

	public void setComorbidades(String comorbidades) {
		this.comorbidades = comorbidades;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public EstadoPessoa getEstado() {
		return this.estado;
	}
	
	public void setEstado(EstadoPessoa estado) {
		this.estado = estado;
	}
	
	public void habilita(int idade, Set<String> profissoes, Set<String> comorbidades) {
		this.estado.habilita(this, idade, profissoes, comorbidades);
	}
	
	public void vacinar() {
		this.estado.vacina(this);
	}
	
	public void setDataPrimeiraDose(Date data) {
		this.dataPrimeiraDose = data;
	}
	
	public Date getDataPrimeiraDose() {
		return this.dataPrimeiraDose;
	}

}

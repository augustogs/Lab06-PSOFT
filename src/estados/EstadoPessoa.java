package estados;

import java.util.Set;

import lab06.Pessoa;

public abstract class EstadoPessoa {
	
	public void vacina(Pessoa pessoa){}
	
	public void habilita(Pessoa pessoa, int idade, Set<String> profissoes, Set<String> comorbidades) {}
		
}

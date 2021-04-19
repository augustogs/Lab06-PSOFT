package estados;

import java.util.Set;

import lab06.Pessoa;

public class NaoHabilitada extends EstadoPessoa {

	@Override
	public void habilita(Pessoa pessoa, int idade, Set<String> profissoes, Set<String> comorbidades) {
		if (pessoa.getIdade() >= idade || profissoes.contains(pessoa.getProfissao()) || 
			comorbidades.contains(pessoa.getComorbidades())) {
			pessoa.setEstado(new HabPrimeiraDose());
		}
	}
	
	public String toString() {
		return "Pessoa não habilitada.";
	}
}

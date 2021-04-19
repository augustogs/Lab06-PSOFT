package estados;

import lab06.Pessoa;

public class HabSegundaDose extends EstadoPessoa {

	@Override
	public void vacina(Pessoa pessoa) {
		pessoa.setEstado(new VacinaConcluida());
	}
	
	public String toString() {
		return "Pessoa habilitada para a segunda dose.";
	}

}

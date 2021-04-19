package estados;

import lab06.Pessoa;

public class HabPrimeiraDose extends EstadoPessoa {

	@Override
	public void vacina(Pessoa pessoa) {
		pessoa.setEstado(new VacPrimeiraDose());
	}
	
	public String toString() {
		return "Pessoa habilitada para a primeira dose.";
	}
}

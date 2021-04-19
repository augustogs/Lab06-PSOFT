package estados;

import java.util.Date;

import lab06.Pessoa;

public class VacPrimeiraDose extends EstadoPessoa {

	@Override
	public void vacina(Pessoa pessoa) {
		Date data = new Date() ;
		pessoa.setDataPrimeiraDose(data);
		pessoa.setEstado(new HabSegundaDose());
	}
	
	public String toString() {
		return "Pessoa vacinada com a primeira dose.";
	}

}

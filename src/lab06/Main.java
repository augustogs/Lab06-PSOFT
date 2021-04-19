package lab06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Map<String, Pessoa> pessoas = new HashMap<>();
		Set<String> comorbidades = new HashSet<String>();
		Set<String> profissoes = new HashSet<String>();
		int idadeVacinacao = 90;

		comorbidades.add("hipertensao");
		comorbidades.add("diabetes");

		profissoes.add("medico");
		profissoes.add("enfermeiro");

		menu();

		Scanner sc = new Scanner(System.in);
		int entrada = sc.nextInt();
		while (entrada == 1 || entrada == 2 || entrada == 3) {

			if (entrada == 1) {
				sc.nextLine();
				cadastraPessoa(sc, pessoas);
			}

			else if (entrada == 2) {
				alteraPessoa(sc, pessoas);
			}

			else {
				vacinaPessoa(sc, pessoas, comorbidades, profissoes, idadeVacinacao);
			}
			menu();
			entrada = sc.nextInt();
		}

	}

	public static void menu() {
		System.out.println("Sistema de vacinação COVID-19");
		System.out.println("1 - Realizar Cadastro");
		System.out.println("2 - Alterar Cadastro");
		System.out.println("3 - Vacinar");
		System.out.println("Opção:");
	}

	private static void cadastraPessoa(Scanner sc, Map<String, Pessoa> pessoas) {
		System.out.println("Nome:");
		String nome = sc.nextLine();

		System.out.println("CPF:");
		String cpf = sc.nextLine();

		System.out.println("Endereço:");
		String endereco = sc.nextLine();

		System.out.println("Número do cartão do SUS:");
		String numSUS = sc.nextLine();

		System.out.println("Email:");
		String email = sc.nextLine();

		System.out.println("Telefone:");
		String telefone = sc.nextLine();

		System.out.println("Profissão:");
		String profissao = sc.nextLine();

		System.out.println("Comorbidade:");
		String comorbidade = sc.nextLine();

		System.out.println("Idade:");
		int idade = sc.nextInt();
		sc.nextLine();

		Pessoa pessoa = new Pessoa(nome, cpf, endereco, numSUS, email, telefone, profissao, comorbidade, idade);
		pessoas.put(cpf, pessoa);

		System.out.println("Pessoa Cadastrada!");
		System.out.println();
	}

	public static void alteraPessoa(Scanner sc, Map<String, Pessoa> pessoas) {
		System.out.println("Digite seu CPF:");
		sc.nextLine();
		String cpfPessoa = sc.nextLine();

		Pessoa pessoa = pessoas.get(cpfPessoa);

		if (pessoa != null) {
			System.out.println("Qual informação deseja alterar?");
			System.out.println("1 - Nome");
			System.out.println("2 - CPF");
			System.out.println("3 - Endereco");
			System.out.println("4 - Número do cartão do SUS");
			System.out.println("5 - Email");
			System.out.println("6 - Telefone");
			System.out.println("7 - Profissao");
			System.out.println("8 - Comorbidades");

			int op = sc.nextInt();
			sc.nextLine();

			if (op == 1) {
				System.out.println("Novo Nome:");
				String novoNome = sc.nextLine();
				pessoa.setNome(novoNome);
			}

			else if (op == 2) {
				System.out.println("Novo CPF:");
				String novoCpf = sc.nextLine();
				pessoa.setCpf(novoCpf);
				pessoas.put(novoCpf, pessoa);
			}

			else if (op == 3) {
				System.out.println("Novo Endereço:");
				String novoEndereco = sc.nextLine();
				pessoa.setEndereco(novoEndereco);
			}

			if (op == 4) {
				System.out.println("Novo Numero do cartão do SUS:");
				String novoNumSus = sc.nextLine();
				pessoa.setNumSUS(novoNumSus);
			}

			else if (op == 5) {
				System.out.println("Novo Email:");
				String novoEmail = sc.nextLine();
				pessoa.setEmail(novoEmail);
			}

			else if (op == 6) {
				System.out.println("Novo Telefone:");
				String novoTelefone = sc.nextLine();
				pessoa.setTelefone(novoTelefone);
			}

			else if (op == 7) {
				System.out.println("Nova Profissão:");
				String novaProfissao = sc.nextLine();
				pessoa.setProfissao(novaProfissao);
			}

			else if (op == 8) {
				System.out.println("Nova Comorbidade:");
				String novaComorbidade = sc.nextLine();
				pessoa.setComorbidades(novaComorbidade);
			}
			System.out.println("Cadastro atualizado!");
			System.out.println();

		} else {
			System.out.println("Pessoa não cadastrada!");
			System.out.println();
		}
	}

	private static void vacinaPessoa(Scanner sc, Map<String, Pessoa> pessoas, Set<String> comorbidades,
			Set<String> profissoes, int idadeVacinacao) {
		System.out.println("Insira seu CPF:");
		sc.nextLine();
		String cpfP = sc.nextLine();

		Pessoa pessoa = pessoas.get(cpfP);
		if (pessoa != null) {
			//Inicialmente não habilitado para a vacina.
			System.out.println(pessoa.getEstado());

			//Pessoa habilitada para a primeira dose se atender os requisitos.
			pessoa.habilita(idadeVacinacao, profissoes, comorbidades);
			System.out.println(pessoa.getEstado());

			//Pessoa que recebeu a primeira dose;
			pessoa.vacinar();
			System.out.println(pessoa.getEstado());

			//Pessoa Habilitada para a segunda dose.
			pessoa.vacinar();
			System.out.println(pessoa.getEstado());

			//Pessoa vacinada
			pessoa.vacinar();
			System.out.println(pessoa.getEstado());

			System.out.println();
			System.out.println();
		} else {
			System.out.println("Pessoa não cadastrada!");
			System.out.println();
		}
	}

}

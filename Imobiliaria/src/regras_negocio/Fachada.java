/**********************************
 * IFPB - SI
 * Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/

package regras_negocio;

import java.util.List;

import daodb4o.DAO;
import daodb4o.DAOCliente;
import daodb4o.DAOVenda;
import daodb4o.DAOCorretor;
import daodb4o.DAOImovel;
import daodb4o.DAOPessoa;
import model.Venda;
import model.Cliente;
import model.Corretor;
import model.Imovel;
import model.Pessoa;

public class Fachada {
	private Fachada() {}		

	private static DAOCliente daocliente = new DAOCliente();  
	private static DAOCorretor daocorretor = new DAOCorretor(); 
	private static DAOVenda daovenda = new DAOVenda();  

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
	public static List<Venda> listarVenda() 	{
		DAO.begin();
		List<Venda> result = daovenda.readAll();
		DAO.commit();
		return result;
	}
	public static List<Cliente> listarClientes(String nome) {
		DAO.begin();
		List<Cliente> result = daocliente.readAll(nome);
		DAO.commit();
		return result;
	}
	public static List<Corretor> listarCorretor() {
		DAO.begin();
		List<Corretor> result = daocorretor.readAll();
		DAO.commit();
		return result;
	}
	public static Cliente localizarCliente(String nome) {
		DAO.begin();
		Cliente p = daocliente.read(nome);
		DAO.commit();
		return p;
	}
	public static Venda localizarVenda(int idVenda) 	{
		DAO.begin();
		Venda ev = daovenda.read(idVenda);
		DAO.commit();
		return ev;
	}
	public static Venda localizarVenda(String tipo) 	{
		DAO.begin();
		Venda ev = daovenda.read(tipo);
		DAO.commit();
		return ev;
	}

	public static Cliente criarCliente(String nome, int idade , String telefone, String estadocivil, int renda, int id) throws Exception {
		telefone = telefone.trim();
		nome = nome.trim();
		estadocivil = estadocivil.trim();

		DAO.begin();
		//localizar participante no repositorio, usando o nome 
		Cliente p = daocliente.read(nome);
		if (p!=null) {
			DAO.rollback();
			throw new Exception("N�o criou participante " + nome + " - ja cadastrado(a)");
		}

		//criar objeto Participante 
		p = new Cliente (nome, idade, telefone, estadocivil, renda, id);

		//criar participante no reposit�rio
		daocliente.create(p);
		DAO.commit();
		return p;	
	}	

	public static Corretor criarCorretor(String nome, int idade, String telefone, int creci, double salarioFixo, double comissao, int qntdVendas) throws Exception {
		nome = nome.trim();
		telefone = telefone.trim();
		
		
		DAO.begin();
		//localizar participante no repositorio, usando o nome 
		Corretor p = daocorretor.read(nome);
		if (p!=null) {
			DAO.rollback();
			throw new Exception("N�o criou Corretor " + nome + " - ja cadastrado(a)");
		}
		//a empresa � obrigatoria 
		if (telefone.isEmpty()) {
			DAO.rollback();
			throw new Exception("N�o criou Corretor " + nome + " - telefone é obrigatorio");
		}
		//criar objeto Convidado 
		Corretor c = new Corretor (nome, idade, telefone, creci, salarioFixo, comissao, qntdVendas);

		//criar convidado no reposit�rio
		daocorretor.create(c);
		DAO.commit();
		return c;	
	}

	public static Venda criarVenda (String tipo, String tipopagamento, int valorpagamento, int id) throws Exception {
		tipo = tipo.trim();
		tipopagamento = tipopagamento.trim();
		

		DAO.begin();
		//localizar Evento no repositorio, usando a data 
		Venda ev = daovenda.read(id);
		if (ev!=null) {
			DAO.rollback();
			throw new Exception("N�o criou a venda pois: " + id + " - ja existe em outra venda");
		}
		if (valorpagamento <0) {
			DAO.rollback();
			throw new Exception("N�o criou evento: " + id + " - preco de pagamento nao pode ser negativo ");
		}

		//gerar id no repositorio
		ev = new Venda(tipo, tipopagamento, valorpagamento, id);	

		//adicionar evento no reposit�rio
		daovenda.create(ev);
		//gravar reposit�rio
		DAO.commit();
		return ev;
	}

	public static void 	adicionarClienteVenda(String nome, int id) throws Exception {
		nome = nome.trim();

		DAO.begin();
		//localizar participante no repositorio, usando o nome 
		Cliente p = daocliente.read(nome);
		if(p == null)  {
			DAO.rollback();
			throw new Exception("N�o adicionou Cliente " + nome + " - inexistente");
		}

		//localizar evento no repositorio, usando id 
		Venda ev = daovenda.read(id);
		if(ev == null)  {
			DAO.rollback();
			throw new Exception("N�o adicionou Cliente "+nome+ " - venda " + id + " inexistente");
		}

		//localizar o participante dentro do evento, usando o nome
		Cliente paux = ev.localizar(nome);
		if(paux != null) {
			DAO.rollback(); 
			throw new Exception("N�o adicionou participante " + nome + " - j� participa do evento " + id);
		}
		//adicionar o participante ao evento
		ev.adicionar(p);
		//adicionar o evento ao participante
		p.adicionar(ev);

		//atualizar objetos no banco
		daovenda.update(ev);
		daocliente.update(paux);
		DAO.commit();
	}

	public static void 	removerClienteVenda(String nome, int id) throws Exception {
		nome = nome.trim();

		DAO.begin();
		//localizar participante no repositorio, usando o nome 
		Cliente p = daocliente.read(nome);
		if(p == null)  {
			DAO.rollback();
			throw new Exception("N�o removeu cliente " + nome + " - inexistente");
		}

		//localizar evento no repositorio, usando id 
		Venda ev = daovenda.read(id);
		if(ev == null)  {
			DAO.rollback();
			throw new Exception("N�o removeu Cliente " + nome +" -  Venda " + id + " inexistente");
		}

		//localizar o participante dentro do evento, usando o nome
		Cliente paux = ev.localizar(nome);
		if(paux == null)  {
			DAO.rollback();
			throw new Exception("N�o removeu participante " + nome + " - nao participa do evento " + id);
		}
		//remover o participante do evento
		ev.remover(p);
		//remover o evento do participante
		p.remover(ev);

		//atualizar objetos no banco
		daovenda.update(ev);
		daocliente.update(p);
		DAO.commit();
	}

	public static void apagarVenda(int id) throws Exception	{

		DAO.begin();
		//localizar evento no repositorio, usando id 
		Venda ev = daovenda.read(id);
		if (ev == null) {
			DAO.rollback();
			throw new Exception("N�o deletou venda " + id + " - inexistente");
		}
		
		//Remover este evento de todos os participantes e atualizar participante 
		for(Cliente p : ev.getClientes()) {
			p.remover(ev);
			daocliente.update(p);
		}
		
		//apagar evento no banco
		daovenda.delete(ev);
		DAO.commit();
	}

	public static void aumentoDaVenda(int id, int valorpagamento, int novoValor) throws Exception	{

		DAO.begin();
		//localizar evento no repositorio, usando data 
		Venda ev = daovenda.read(id);
		if (ev == null) {
			DAO.rollback();
			throw new Exception("N�o aumentou o preco da venda - " + id +"  inexistente ");
		}
		//localizar evento no repositorio, usando novadata
		Venda aux = daovenda.read(novoValor);
		if (aux != null) {
			DAO.rollback();
			throw new Exception("N�o aumentou o valor da venda de " + id + " - ja existe um valor em outra venda ");
		}
		//alterar a data do evento
		ev.setPreco(novoValor);

		//atualizar no banco
		daovenda.update(ev);
		DAO.commit();
	}

	public static void 	apagarCliente(String nome) throws Exception {
		nome = nome.trim();

		DAO.begin();
		//localizar participante no repositorio, usando o nome 
		Cliente p = daocliente.read(nome);
		if(p == null)  {
			DAO.rollback();
			throw new Exception("N�o deletou participante " + nome + " - inexistente");
		}
		//participante nao pode ser deletado caso participe de algum evento
		if(!p.getVendas().isEmpty())  {
			DAO.rollback();
			throw new Exception("N�o deletou participante " + nome + " - ja tem evento");
		}
		//apagar no banco
		daocliente.delete(p);
		DAO.commit();
	}

	
	/*
	 * CONSULTAS
	 */
	
	public static List<Venda> consultarVendaNClientes(int n){
		return daovenda.consultarVendaNClientes(n);
	}
	
	public static int consultarVendasCorretor() {
		return daocorretor.consultarVendasCorretor();
	}

	public static int consultarRendaMaior() {
		return daocliente.consultarRendaMaior();
	}
}

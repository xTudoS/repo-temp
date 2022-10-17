package aplicacao;

import model.Cliente;
import model.Venda;
import model.Corretor;
import model.Pessoa;
import regras_negocio.Fachada;

public class Excecoes {

	public Excecoes() {
		Fachada.inicializar();
		
		Cliente p;
		Corretor c;
		Venda ev;
		
		System.out.println("\n-------TESTE DE EXCE��ES LAN�ADAS PELOS METODOS DA FACHADA--------");
		try {
			p = Fachada.criarCliente("p1",10, "123123", "solteiro", 1000, 1);
			p = Fachada.criarCliente("p2",12, "123456", "viuvo", 2000, 2);
			System.out.println("*************1--->Nao lan�ou exce��o para: criar participante existente "); 
		}catch (Exception e) {System.out.println("1ok--->"+e.getMessage());}

		try {
			c = Fachada.criarCorretor("c1", 30, "43214321", 123123, 800, 250, 4);
			c = Fachada.criarCorretor("c2", 20, "65436543", 321321, 1000, 350, 7);
			System.out.println("*************2--->Nao lan�ou exce��o para: criar convidado existente "); 
		}catch (Exception e) {System.out.println("2ok--->"+e.getMessage());}

		try {
			ev = Fachada.criarVenda("comercial","a vista", 1200, 1);
			ev = Fachada.criarVenda("residencial","parcelado", 3200, 2);
			System.out.println("*************3--->Nao lan�ou exce��o para: criar evento existente "); 
		}catch (Exception e) {System.out.println("3ok--->"+e.getMessage());}

		try {
			ev = Fachada.criarVenda("comercial","a vista", -1200, 3);
			System.out.println("*************4--->Nao lan�ou exce��o para: criar evento preco negativo "); 
		}catch (Exception e) {System.out.println("4ok--->"+e.getMessage());}

		try {
			ev = Fachada.criarVenda("comercial","a vista", 1200, 4);
			Fachada.aumentoDaVenda(4,1200, 2000);
			System.out.println("*************5--->Nao lan�ou exce��o para: adiar evento data existente"); 
		}catch (Exception e) {System.out.println("5ok--->"+e.getMessage());}

		try 
		{
			Fachada.adicionarClienteVenda("p1", 1);	
			Fachada.adicionarClienteVenda("p1", 1);	
			System.out.println("*************6--->Nao lan�ou exce��o: adicionar participante evento que participa"); 
		}catch (Exception e) {System.out.println("6ok--->"+e.getMessage());}

		try 
		{
			Fachada.removerClienteVenda("p1", 1);	
			Fachada.removerClienteVenda("p1", 1);	
			System.out.println("*************7--->Nao lan�ou exce��o: remover participante evento que nao participa"); 
		}catch (Exception e) {System.out.println("7ok--->"+e.getMessage());}

		try 
		{
			Fachada.adicionarClienteVenda("p2", 1);	
			System.out.println("*************8--->Nao lan�ou exce��o: adicionar participante inexistente"); 
		}catch (Exception e) {System.out.println("8ok--->"+e.getMessage());}

		try 
		{
			Fachada.removerClienteVenda("p2", 1);	
			System.out.println("*************9--->Nao lan�ou exce��o: remover participante inexistente "); 
		}catch (Exception e) {System.out.println("9ok--->"+e.getMessage());}

		try 
		{
			Fachada.apagarVenda(1);	
			Fachada.apagarVenda(1);	
			System.out.println("*************10--->Nao lan�ou exce��o: apagar evento inexistente"); 
		}catch (Exception e) {System.out.println("10ok--->"+e.getMessage());}

		try 
		{
			Fachada.apagarCliente("p2");	
			System.out.println("*************11--->Nao lan�ou exce��o: apagar participante inexistente"); 
		}catch (Exception e) {System.out.println("11ok--->"+e.getMessage());}
	
	
		//apagar dados usados no teste
		try {Fachada.apagarVenda(2);}	catch (Exception e){}		
		try {Fachada.apagarVenda(3);}	catch (Exception e){}		
		try {Fachada.apagarVenda(4);}	catch (Exception e) {}		
		try {Fachada.apagarCliente("p1");} catch (Exception e){}
		try {Fachada.apagarCliente("p2");} catch (Exception e){}
		try {Fachada.apagarCliente("c1");} catch (Exception e){}

		Fachada.finalizar();
	}


	public static void main (String[] args) 
	{
		new Excecoes();
	}
}



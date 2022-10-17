package aplicacao;
import model.Imovel;
import model.Corretor;
import model.Cliente;
import model.Venda;
import regras_negocio.Fachada;

public class Consultar {
	public Consultar() {
		try {
			Fachada.inicializar();
			Venda venda = Fachada.localizarVenda(1);
			System.out.println("localizou evento:\n" + venda);
			
			System.out.println("\n---------participantes com nome z -----");
			for(Cliente p : Fachada.listarClientes("z")) 
				System.out.println(p);
			
			System.out.println("\n---------eventos com 5 participantes");
			for(Venda v : Fachada.consultarVendaNClientes(5)) 
				System.out.println(v);
			System.out.println("\n---------eventos com 0 participantes");
			for(Venda v : Fachada.consultarVendaNClientes(0)) 
				System.out.println(v);
			
			System.out.println("\n---------Total de vendas do Corretor: " + Fachada.consultarVendasCorretor()); 
			System.out.println("\n---------total de clinte de renda maior a 1000 (renda >= 1000) "+Fachada.consultarRendaMaior());
		
			
		} catch (Exception e) {
			System.out.println("--->"+e.getMessage());
		}	

		Fachada.finalizar();
	}

	public static void main (String[] args) 
	{
		new Consultar();
	}
}

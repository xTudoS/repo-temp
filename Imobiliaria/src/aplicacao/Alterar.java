package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import model.Corretor;


public class Alterar {
	protected ObjectContainer manager;

	public Alterar(){
		manager = Util.conectarDb4oAgendaLocal();
		atualizar();
		manager.close();

		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
	}

	public void atualizar(){
		//localizar pelo CRECI e alterar quantidade de vendas do motor para 5

		Query q = manager.query();
		q.constrain(Corretor.class);  				
		q.descend("creci").constrain("####");		 
		List<Corretor> resultados = q.execute(); 

		if(resultados.size()>0) {
			Corretor c =  resultados.get(0);
			c.getCreci().setqntdVendas(20);
			manager.delete(c);
			manager.commit();
			System.out.println("alterou ");
		}
		else
			System.out.println("inexistente");
	}



	//=================================================
	public static void main(String[] args) {
		new Alterar();
	}
}


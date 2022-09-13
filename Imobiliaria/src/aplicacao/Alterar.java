package aplicacao;

// Importar Imovel?

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
import Imovel

public class Alterar {
	protected ObjectContainer manager;

	public Alterar(){
		manager = Util.conectarDb4oAgendaLocal();
		atualizar();
		manager.close();

		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
	}

	public void atualizar(){
		
		Query q = manager.query();
		q.constrain(Imovel.class);  				
		q.descend("creci").constrain("####");		 
		List<Imovel> resultados = q.execute(); 

		if(resultados.size()>0) {
			Imovel i =  resultados.get(0);
			i.getProprietario().setProprietario(Joao);
			manager.delete(i);
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


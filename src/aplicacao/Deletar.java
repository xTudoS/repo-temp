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

import model.Imovel;
import model.Pessoa;


public class Deletar {
	protected ObjectContainer manager;

	public Deletar(){
		manager = Util.conectarDb4oAgendaLocal();
		apagarImovel();
		manager.close();
		
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplica��o");
	}

	public void apagarImovel(){
		
		
		Query q = manager.query();
		q.constrain(Imovel.class);  				
		q.descend("endereco").constrain("rua da areia");		 
		List<Imovel> resultados = q.execute(); // select p from Pessoa p where p.nome="maria"
	
		if(resultados.size()>0) {
			Imovel p =  resultados.get(0);
			p.setProprietario(null);
			manager.delete(p);
			manager.commit();
			System.out.println("apagou Imovel com endereco em Rua da Areia");
		}
		else
			System.out.println("Imovel inexistente");
	}
	
	public void apagarPessoa(){
		
		
		Query q = manager.query();
		q.constrain(Pessoa.class);  				
		q.descend("nome").constrain("paulo");		 
		List<Pessoa> resultados = q.execute(); // select p from Pessoa p where p.nome="paulo"
	
		if(resultados.size()>0) {
			Pessoa p = resultados.get(0);
			List<Imovel> imoveis = p.getImoveis();
			for (Imovel l : imoveis) {
				imoveis.remove(l);
			}
			manager.delete(p);
			manager.commit();
			System.out.println("apagou Paulo");
		}
		else
			System.out.println("Pessoa inexistente");
	}


	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}


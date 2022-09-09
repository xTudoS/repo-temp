package aplicacao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import model.Imovel;
import model.Pessoa;

public class Listar {
	protected ObjectContainer manager;
	
	
	public Listar(){
		manager = Util.conectarDb4oAgendaLocal();
		listar();
		manager.close();
	}

	public void listar(){
		System.out.println("-------Lista de Imoveis--------");
		Query q = manager.query();
		q.constrain(Pessoa.class);  				
		List<Pessoa> resultados = q.execute();
		for (Pessoa pes : resultados ) {
			System.out.println(pes);
		}
		
		System.out.println("\n-------Lista de Pessoas--------");
		Query l = manager.query();
		l.constrain(Imovel.class);
		List<Imovel> result = l.execute();
		for (Imovel imov : result) {
			System.out.println(imov);
		}
	}

	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}



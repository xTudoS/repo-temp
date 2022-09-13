package aplicacao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import model.Pessoa;
import model.Imovel;

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
		q.descend("proprietario").descend("nome").constrain("maria");		 
		List<Imovel> resultados = q.execute(); 

		if(resultados.size()>0) {
			Imovel i =  resultados.get(0);
			i.setProprietario(new Pessoa("Joao", 19, "8399923992"));
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


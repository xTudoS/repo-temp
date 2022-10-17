package daodb4o;


import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import model.Venda;

public class DAOVenda  extends DAO<Venda>{

	public Venda read (Object chave) {
		int id = (Integer) chave;	
		Query q = manager.query();
		q.constrain(Venda.class);
		q.descend("idVenda").constrain(id);
		List<Venda> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public void create(Venda obj){
		int novoId = super.gerarId();  	//gerar novo id da classe
		obj.setId(novoId);				//atualizar id do objeto antes de grava-lo no banco
		manager.store( obj );
	}
	
	public List<Venda> consultarVendaNClientes(int n){
		Query q = manager.query();
		q.constrain(Venda.class);
		q.constrain(new Filtro(n));
		return q.execute();
	}
	@SuppressWarnings("serial")
	class Filtro  implements Evaluation {
		private int n;
		public Filtro (int n) {
			this.n=n;
		}

		public void evaluate(Candidate candidate) {
			Venda e = (Venda) candidate.getObject();
			candidate.include( e.getClientes().size()==n );
		}
	}
}




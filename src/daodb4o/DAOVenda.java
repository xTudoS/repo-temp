package daodb4o;


import java.util.List;

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
}




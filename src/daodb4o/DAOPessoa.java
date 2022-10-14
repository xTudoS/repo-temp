package daodb4o;


import java.util.List;

import com.db4o.query.Query;

import model.Pessoa;

public class DAOPessoa  extends DAO<Pessoa>{

	public Pessoa read (Object chave) {
		int id = (Integer) chave;	
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("idPessoa").constrain(id);
		List<Pessoa> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public void create(Pessoa obj){
		int novoId = super.gerarId();  	//gerar novo id da classe
		obj.setId(novoId);				//atualizar id do objeto antes de grava-lo no banco
		manager.store( obj );
	}
}




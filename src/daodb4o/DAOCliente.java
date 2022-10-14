package daodb4o;


import java.util.List;

import com.db4o.query.Query;

import model.Cliente;

public class DAOCliente  extends DAO<Cliente>{

	public Cliente read (Object chave) {
		int id = (Integer) chave;	
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("idCliente").constrain(id);
		List<Cliente> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public void create(Cliente obj){
		int novoId = super.gerarId();  	//gerar novo id da classe
		obj.setId(novoId);				//atualizar id do objeto antes de grava-lo no banco
		manager.store( obj );
	}
}




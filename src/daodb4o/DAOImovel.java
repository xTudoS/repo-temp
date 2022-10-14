/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daodb4o;


import java.util.List;

import com.db4o.query.Query;

import model.Imovel;

public class DAOImovel  extends DAO<Imovel>{

	public Imovel read (Object chave) {
		int id = (Integer) chave;	
		Query q = manager.query();
		q.constrain(Imovel.class);
		q.descend("id").constrain(id);
		List<Imovel> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public void create(Imovel obj){
		int novoid = super.gerarId();  	//gerar novo id da classe
		obj.setId(novoid);				//atualizar id do objeto antes de grava-lo no banco
		manager.store( obj );
	}
}




package aplicacao;

import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

import model.Imovel;
import model.Pessoa;

public class Util {

	public static ObjectContainer conectarDb4oAgendaLocal(){
		//---------------------------------------
		//configurar e conectar/criar banco local
		//---------------------------------------
		
//		new File("banco.db4o").delete();
		
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // mensagens na tela 0(desliga),1,2,3...
		
		// habilitar cascata na altera��o, remo��o e leitura
		config.common().objectClass(Imovel.class).cascadeOnDelete(false);;
		config.common().objectClass(Imovel.class).cascadeOnUpdate(true);;
		config.common().objectClass(Imovel.class).cascadeOnActivate(true);
		config.common().objectClass(Pessoa.class).cascadeOnDelete(false);;
		config.common().objectClass(Pessoa.class).cascadeOnUpdate(true);;
		config.common().objectClass(Pessoa.class).cascadeOnActivate(true);
		
		// criar indices (opcional) sobre campos de busca
		config.common().objectClass(Imovel.class).objectField("endereco").indexed(true);
		config.common().objectClass(Pessoa.class).objectField("nome").indexed(true);
		
		// nivel de profundidade do grafo para leitura e atualiza��o
		config.common().objectClass(Imovel.class).updateDepth(5);
		config.common().objectClass(Imovel.class).minimumActivationDepth(5);
		config.common().objectClass(Pessoa.class).updateDepth(5);
		config.common().objectClass(Pessoa.class).minimumActivationDepth(5);
		//conexao local
		ObjectContainer manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
	}

	
	
}

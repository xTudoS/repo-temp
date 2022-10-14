/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

package daodb4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;

import model.Imovel;

public class Util {

	public static ObjectContainer conectarDb4oLocal(){
		//---------------------------------------
		//configurar e conectar/criar banco local
		//---------------------------------------

		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // mensagens na tela 0(desliga),1,2,3...

		// habilitar cascata na altera��o, remo��o e leitura
		// --nehuma cascata

		// criar indices (opcional) sobre campos de busca
		config.common().objectClass(Imovel.class).objectField("id").indexed(true);

		//conexao local (embarcada)
		ObjectContainer manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
	}


	public static ObjectContainer conectarDb4oRemoto(){		
		//---------------------------------------
		//configurar e conectar/criar banco remoto
		//---------------------------------------

		ClientConfiguration config = Db4oClientServer.newClientConfiguration( ) ;
		config.common().messageLevel(0);   //0,1,2,3,4

		// habilitar cascata na altera��o, remo��o e leitura
		// --nehuma cascata

		// criar indices (opcional) sobre campos de busca
		config.common().objectClass(Imovel.class).objectField("id").indexed(true);

		//Conex�o cliente/servidor 
		//ObjectContainer manager = Db4oClientServer.openClient(config,"localhost",34000,"usuario1","senha1");
		ObjectContainer manager = Db4oClientServer.openClient(config,"34.207.139.216",34000,"usuario1","senha1");
		return manager;
	}

}

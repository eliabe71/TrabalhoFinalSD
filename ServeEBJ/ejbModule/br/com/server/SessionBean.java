package br.com.server;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.database.Universidade;




/**
 * Session Bean implementation class SessionBean
 */
@Stateless
@LocalBean
public class SessionBean implements RemoteServer {

    /**
     * Default constructor. 
     */
	public Universidade uni = new Universidade();
	
	
	
	@Override
	public String getString(String nome) {
		return nome;
	}
	
    public String SessionMetodoBean() {
    	
    	return "Eliabe";
    }

}

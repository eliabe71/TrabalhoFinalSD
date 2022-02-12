package br.com.server;
import javax.ejb.Remote;


@Remote
public interface RemoteServer {
	public String getString(String nome);
}

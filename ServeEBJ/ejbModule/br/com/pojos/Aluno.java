package br.com.pojos;

public class Aluno extends Pessoa{
	private int matricula;
	private String curso;
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String toJson() {
		return "{ \"matricula\": "+matricula +", \"curso\": \""+curso+"\", \"nome\": "+"\""+nome+"\""+"}";
	}
}

package br.com.pojos;

public class Professor extends Pessoa{
	private int matricula;
	private String area;
	public int getMatricula() {
		return this.matricula;
	}
	
	public String getArea() {
		return this.area;
	}
	
	public String getName() {
		return this.nome;
	}	

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public String toJson() {
		return "{ \"matricula\": "+matricula +", \"area\": \""+area+"\", \"nome\": "+"\""+nome+"\""+"}";
	}
}

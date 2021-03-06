package br.com.database;

import java.util.ArrayList;

import br.com.pojos.*;

public class Turma {
	private String nomeMateria;
	private ArrayList<Professor> profs;
	private ArrayList<Aluno> aluns;
	public Turma() {
		this.aluns = new ArrayList<Aluno>();
		this.profs = new ArrayList<Professor>(); 
	}
	public String toJson() {
		return "{\"numeroDeAlunos\" :"+ aluns.size() + ", \"numeroDeProfessores\": "+profs.size() + " }";
	}
	public ArrayList<Professor> getProfs() {
		return profs;
	}
	
	public String getNomeMateria() {
		return nomeMateria;
	}
	
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	public void setProfs(ArrayList<Professor> profs) {
		this.profs = profs;
	}
	public ArrayList<Aluno> getAluns() {
		return aluns;
	}
	public Boolean addAluno( Aluno a) {
		for( int i = 0 ; i< aluns.size() ; i++ ) {
			if(aluns.get(i).getMatricula()== a.getMatricula()) {
				return false;
			}
		}
		aluns.add(a);
		return true;
	}
	
	public Boolean RemoveAluno( Aluno a) {
		for( int i = 0 ; i< aluns.size() ; i++ ) {
			if(aluns.get(i).getMatricula()== a.getMatricula()) {
				aluns.remove(i);
				return true;
			}
		}
		return false;
	}
	public Boolean addProfessor( Professor a) {
		for( int i = 0 ; i< profs.size() ; i++ ) {
			if(profs.get(i).getMatricula()== a.getMatricula()) {
				return false;
			}
		}
		profs.add(a);
		return true;
	}
	
	public Boolean RemoveProfessor( Professor a) {
		for( int i = 0 ; i< profs.size() ; i++ ) {
			if(profs.get(i).getMatricula()== a.getMatricula()) {
				profs.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void setAluns(ArrayList<Aluno> aluns) {
		this.aluns = aluns;
	}
}

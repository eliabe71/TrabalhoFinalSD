package br.com.database;

import java.util.ArrayList;

import br.com.pojos.*;

public class Universidade {
	private ArrayList<Turma> turmas;
	
	public Universidade() {
		turmas = new ArrayList<Turma>();
	}
	public Boolean addTurma(String t) {
		Turma T = new Turma();
		T.setNomeMateria(t);
		for(int i =0 ; i < turmas.size() ; i++) {
			if(turmas.get(i).getNomeMateria().equals(t)) {
				return false;
			}
		}
		turmas.add(T);
		return true;
	}
	public String getMateria(String materia) {
		for(int i =0 ; i < turmas.size() ; i++) {
			if(turmas.get(i).getNomeMateria().equals(materia)) {
				return turmas.get(i).toJson();
			}
		}
		return "Materia nao existe";
	}
	public String getValue(String s, String key){
		if(s.contains(key)){
			String []nw = s.split(key);
			String value = nw[1].replace(":" , "");
			value = value.replace("\"", "");
			value = value.replace("}", "");
			if(value.indexOf(',') > -1 ){
				value = value.substring(0, value.indexOf(','));    
			}
			value = value.trim();

			return value;
		}
		return "";
	}
	public String getAllMaterias() {
			String resp = "{\"Turmas\" : [ ";
			for(int i = 0 ; i  < turmas.size() ; i++) {
				if(i == turmas.size()-1) {
					resp = resp+"\""+turmas.get(i).getNomeMateria()+"\"";
				}
				else {
					resp = resp+"\""+turmas.get(i).getNomeMateria();
					resp = resp+"\",";
				}
			}
			resp = resp + "] }";
			return resp;
	}
	
	public Boolean addAluno(String turma , Aluno a) {
		Boolean flag = false;
		for(int i = 0 ; i < turmas.size() ; i++) {
			if(turmas.get(i).getNomeMateria().equals(turma) ) {
				flag = true;
				for( int j = 0 ; j < turmas.get(i).getAluns().size() ; j++) {
					if(turmas.get(i).getAluns().get(j).getMatricula() == a.getMatricula()) {
						return false;
					}
				}
				turmas.get(i).getAluns().add(a);
			}
		}
		return true && flag;
	}
	
	public Boolean addProfessor(String turma , Professor  a) {
		Boolean flag = false;
		for(int i = 0 ; i < turmas.size() ; i++) {
			Turma oldT = turmas.get(i);
			if(oldT.getNomeMateria().equals(turma) ) {
				flag = true;
				for( int j = 0 ; j < oldT.getProfs().size() ; j++) {
					if(oldT.getProfs().get(j).getMatricula() == a.getMatricula()) {
						return false;
					}
				}
				turmas.get(i).addProfessor(a);
			}
		}
		return true && flag;
	}
	
	public String getAluno(String turma , int matricula) {
		for(int i =0 ; i < turmas.size(); i++) {
			if(turmas.get(i).getNomeMateria().equals(turma)) {
				for(int j =0 ; j < turmas.get(i).getAluns().size() ; j++) {
					if(turmas.get(i).getAluns().get(j).getMatricula() == matricula ){
						return turmas.get(i).getAluns().get(j).toJson();
					}
				}
			}
			return "{}";
		}
		return "{}";
	}	
	public Boolean removeMateria(String name) {
		for(int i =0 ; i < turmas.size() ; i++) {
			if(turmas.get(i).getNomeMateria().equals(name)) {
				turmas.remove(i);
				return true;
			}
		}
		return false;
	}
}

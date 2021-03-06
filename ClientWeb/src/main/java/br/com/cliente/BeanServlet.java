package br.com.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wsdl.util.IOUtils;

import br.com.pojos.Aluno;
import br.com.pojos.Professor;
import br.com.server.SessionBean;

/**
 * Servlet implementation class BeanServlet
 */
@WebServlet({"/"})
public class BeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    SessionBean rem;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//Buscando aluno de uma materia
		if(request.getRequestURL().toString().contains("infos")) {
			String[] n =  request.getRequestURL().toString().split("infos/");
			String str = n[1].trim();
			out.write(rem.uni.getMateria(str));
		}
		if(request.getRequestURL().toString().contains("all")) {
			out.write(rem.uni.getAllMaterias());
		}
		if(request.getRequestURL().toString().contains("aluno")) {
			String[] n =  request.getRequestURL().toString().split("aluno/");
	        String []str2 =  n[1].split("/");
	        String str = str2[0].trim();
	        String nomeM = str2[1];
	        try{
	            int number = Integer.parseInt(str);
	            String dd = rem.uni.getAluno(nomeM, number);
	            out.write(dd);
	            System.out.println(number); // output = 25
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
			
		}
//		
//		//Cadrastando uma materia
		if(request.getRequestURL().toString().contains("materias")) {
			String[] n =  request.getRequestURL().toString().split("materias/");
	        String str = n[1].trim();
	        if(rem.uni.addTurma(str))
	        	out.write("{\"result\": \"sucess\"}");
	        else 
	        	out.write("{\"result\": \"failed\"}");
		}
		if(request.getRequestURL().toString().contains("removem")) {
			String[] n =  request.getRequestURL().toString().split("removem/");
	        String str = n[1].trim();
	        if(rem.uni.removeMateria(str))
	        	out.write("{\"result\": \"sucess\"}");
	        else 
	        	out.write("{\"result\": \"failed\"}");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//Cadrasto de um aluno 
		if(request.getRequestURL().toString().contains("cadrastoaluno")) {
			String test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			Aluno na = new Aluno();
			String name = rem.uni.getValue(test, "nome");
			String materia = rem.uni.getValue(test, "materia");;
			String curso = rem.uni.getValue(test, "curso");;
			String matricula = rem.uni.getValue(test, "matricula");;
			na.setCurso(curso.trim());
	        try{
	            int number = Integer.parseInt(matricula.trim());
	            na.setMatricula(number);
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        } 
	        na.setNome(name);
	        if( rem.uni.addAluno(materia.trim(), na)) {
	        	out.write("{\"Result\": \"Sucess\" }");
	        }else {
	        	out.write("{\"Result\": \"Failed\" }");
	        }
			
		}
		
		//cadrasto professor 
		if(request.getRequestURL().toString().contains("cadrastoprof")) {
			String test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			Professor na = new Professor();
			String name = rem.uni.getValue(test, "nome");
			String materia = rem.uni.getValue(test, "materia");;
			String area = rem.uni.getValue(test, "area");;
			String matricula = rem.uni.getValue(test, "matricula");;
			na.setArea(area.trim());
	        try{
	            int number = Integer.parseInt(matricula.trim());
	            na.setMatricula(number);
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        } 
	        na.setNome(name);
	        if( rem.uni.addProfessor(materia.trim(), na)) {
	        	out.write("{\"Result\": \"Sucess\" }");
	        }else {
	        	out.write("{\"Result\": \"Failed\" }");
	        }
			
		}
	}

}

package estudoparaconcurso;


import java.util.ArrayList;
import java.util.Date;

public class Teste {
	static Pessoa p;
	static Aluno a;
	static AdministradorBanca ab;
	static Edital e;
	static Banca b;
	static Prova pr;
	static Questao q;
	static Date d1;
	static Date d2;
    static ArrayList<AdministradorBanca> administradorBanca;
	static ArrayList<Questao> tipoMultiplaescolha;
	static ArrayList<String> alternativas;
	
	
	@SuppressWarnings("deprecation")
	public static void main(String [] args) {
		a = new Aluno ("Aluno 1", "aluno1@email.com", "254ppe", 00001);
		ab = new AdministradorBanca ("Administrador 1", "administrador@email.com", "4445otr", 00540);
		e = new Edital ("ConcursoX", "Regra 1",50.00, d1, d2, pr, b);
		d1 = new Date(12, 26, 31);
		d2 = new Date(13,05,23);
		b = new Banca("Banca 1", administradorBanca);
		pr = new Prova ("Escever", tipoMultiplaescolha);
		q = new Questao ("Questao Mat", alternativas);
		
		
	    
	  
		
		
		System.out.println(a.toString());
		System.out.println(ab.toString());
		System.out.println(e.toString());
		System.out.println(d1.toString());
		System.out.println(d2.toString());
		System.out.println(b.toString());
		System.out.println(pr.toString());
		System.out.println(q.toString());
		
	}
}
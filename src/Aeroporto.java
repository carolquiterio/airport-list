import java.lang.reflect.Method;

public class Aeroporto implements Cloneable // Comparable<Aeroporto>,
{
	private String codigo;
	private String nome;
	private int numero;
	private ListaSimplesDesordenada<Voo> listaDeVoos;

	public Aeroporto(String codigo, String nome, int numero)throws Exception
	{
		 this.setCodigo(codigo.toUpperCase());
		 this.setNome  (nome.toUpperCase());
		 this.setNumero(numero);
		 this.listaDeVoos = new ListaSimplesDesordenada<Voo> ();
	}
	//setters
	 public void setCodigo(String codigo) throws Exception
	 {
		 if(codigo == null || codigo.equals(""))
		 throw new Exception("Codigo invalido!");

		 this.codigo = codigo;
	 }
	 public void setNome(String nome) throws Exception
	 {
		 if(nome == null || nome.equals(""))
			throw new Exception("Nome invalido!");

		 this.nome = nome;
     }
	public void setNumero(int num) throws Exception
	 {
		 if(num <= 0)
			throw new Exception("Numero invalido!");

		 this.numero = numero;
     }
     //getters
	 public String getCodigo()
     {
 		 return this.codigo;
   	 }

	 public String getNome()
	 {
		 return this.nome;
	 }

	 public int getNumero()
	 {
		 return this.numero;
	 }

	 public Voo getVooComParam(int i) throws Exception
	 {
	     if (this.listaDeVoos.getDoInicio()==null/*&&this.ultimo==null)*/)
	         throw new Exception ("Nada a obter");

	     Voo ret = this.listaDeVoos.getComParam(i);

	     return ret;
    }

	 public void guardeUmVoo(Voo voo)throws Exception
	 {
		  if (voo==null)
            throw new Exception ("Falta o que guardar");

          this.listaDeVoos.insiraNoFim(voo);

	 }

	 public void removaUmVoo(Voo voo)throws Exception
	 {
		  if (this.listaDeVoos.isVazia())
		       throw new Exception ("Nada a remover");

		  this.listaDeVoos.remova(voo);
	 }

     public String listaVoos() throws Exception
     {

		  String ret = "";

		  ret = this.listaDeVoos.toString();

		  return ret;
     }

	 //toString
	 public String toString()
	 {
		 String ret = "";

		 try {

			    ret = "Número: " + this.numero;
			    ret+= "Código Aeroporto: " + this.codigo;
		 		ret+= ", Cidade: " + this.nome;
		 		ret+= ", Voos: " + this.listaDeVoos.toString();

		 		return ret;
		 }
		 catch(Exception err)
		 {}

		 return ret;
	 }
	 //equals
	 public boolean equals(Object obj)
	 {
	 	if(this == obj)
	 		return false;

	 	if(obj == null)
	 		return false;

	 	//if(this.getClass() != obj.getClas())
	 	//	return false;

	 	Aeroporto aero = (Aeroporto)obj;

	 	if(!this.codigo.equals(aero.codigo))
	 		return false;
	 	if(!this.nome.equals(aero.nome))
	 		return false;
		if(this.numero!=aero.numero)
			return false;

	 	return true;
	 }
	 //hashCode
	 public int hashCode()
	 {
		 int ret = 666;

		 ret = ret * 7 + this.codigo.hashCode();
		 ret = ret * 7 + this.nome.hashCode();
		 ret = ret * 7 + new Integer (this.numero).hashCode();

		 if(ret < 0)
		    ret = -ret;

         return ret;
	 }
	 //contrutor de cópia
	 public Aeroporto(Aeroporto modelo)throws Exception
	 {
		 if(modelo == null)
		 	throw new Exception("Modelo inválido");


		 this.listaDeVoos = (modelo.listaDeVoos);
		 this.codigo = modelo.codigo;
		 this.nome   = modelo.nome;
		 this.numero = modelo.numero;
	 }
	 //clone
	 public Object clone()
	 {
		 Aeroporto ret = null;

		 try
		 {
			 ret = new Aeroporto(this);
		 }
		 catch(Exception erro)
		 {}//sei que não vai dar erro

		 return ret;
     }
}
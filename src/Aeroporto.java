import java.lang.reflect.Method;

public class Aeroporto implements Cloneable
{
	private String codigo;
	private String nome;
	private ListaSimplesDesordenada<Voo> listaDeVoos;

	public Aeroporto(String codigo, String nome)throws Exception
	{
		 this.setCodigo(codigo);
		 this.setNome  (nome);
		 this.listaDeVoos = new ListaSimplesDesordenada<Voo> ();
	}
	//setters
	 public void setCodigo(String codigo) throws Exception
	 {
		 if(this.codigo == null)
		 throw new Exception("Codigo invalido!");

		 this.codigo = codigo;
	 }
	 public void setNome(String nome) throws Exception
	 {
		 if(nome == null || nome.equals(""))
			throw new Exception("Nome invalido!");

		 this.nome = nome;
     }
	 
	 public void setListaVoos(Voo voo) throws Exception
	 {
		 if (voo == null)
			 throw new Exception("Voo inv�lido!");
		 
		 this.listaDeVoos = new ListaSimplesDesordenada<Voo> ();
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
	 
	 //public Voo getVoo()
	 //{
	 //	 return this.listaDeVoos;
	 //}

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
     
	 public boolean eVazia()
     {
		 return this.listaDeVoos.isVazia();
	 }

     public String listaVoosPorAeroporto(Aeroporto aero) throws Exception
     {  
		  if (aero==null)
	            throw new Exception ("Par�metros inv�lidos!");
    	 
		  if (this == aero) 
		  {
			 return aero.listaDeVoos.toString();
		  }
		  
		  return("Este aeroporto n�o existe!");
     }
     
     public String listaVoos() throws Exception
     {  
		  return this.listaDeVoos.toString();
     }
     
	 //toString
	 public String toString()
	 {
		 String ret = "C�digo Aeroporto: " + this.codigo;
		 		ret+= "\n Cidade: " + this.nome;

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

	 	if(this.codigo.equals(aero.codigo))
	 		return false;
	 	if(!this.nome.equals(aero.nome))
	 		return false;

	 	return true;
	 }
	 //hashCode
	 public int hashCode()
	 {
		 int ret = 666;

		 ret = ret * 7 + this.codigo.hashCode();
		 ret = ret * 7 + this.nome.hashCode();

		 if(ret < 0)
		    ret = -ret;

         return ret;
	 }
	 //contrutor de c�pia
	 public Aeroporto(Aeroporto modelo)throws Exception
	 {
		 if(modelo == null)
		 	throw new Exception("Modelo inv�lido");


		 this.listaDeVoos = (modelo.listaDeVoos);
		 this.codigo = modelo.codigo;
		 this.nome   = modelo.nome;
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
		 {}//sei que n�o vai dar erro

		 return ret;
     }

}
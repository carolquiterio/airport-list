//import ListaEncadeadaDeVoos.ListaEncadeadaDeVoos;
import java.lang.reflect.*;

public class ListaEncadeadaPrincipal implements Cloneable
{
	public class Aeroporto
	{
		 private String codigo;
		 private String nome;
		 private Aeroporto proxAero;

		 public Aeroporto(String codi, String name, String proximo)throws Exception
		 {
			 this.codigo  = codi;
			 this.nome    = name;
			 //this.proxAero= proximo;

		 }
		// public Aeroporto(String cod, String nom)throws Exception
		// {
			//this.setCodigo = cod;
			//this.setNome   = nom;
			//this.proxAero = null;

		// }
		 public void setCodigo(String codi) throws Exception//setters
		 {
			 if(codi == null)
				throw new Exception("Codigo invalido!");
			 this.codigo = codi;
		 }
		 public void setNome(String name) throws Exception
		 {
			 if(name==null || name.equals(""))
				throw new Exception("Nome invalido!");
			 this.nome = name;
		 }
		 public void setProxAero(Aeroporto proximo)
		 {
		 	 this.proxAero = proximo;
		 }

		 public String getCodigo()//getters
		 {
			 return this.codigo;
		 }
		 public String getNome()
		 {
			 return new String(this.nome);
		 }
		 public String getProxAero()
		 {
		 	 return new String(this.nome);
		 }

     }//fim da classe aeroporto

     private Aeroporto primerio, ultimo;

        public ListaEncadeadaPrincipal ()
	    {
	 		 this.primeiro = null;
	 		 this.ultimo   = null;
	    }
		//public boolean estaVazia ()
		//{
		//	 return this.primeiro==null;
		//}

		 public String toString()
		 {


			 //String ret="[";

			       // No atual = this.primeiro;

			       // while (atual!=null)
			       // {
			           // ret = ret + atual.getproxAero();

			           // if (atual!=this.ultimo)
			            //    ret=ret+",";

			           // atual=atual.getproxAero();
			       // }

                 //return ret+"]";
		 }
		 public boolean equals(Object obj)
		 {
			 if(obj==null)
				return false;
			 if(this==obj)
				return true;
			 if(this.getClass ()!= obj.getClass())
				return false;

			 ListaEncadeadaPrincipal ListaPrincipal = (ListaEncadeadaPrincipal)obj;

			 //......................................

			return true;
		 }
		 public int hashCode()
		 {
			int ret = 6;
			// ret = ret * 7 + this.codigo.hashCode();
			// ret = ret * 7 + this.nome.hashCode();
			// ret = ret * 7 + proxAero.hashCode();

			 if(ret < 0)
				ret = -ret;
			 return ret;
		 }
		 public ListaEncadeadaPrincipal(ListaEncadeadaPrincipal modelo) throws Exception
		 {
			 /*if(modelo == null)
				throw new Exception("Modelo invalido");

			 this.primeiro = new Aeroporto(modelo,primeiro.getProxAero());

			 Aeroporto atualDoThis   = this.primeiro;
			 Aeroporto atualDoModelp = modelo.primeiro.getProxAero();

			 while(atualDoModelo!= null)
			 {
				 atualDoThis.setProxAero(new Aeroporto(atualDoModelo.getProxAero));
				 atualDoThis   = atualDoThis  .getProxAero ();
				 atualDoModelo = atualDoModelo.getProxAero ();
			 }

			 this.ultimo = atualDoThis;*/
		 }
		 public Object clone()
		 {
			 ListaEncadeadaPrincipal ret = null;
			 try
			 {
				ret = new ListaEncadeadaPrincipal(this);
			 }
			 catch(Exception erro)
			 {}

			 return ret;
		 }

}



//import ListaEncadeadaDeVoos.ListaEncadeadaDeVoos;

public class Aeroporto implements Cloneable
{
	 private String codigo;
	 private String nome;
	 private int proxVoo;

     public Aeroporto(String codigo, String nome)throws Exception
     {
		 this.setCodigo(codigo);
		 this.setNome(nome);
		 //proxVoos = new ListaEncadeadaDeVoos();

	 }
	 public void setCodigo(String codigo) throws Exception
	 {
		 if(codigo == null)
		 	throw new Exception("Codigo invalido!");
		 this.codigo = codigo;
	 }
	 public void setNome(String nome) throws Exception
	 {
		 if(nome==null || nome.equals(""))
		 	throw new Exception("Nome invalido!");
		 this.nome = nome;
     }

	 public String getCodigo()
	 {
		 return new String(this.codigo);
	 }
	 public String getNome()
	 {
		 return new String(this.nome);
	 }

	 public String toString()
	 {
		 String ret = "Código: " + this.codigo;
		 ret += "\n Nome: " + this.nome;
		// ret += "\n Voos: " + this.proxVoo;

		return ret;
	 }
	 public boolean equals(Object obj)
	 {
		 if(obj==null)
		  	return false;
		 if(this==obj)
		 	return true;
		 if(this.getClass ()!= obj.getClass())
		 	return false;

		 Aeroporto Aero = (Aeroporto)obj;

		 if(this.codigo.equals(Aero))
		 	return false;
		 if(!this.nome.equals(Aero.nome))
		 	return false;

		return true;
	 }
	 public int hashCode()
	 {
		 int ret = 777;
		 ret = ret * 7 + this.codigo.hashCode();
		 ret = ret * 7 + this.nome.hashCode();
		 //ret = ret * 7 + proxVoo.hashCode();

		 if(ret < 0)
		 	ret = -ret;
		 return ret;
	 }
	 public Aeroporto(Aeroporto modelo) throws Exception
	 {
		 if(modelo == null)
		 	throw new Exception("Modelo invalido");

		 this.codigo = modelo.codigo;
		 this.nome   = modelo.nome;
		 this.proxVoo= modelo.proxVoo;
	 }
	 public Object clone()
	 {
		 Aeroporto ret = null;
		 try
		 {
			ret = new Aeroporto(this);
		 }
		 catch(Exception erro)
		 {}

		 return ret;
	 }


}



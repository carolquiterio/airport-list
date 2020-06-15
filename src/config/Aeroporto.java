import java.lang.reflect.Method;

public class Aeroporto implements Cloneable
{
	private String codigo;
	private String nome;
	private ListaEncadeadaPrincipal<Aeroporto> proxAero;

	public Aeroporto(String codigo, String nome)throws Exception
	{
		 this.setCodigo(codigo);
		 this.setNome  (nome);
		 this.proxAero = new ListaEncadeadaPrincipal<Aeroporto> ();
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
     //getters
	 public String getCodigo()
     {
 		 return this.codigo;
   	 }
	 public String getNome()
	 {
		 return this.nome;
	 }

	 public void guardeUmAero(Aeroporto aero)throws Exception
	 {
		  if (aero==null)
            throw new Exception ("Falta o que guardar");

            //.......................................

	 }
	 public void removaUmAero()throws Exception
	 {
		  if (this.proxAero.isVazia())
		       throw new Exception ("Nada a remover");

        //.................................
	 }
     public boolean Évazia()
     {
		 return this.proxAero.isVazia();
	 }

	 //toString
	 public String toString()
	 {
		 String ret = "Código Aeroporto: " + this.codigo;
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
	 //contrutor de cópia
	 public Aeroporto(Aeroporto modelo)throws Exception
	 {
		 if(modelo == null)
		 	throw new Exception("Modelo inválido");


		 this.proxAero = (modelo.proxAero);
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
		 {}//sei que não vai dar erro

		 return ret;
     }

}
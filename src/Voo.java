public class Voo
    {
        private String indiceDaCidadeDeDestino;
        private int numeroDoVoo;

        public Voo (String i, int num)
        {
            this.indiceDaCidadeDeDestino = i;
            this.numeroDoVoo = num;
        }

        public String getIndiceDaCidadeDeDestino ()
        {
            return this.indiceDaCidadeDeDestino;
        }

        public int getNumeroDoVoo()
        {
			return this.numeroDoVoo;
		}

        public void setIndiceDaCidadeDeDestino (String i) throws Exception
        {
			if (i == null || i == "")
				throw new Exception("�ndice da cidade inv�lido!");

            this.indiceDaCidadeDeDestino = i;
        }

        public void setNumeroDoVoo (int num) throws Exception
        {
			if(num < 0)
				throw new Exception("Numero do voo inv�lido!");

			this.numeroDoVoo = num;
		}
        
  	 public String toString() 
   	 {
   		 String ret = "";
   		 
   		 try {
   			    ret = " Numero do voo: " + this.numeroDoVoo;
   		 		ret+= ", Cidade: " + this.indiceDaCidadeDeDestino;

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

	 	Voo voo = (Voo)obj;

		if(!this.indiceDaCidadeDeDestino.equals(voo.indiceDaCidadeDeDestino))
	 		return false;

	 	if(this.numeroDoVoo!=voo.numeroDoVoo)
            return false;
	 
	 	return true;
	 }
        
     //HashCode
     public int hashCode()
   	 {
   		 int ret = 666;

   		 ret = ret * 7 + this.indiceDaCidadeDeDestino.hashCode();
   		 ret = ret * 7 + new Integer(numeroDoVoo).hashCode();

   		 if(ret < 0)
   		    ret = -ret;

            return ret;
   	 } 
      //contrutor de copia
   	 public Voo(Voo modelo)throws Exception
   	 {
   		 if(modelo == null)
   		 	throw new Exception("Modelo inv�lido");

   		 this.indiceDaCidadeDeDestino = modelo.indiceDaCidadeDeDestino;
   		 this.numeroDoVoo   = modelo.numeroDoVoo;
   	 }
   	 //clone
   	 public Object clone()
   	 {
   		Voo ret = null;

   		 try
   		 {
   			 ret = new Voo(this);
   		 }
   		 catch(Exception erro)
   		 {}//sei que n�o vai dar erro

   		 return ret;
        }
    } //fim da classe Voo
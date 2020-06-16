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
				throw new Exception("Índice da cidade inválido!");

            this.indiceDaCidadeDeDestino = i;
        }

        public void setNumeroDoVoo (int num) throws Exception
        {
			if(num < 0)
				throw new Exception("Número do voo inválido!");

			this.numeroDoVoo = num;
		}
        
  	 public String toString() 
   	 {
   		 String ret = "";
   		 
   		 try {
   			    ret = " Número no voo: " + this.numeroDoVoo;
   		 		ret+= ", Cidade: " + this.indiceDaCidadeDeDestino;

   		 		return ret;
   		 }
   		 catch(Exception err)
   		 {}
   		 
   		 return ret;
   	 }
        
        //equals, hashcod, copia, clone,

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
      //contrutor de cópia
   	 public Voo(Voo modelo)throws Exception
   	 {
   		 if(modelo == null)
   		 	throw new Exception("Modelo inválido");

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
   		 {}//sei que não vai dar erro

   		 return ret;
        }
    } //fim da classe Voo
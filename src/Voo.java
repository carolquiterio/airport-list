public class Voo implements Comparable<Voo>, Cloneable
    {
        private int indiceDaCidadeDeDestino;
        private int numeroDoVoo;

        public Voo (int numVoo, int destino)
        {
            this.indiceDaCidadeDeDestino = destino;
            this.numeroDoVoo = numVoo;
        }

        public int getIndiceDaCidadeDeDestino ()
        {
            return this.indiceDaCidadeDeDestino;
        }

        public int getNumeroDoVoo()
        {
			return this.numeroDoVoo;
		}

        public void setIndiceDaCidadeDeDestino (int num) throws Exception
        {

			if (num <= 0)

				throw new Exception("Indice da cidade invalido!");

            this.indiceDaCidadeDeDestino = num;
        }

        public void setNumeroDoVoo (int num) throws Exception
        {
			if(num <= 0)
				throw new Exception("Numero do voo invalido!");

			this.numeroDoVoo = num;
		}

  	 public String toString()
   	 {
   		 String ret = "";

   		 try {
   			    ret = "Numero do voo: " + this.numeroDoVoo;
   		 		ret+= ", Cidade de destino: " + this.indiceDaCidadeDeDestino;

   		 		return ret;
   		 }
   		 catch(Exception err)
   		 {}

   		 return ret;
   	 }


        //equals, hashcod, copia, clone,
  	 //equals
  	public boolean equals(Object obj)
	 {
	 	if(this == obj)
	 		return false;

	 	if(obj == null)
	 		return false;

	 	if(this.getClass() != obj.getClass())
	 		return false;


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

   		 ret = ret * 7 + new Integer(indiceDaCidadeDeDestino).hashCode();
   		 ret = ret * 7 + new Integer(numeroDoVoo).hashCode();

   		 if(ret < 0)
   		    ret = -ret;

            return ret;
   	 }
      //contrutor de copia
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

   		 {}//sei que nao vai dar erro
  

   		 return ret;
     }

     public int compareTo(Voo voo)
     {
		 if (this.numeroDoVoo < voo.numeroDoVoo)
		 	return -666;

		 if (this.numeroDoVoo > voo.numeroDoVoo)
		 	return 666;

		 if (this.indiceDaCidadeDeDestino < voo.indiceDaCidadeDeDestino)
		 	return -666;

		 if (this.indiceDaCidadeDeDestino > voo.indiceDaCidadeDeDestino)
		 	return 666;

	 	 return 0;
	 }

    } //fim da classe Voo
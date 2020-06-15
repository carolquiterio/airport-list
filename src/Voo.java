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
				throw new Exception("N�mero do voo inv�lido!");

			this.numeroDoVoo = num;
		}
        
        //equals, hashcod, copia, clone,
    } //fim da classe Voo
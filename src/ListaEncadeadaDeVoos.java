public class ListaEncadeadaDeVoos
{
	private class Voo
    {
        private String indiceDaCidadeDeDestino;
        private int numeroDoVoo;
        private Voo prox;

        public Voo (String i, int num, Voo p)
        {
            this.indiceDaCidadeDeDestino = i;
            this.numeroDoVoo = num;
            this.prox = p;
        }

        public Voo (String i, int num)
        {
            this.indiceDaCidadeDeDestino = i;
            this.numeroDoVoo = num;
            this.prox = null;
        }

        public String getIndiceDaCidadeDeDestino ()
        {
            return this.indiceDaCidadeDeDestino;
        }

        public int getNumeroDoVoo()
        {
			return this.numeroDoVoo;
		}

        public Voo getProx ()
        {
            return this.prox;
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

        public void setProx (Voo p)
        {
            this.prox = p;
        }
    } //fim da classe Voo

    private Voo primeiro, ultimo;


}
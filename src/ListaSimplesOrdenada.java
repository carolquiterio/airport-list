import java.lang.reflect.*;

public class ListaSimplesOrdenada <X extends Comparable<X>>
// X extends Comparable<X> indica que s� ser�o aceitas, como
// par�metros da classe ListaSimplesOrdenada, classe que herdem
// da interface Comparable<X>, ou seja, apenas Xs compar�veis
// com outros Xs ser�o aceitos; isso garante que posso usar o
// m�todo compareTo com objetos chamantes do tipo X.
{
    protected class No
    {
        private X  info;
        private No prox;

        public No (X i, No p)
        {
            this.info = i;
            this.prox = p;
        }

        public No (X i)
        {
            this.info = i;
            this.prox = null;
        }

        public X getInfo ()
        {
            return this.info;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public void setInfo (X i)
        {
            this.info = i;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
    } //fim da classe No

    protected No primeiro, ultimo;

    public ListaSimplesOrdenada ()
    {
        this.primeiro=this.ultimo=null;
    }

    protected X meuCloneDeX (X x)
    {
      //return (X)x.clone();

        X ret=null;

        try
        {
            Class<?> classe = x.getClass();
            Class<?>[] tiposDosParms = null; // null pq clone nao tem parametros
            Method metodo = classe.getMethod("clone",tiposDosParms);
            Object[] parms = null; // null pq clone nao tem parametros
            ret = (X)metodo.invoke(x,parms);
        }
        catch (Exception erro)
        {} // pq sei que estou chamando clone de um objeto que � Cloneable e, portanto, nao h� risco do m�todo n�o existir ou de ser chamado com parametros errado

        return ret;
    }

    // retirei o m�todo public void insiraNoInicio (X i) throws Exception
    // pois ele n�o faz sentido neste tipo de lista

    // retirei o m�todo public void insiraNoFim (X i) throws Exception
    // pois ele n�o faz sentido neste tipo de lista

    // novo m�todo que insere, mantendo a ordem
    public void insira (X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        X info;
        if (i instanceof Cloneable)
            info = meuCloneDeX (i);
        else
            info = i;

        if (this.primeiro==null)
        {
            this.primeiro = new No (info,null);
            return;
        }

        int comp=info.compareTo(this.primeiro.getInfo());

        if (comp<0)
        {
            this.primeiro = new No (info,this.primeiro);
            return;
        }

        if (comp==0)
            throw new Exception ("Informacao repetida");

        No atual=this.primeiro;

        for(;;)
        {
            if (atual.getProx()==null)
                break;

            comp=i.compareTo(atual.getProx().getInfo());

            if (comp==0)
                throw new Exception ("Informacao repetida");

            if (comp<0)
                break;

            atual=atual.getProx();
        }

        atual.setProx (new No (info,atual.getProx()));
    }

    public void removaDoInicio () throws Exception
    {
        if (this.primeiro==null /*&& this.ultimo==null*/)
            throw new Exception ("Nada a remover");

        if (this.primeiro==this.ultimo) //so 1 elemento
        {
            this.primeiro=null;
            this.ultimo  =null;
            return;
        }

        this.primeiro = this.primeiro.getProx();
    }

    public void removaDoFim () throws Exception
    {
        if (this.primeiro==null/*&&this.ultimo==null*/)
            throw new Exception ("Nada a remover");

        if (this.primeiro==this.ultimo)
        {
            this.primeiro=null;
            this.ultimo  =null;
            return;
        }

        No atual;
        for (atual=this.primeiro;
             atual.getProx()!=this.ultimo;
             atual=atual.getProx())
             /*comando vazio*/;

        atual.setProx(null);
        this .ultimo=atual;
    }

    public void remova (X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        if (this.primeiro==null/*&&this.ultimo==null*/)
            throw new Exception ("Lista vazia");

        if (i.equals(this.primeiro.getInfo()))
        {
            if (this.ultimo==this.primeiro)
                this.ultimo=null;

            this.primeiro=this.primeiro.getProx();

            return;
        }

        No atual=this.primeiro;

        for(;;) // FOR EVER (repete at� Exception ou return)
        {
            if (atual.getProx()==null)
                throw new Exception ("Informacao inexistente");

            if (i.equals(atual.getProx().getInfo()))
            {
                if (this.ultimo==atual.getProx())
                    this.ultimo=atual;

                atual.setProx(atual.getProx().getProx());

                return;
            }

            atual=atual.getProx();
        }
    }

    public boolean tem (X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        No atual=this.primeiro;

        while (atual!=null)
        {
            if (i.equals(atual.getInfo()))
                return true;

            atual = atual.getProx();
        }

        return false;
    }

    public int getQtd ()
    {
        No  atual=this.primeiro;
        int ret  =0;

        while (atual!=null)
        {
            ret++;
            atual = atual.getProx();
        }

        return ret;
    }

    public X getDoInicio () throws Exception
    {
        if (this.primeiro==null/*&&this.fim==null)*/)
            throw new Exception ("Nada a obter");

        X ret = this.primeiro.getInfo();
        if (ret instanceof Cloneable)
            ret = meuCloneDeX (ret);

        return ret;
    }

    public X getDoFim () throws Exception
    {
        if (this.primeiro==null/*&&this.ultimo==null)*/)
            throw new Exception ("Nada a obter");

        X ret = this.ultimo.getInfo();
        if (ret instanceof Cloneable)
            ret = meuCloneDeX (ret);

        return ret;
    }

 	public X getComParam(int num) throws Exception
    {
		if (this.primeiro==null/*&&this.ultimo==null)*/)
            throw new Exception ("A lista est� vazia!");

        X ret = null;

        int comp = 0;

        for (No atual=this.primeiro; atual!=null; atual=atual.getProx())
        {
    		comp = comp + 1;
    		if (comp == num)
    		{
    			ret = atual.getInfo();
			}
		}

		if(ret == null)
			throw new Exception("Esse item n�o existe!");

		if (ret instanceof Cloneable)
            ret = meuCloneDeX (ret);

		return ret;
	}

    public boolean isVazia ()
    {
        return this.primeiro==null/*&&this.ultimo==null*/;
    }

    // retirei o m�todo public void invertaSe ()
    // pois ele n�o faz sentido neste tipo de lista

    // retirei o m�todo public ListaSimplesDesordenada<X> inversao ()
    // pois ele n�o faz sentido neste tipo de lista

    public String toString ()
    {
        String ret="[";

        No atual=this.primeiro;

        while (atual!=null)
        {
            ret=ret+atual.getInfo();

            if (atual!=this.ultimo)
                ret=ret+",";

            atual=atual.getProx();
        }

        return ret+"]";
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass()!=obj.getClass())
            return false;

        ListaSimplesOrdenada<X> lista =
       (ListaSimplesOrdenada<X>)obj;

        No atualThis =this .primeiro;
        No atualLista=lista.primeiro;

        while (atualThis!=null && atualLista!=null)
        {
            if (!atualThis.getInfo().equals(atualLista.getInfo()))
                return false;

            atualThis  = atualThis .getProx();
            atualLista = atualLista.getProx();
        }

        if (atualThis!=null  /* && atualLista==null */)
            return false;

        if (atualLista!=null /* && atualThis ==null */)
            return false;

        // atualThis==null && atualLista==null
        return true;
    }

    public int hashCode ()
    {
        final int PRIMO = 13; // qualquer n�mero primo serve

        int ret=666; // qualquer inteiro positivo serve

        for (No atual=this.primeiro;
             atual!=null;
             atual=atual.getProx())
             ret = 17*ret + atual.getInfo().hashCode();

        if (ret<0) ret = -ret;

        return ret;
    }

    // construtor de copia
    public ListaSimplesOrdenada (ListaSimplesOrdenada<X> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        if (modelo.primeiro==null)
            return; // sai do construtor, pq this.primeiro ja � null

        this.primeiro = new No (modelo.primeiro.getInfo());

        No atualDoThis   = this  .primeiro;
        No atualDoModelo = modelo.primeiro.getProx();

        while (atualDoModelo!=null)
        {
            atualDoThis.setProx (new No (atualDoModelo.getInfo()));
            atualDoThis   = atualDoThis  .getProx ();
            atualDoModelo = atualDoModelo.getProx ();
        }

        this.ultimo = atualDoThis;
    }

    public Object clone ()
    {
        ListaSimplesOrdenada<X> ret=null;

        try
        {
            ret = new ListaSimplesOrdenada (this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA � null e o contrutor de copia da erro quando seu parametro � null

        return ret;
    }
}

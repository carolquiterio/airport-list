import java.lang.reflect.*;

public class ListaEncadeadaPrincipal <Aeroporto>
{
    private class No
    {
        private Aeroporto  info;
        private No prox;

        public No (Aeroporto i, No p)
        {
            this.info = i;
            this.prox = p;
        }

        public No (Aeroporto i)
        {
            this.info = i;
            this.prox = null;
        }

        public Aeroporto getInfo ()
        {
            return this.info;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public void setInfo (Aeroporto i)
        {
            this.info = i;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
    } //fim da classe No

    private No primeiro, ultimo;

    public ListaEncadeadaPrincipal ()
    {
		this.primeiro = null;
		this.ultimo   = null;
	}

    public boolean isVazia ()
    {
        return this.primeiro==null;
    }

    public boolean tem (Aeroporto i) throws Exception
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

    private Aeroporto meuCloneDeAeroporto (Aeroporto aero)
    {
        Aeroporto ret=null;

        try
        {
            Class<?> classe = aero.getClass();
            Class<?>[] tiposDosParms = null;
            Method metodo = classe.getMethod("clone",tiposDosParms);
            Object[] parms = null;
            ret = (Aeroporto)metodo.invoke(aero,parms);
        }
        catch (Exception erro)
        {}
        return ret;
    }

    public void insiraNoInicio (Aeroporto i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        Aeroporto inserir=null;
        if (i instanceof Cloneable)
            inserir = meuCloneDeAeroporto(i);
        else
            inserir = i;

        this.primeiro = new No (inserir,this.primeiro);

        if (this.ultimo==null)
            this.ultimo=this.primeiro;
    }

    public void remova (Aeroporto i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        if (this.primeiro==null)
            throw new Exception ("Lista vazia");

        if (i.equals(this.primeiro.getInfo()))
        {
            if (this.ultimo==this.primeiro)
                this.ultimo=null;

            this.primeiro=this.primeiro.getProx();

            return;
        }

        No atual=this.primeiro;

        for(;;)
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

        ListaEncadeadaPrincipal<Aeroporto> lista =
       (ListaEncadeadaPrincipal<Aeroporto>)obj;

        No atualThis =this .primeiro;
        No atualLista=lista.primeiro;

        while (atualThis!=null && atualLista!=null)
        {
            if (!atualThis.getInfo().equals(atualLista.getInfo()))
                return false;

            atualThis  = atualThis .getProx();
            atualLista = atualLista.getProx();
        }

        if (atualThis!=null)
            return false;

        if (atualLista!=null)
            return false;
        return true;
    }

    public int hashCode ()
    {
        final int PRIMO = 13;

        int ret=666;

        for (No atual=this.primeiro;
             atual!=null;
             atual=atual.getProx())
             ret = 17*ret + atual.getInfo().hashCode();

        if (ret<0) ret = -ret;

        return ret;
    }

    // construtor de copia
    public ListaEncadeadaPrincipal (ListaEncadeadaPrincipal<Aeroporto> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        if (modelo.primeiro==null)
            return; // sai do construtor, pq this.primeiro ja é null

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
        ListaEncadeadaPrincipal<Aeroporto> ret=null;

        try
        {
            ret = new ListaEncadeadaPrincipal (this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA é null e o contrutor de copia da erro quando seu parametro é null

        return ret;
    }
}

public class Programa
{
    public static void main (String[] args)
    {
        try
        {
        	ListaSimplesDesordenada<Aeroporto> lis = new ListaSimplesDesordenada<Aeroporto> ();
         
        	/////////////////////////////////////////CADASTRAR UM NOVO AEROPORTO/////////////////////////////////////////
        	Aeroporto aero;
        	Aeroporto aa;
        	lis.insiraNoInicio(aero = new Aeroporto("bb", "BRASILIA"));  
        	lis.insiraNoInicio(aa = new Aeroporto("2", "222"));
        	lis.insiraNoInicio(new Aeroporto("3", "333"));
        	lis.insiraNoInicio(new Aeroporto("4", "444"));        	
        	
           ///////////////////////CADASTRAR UM VOO COM DETERMINADO NÚMERO ENTRE DOIS AEROPORTOS/////////////////////////
        	Voo v = new Voo ("nome", 1);
        	Voo vUm = new Voo ("nome", 2);
        	Voo vDois = new Voo ("nome", 3);                	
        	
            //////////////////////////////////REMOÇÃO DE UM VOO INDICADO PELO NÚMERO///////////////////////////////////
        	//aero.removaUmVoo(v);
        	
            /////////////////////LISTAGEM NA TELA DE TODOS OS VOOS QUE SAEM DE DETERMINADO AEROPORTO///////////////////
        	if(lis.tem(aero))
        	{
        		System.out.println(lis.getAtual());
            	lis.getAtual().guardeUmVoo(v);
            	lis.getAtual().guardeUmVoo(vUm);
            	lis.getAtual().guardeUmVoo(vDois);
        		System.out.println(lis.getAtual().listaVoosPorAeroporto());
        	}
        	
            ///////////////////////////////LISTAGEM NA TELA DOS VOOS DE TODOS OS AEROPORTOS///////////////////////////
        	for (int i = 0; i < lis.getQtd(); i++)
        	{
        		//System.out.println(lis.getAtual().listaVoosPorAeroporto());
        	}
        	
        	
        	//System.out.println(lis);
        	//if(lis.temInformacao("bb"))
        	//{
        		//System.out.println(lis.getAtual().listaVoosPorAeroporto());
        //	}
        	     	                       
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }
}

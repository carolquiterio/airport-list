public class Programa
{
    public static void main (String[] args)
    {
        try
        {
            
        	ListaSimplesDesordenada<Aeroporto> lis = new ListaSimplesDesordenada<Aeroporto> ();
        	Voo v = new Voo ("nome", 1);
        	
        	Aeroporto aero;
        	lis.insiraNoInicio(aero = new Aeroporto("bb", "BRASILIA"));  //tem q por o .toLowerCase()
        	lis.insiraNoInicio(new Aeroporto("2", "222"));
        	lis.insiraNoInicio(new Aeroporto("3", "333"));
        	lis.insiraNoInicio(new Aeroporto("4", "444"));
        	
        	//aero.guardeUmVoo(v);  
        	
        	
        	
        	//aero.guardeUmVoo(v);  
        	//aero.guardeUmVoo(new Voo ("segundoVoo", 2));
        	
        	if(lis.tem(aero))
        	{
        		lis.getAtual().guardeUmVoo(v);
        	}
        	
        	
        	System.out.println(lis);
        	if(lis.temInformacao("bb"))
        	{
        		//System.out.println(lis.getAtual().listaVoosPorAeroporto());
        	}
        	
        	//System.out.println(lis.getAtual(aero));
        	
        	//System.out.println();
        	
        	while (!lis.isVazia())
			{
				System.out.println (lis.getAtual());
			}
            
            
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }
}

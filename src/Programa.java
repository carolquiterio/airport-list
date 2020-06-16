public class Programa
{
    public static void main (String[] args)
    {
        try
        {
            
        	ListaSimplesDesordenada<Aeroporto> lis = new ListaSimplesDesordenada<Aeroporto> ();
        	Voo v = new Voo ("nome", 1);
        	
        	Aeroporto aero;       	
        	lis.insiraNoInicio(aero = new Aeroporto("BB", "BRASILIA"));
        	aero.guardeUmVoo(v);  
        	aero.guardeUmVoo(new Voo ("segundoVoo", 2));
        	
        	//lis.insiraNoFim(new Aeroporto("oi", "oi"));
            
        	//System.out.println (lis);
            //aero.removaUmVoo(v);
            System.out.println(aero.listaVoosPorAeroporto("bb"));
            
        	/*System.out.println();
        	
        	while (!lis.isVazia())
			{
				System.out.println ();
			}*/
            
            
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }
}

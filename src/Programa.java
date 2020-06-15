public class Programa
{
    public static void main (String[] args)
    {
        try
        {
            
        	ListaSimplesDesordenada<Aeroporto> lis = new ListaSimplesDesordenada<Aeroporto> ();
        	//ListaSimplesDesordenada<Voo> v = new ListaSimplesDesordenada<Voo> ();
        	Voo v = new Voo ("nome", 1);
        	
        	
        	//v.insiraNoInicio(new Voo("Campinas", 5));
        	Aeroporto aero;       	
        	lis.insiraNoInicio(aero = new Aeroporto("BR", "BRASILIA"));
        	aero.guardeUmVoo(v);        	
        	lis.insiraNoFim(new Aeroporto("oi", "oi"));
            System.out.println (lis);
            
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

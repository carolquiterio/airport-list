public class Programa
{
    public static void main (String[] args)
    {
        try
        {
            
        	ListaSimplesDesordenada<Aeroporto> lis = new ListaSimplesDesordenada<Aeroporto> ();
            System.out.println (lis);
            
        	System.out.println();
        	
        	while (!lis.isVazia())
			{
				System.out.println ();
			}
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }
}

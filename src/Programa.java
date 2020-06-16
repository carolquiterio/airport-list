import java.util.Scanner;

public class Programa
{
    public static void main (String[] args)
    {
        try
        {
			Scanner in = new Scanner(System.in);
        	ListaSimplesDesordenada<Aeroporto> lis = new ListaSimplesDesordenada<Aeroporto> ();
        	int entrada = 0;
			do
			{
			System.out.println("Escolha o nuúmero referente a ação que deseja fazer: ");
			System.out.println("1 - cadastrar um novo aeroporto");
			System.out.println("2 - cadastrar um voo");
			System.out.println("3 - remover o voo");
			System.out.println("4 - listar na tela todos os números que saem de determinado aeroporto");
			System.out.println("5 - listar todos os voos");

			entrada = in.nextInt();

        	if (entrada == 1)
        	{
				System.out.println("Digite o código do aeroporto e o nome!");
	        	String cod = in.next();
	        	String nom = in.next();
	        	lis.insiraNoInicio(new Aeroporto(cod, nom));
	        	System.out.println("Aeroporto cadastrado! Pressione 6 para voltar ao menu!");
			}

        	if (entrada == 2)
        	{
				System.out.println("Digite o codigo do aeroporto e o número do voo!");
	        	String cod = in.next();
	        	int num = in.nextInt();
	        	lis.getAtual().guardeUmVoo(new Voo(cod, num));
			}

        	if (entrada == 3)
        	{
				System.out.println("Digite o numero do voo que deseja remover!");
				int num = in.nextInt();
				lis.getAtual().removaUmVoo(lis.getAtual.getVooAtual());  //verificar
			}

        	if(entrada == 4)
        	{
    			System.out.println("Digite o número no aeroporto que deseja consultar!");
        		System.out.println(lis.getAtual().listaVoos());
			}

        	if (entrada == 5)
        	{
        		for (int i = 0; i < lis.getQtd(); i++)
        		{
        			System.out.println(lis.getAtual().listaVoos());

        		}
        	}
		}while (entrada==00);
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }
}

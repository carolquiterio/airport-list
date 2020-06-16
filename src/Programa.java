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
				System.out.println("");
				System.out.println("Escolha o número referente a ação que deseja fazer: ");
				System.out.println("1 - cadastrar um novo aeroporto");
				System.out.println("2 - cadastrar um voo");
				System.out.println("3 - remover o voo");
				System.out.println("4 - listar na tela todos os números que saem de determinado aeroporto");
				System.out.println("5 - listar todos os voos");

				entrada = in.nextInt();
				for(int count=0 ; count<50 ; count++)
				    System.out.println("");

				if (entrada == 1)
				{
					System.out.println("Digite o código do aeroporto e o nome!");
					String cod = in.next();
					String nom = in.next();
					lis.insiraNoInicio(new Aeroporto(cod, nom));
					System.out.println("Aeroporto cadastrado!");
				}

				if (entrada == 2)
				{
					System.out.println("Digite o código do aeroporto e o número do voo!");
					String cod = in.next();
					int num = in.nextInt();
					lis.getDoInicio().guardeUmVoo(new Voo(cod, num));
					System.out.println("Voo cadastrado!");
				}

				if (entrada == 3)
				{
					System.out.println("Digite o número do voo que deseja remover!");
					int num = in.nextInt();
					lis.getAtual().removaUmVoo(lis.getAtual().getVooAtual());  //verificar
					System.out.println("Voo removido!");
				}

				if(entrada == 4)
				{
					System.out.println("Digite o número no aeroporto que deseja consultar!");
					int num = in.nextInt();
					System.out.println(lis.getDoInicio().listaVoos());
				}

				if (entrada == 5)
				{
					for (int i = 0; i < lis.getQtd(); i++)
					{
						System.out.println(lis.getDoInicio().listaVoos());

					}
				}

			}
			while (entrada!=999);
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }
}

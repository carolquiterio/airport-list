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
				System.out.println("4 - listar na tela todos os voos que saem de determinado aeroporto");
				System.out.println("5 - listar todos os voos");

				entrada = in.nextInt();
				for(int count=0 ; count<50 ; count++)
				    System.out.println("");

				if (entrada == 1)
				{
					System.out.println("Digite o numero, o código e o nome do aeroporto!");
					int numero = in.nextInt();
					String cod = in.next();
					String nom = in.next();
					lis.insiraNoInicio(new Aeroporto(cod, nom, numero));
					System.out.println("Aeroporto cadastrado!");
				}

				if (entrada == 2)
				{
					System.out.println("Digite o numero do aeroporto de origem, o número do de destino e o número do voo!");
					int numeroOrigem = in.nextInt();
					int numeroDestino = in.nextInt();
					int numVoo = in.nextInt();
					lis.getComParam(numeroOrigem).guardeUmVoo(new Voo(numeroDestino, numVoo));
					System.out.println("Voo cadastrado!");
				}

				if (entrada == 3)
				{
					System.out.println("Digite o número do aeroporto e o número do voo que deseja remover!");
					int numeroAero = in.nextInt();
					int numeroVoo = in.nextInt();
					lis.getComParam(numeroAero).removaUmVoo(lis.getComParam(numeroAero).getVooComParam(numeroVoo));
					System.out.println("Voo removido!");
				}

				if(entrada == 4)
				{
					System.out.println("Digite o número no aeroporto que deseja consultar!");
					int num = in.nextInt();
					System.out.println(lis.getComParam(num).listaVoos());
				}

				if (entrada == 5)
				{
					int qtd = lis.getQtd();

					for (int i = 0; i < qtd; i++)
					{
						System.out.println(lis.getComParam(i).listaVoos());

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
8
import java.util.Scanner;

public class Programa
{
    public static void main (String[] args)
    {
        try
        {
			Scanner in = new Scanner(System.in);
        	ListaSimplesOrdenada<Aeroporto> lisOrd = new ListaSimplesOrdenada<Aeroporto>();
        	int entrada = 0;
        	int vez = 0;
			do
			{
				System.out.println("");
				System.out.println("Escolha o número referente a ação que deseja fazer: ");
				System.out.println("1 - cadastrar um novo aeroporto");
				System.out.println("2 - cadastrar um voo");
				System.out.println("3 - remover o voo");
				System.out.println("4 - listar na tela todos os voos que saem de determinado aeroporto");
				System.out.println("5 - listar todos os voos");
				System.out.println("");

				entrada = in.nextInt();

				for(int count=0 ; count<50 ; count++)
				    System.out.println("");

				if (entrada == 1)
				{
					vez = vez + 1;

					System.out.println("Digite o código e o nome do aeroporto!");
					String cod = in.next();
					String nom = in.next();
					lisOrd.insira(new Aeroporto(cod, nom, vez));
					System.out.println("Aeroporto cadastrado!");
				}

				if (entrada == 2)
				{
					System.out.println("Digite o numero do aeroporto de origem, o número do de destino e o número do voo!");
					int numeroOrigem = in.nextInt();
					int numeroDestino = in.nextInt();
					int numVoo = in.nextInt();
					lisOrd.getComParam(numeroOrigem).guardeUmVoo(new Voo (numVoo, numeroDestino));
					System.out.println("Voo cadastrado!");
				}

				if (entrada == 3)
				{
					System.out.println("Digite o número do aeroporto e o número do voo que deseja remover!");
					int numeroAero = in.nextInt();
					int numeroVoo = in.nextInt();
					lisOrd.getComParam(numeroAero).removaUmVoo(lisOrd.getComParam(numeroAero).getVooComParam(numeroVoo));
					System.out.println("Voo removido!");
				}

				if(entrada == 4)
				{
					System.out.println("Digite o número do aeroporto que deseja consultar!");
					int num = in.nextInt();
					System.out.println(lisOrd.getComParam(num).listaVoos());
				}

				if (entrada == 5)
				{
					int qtd = lisOrd.getQtd();
					for (int i = 1; i <= qtd; i++)
					{
						System.out.println(lisOrd.getComParam(i).getCodigo() + ":" );
						System.out.println(lisOrd.getComParam(i).listaVoos());
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

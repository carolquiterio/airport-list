import java.util.Scanner;

public class Programa
{
    public static void main (String[] args)
    {
        try
        {
			Scanner in = new Scanner(System.in);
        	//ListaSimplesDesordenada<Aeroporto> lis = new ListaSimplesDesordenada<Aeroporto> ();
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

				entrada = in.nextInt();
				for(int count=0 ; count<50 ; count++)
				    System.out.println("");



				if (entrada == 1)
				{
					vez = vez + 1;

					System.out.println("Digite o numero, o código e o nome do aeroporto!");
					// numero = in.nextInt();
					String cod = in.next();
					String nom = in.next();
					//if(lis.tem(lis.getComParam(numero)));
					//lis.insiraNoInicio(new Aeroporto(cod, nom, vez));
					//if(lisOrd.tem(lisOrd.getComParam(vez)));
					Aeroporto aero;
					lisOrd.insira(aero = new Aeroporto(cod, nom, vez));
					System.out.println("Aeroporto cadastrado!");
				}

				if (entrada == 2)
				{
					System.out.println("Digite o numero do aeroporto de origem, o número do de destino e o número do voo!");
					int numeroOrigem = in.nextInt();
					int numeroDestino = in.nextInt();
					int numVoo = in.nextInt();

			//		if(!lis.tem(lis.getComParam(numeroDestino)))
			//					System.out.println("Insira uma cidade válida!");

			//		lis.getComParam(numeroOrigem).guardeUmVoo(new Voo(numeroDestino, numVoo));

					lisOrd.getComParam(numeroOrigem).guardeUmVoo(new Voo (numeroDestino, numVoo));
					System.out.println("Voo cadastrado!");
				}

				if (entrada == 3)
				{
					System.out.println("Digite o número do aeroporto e o número do voo que deseja remover!");
					int numeroAero = in.nextInt();
					int numeroVoo = in.nextInt();
			//		lis.getComParam(numeroAero).removaUmVoo(lis.getComParam(numeroAero).getVooComParam(numeroVoo));
					lisOrd.getComParam(numeroAero).removaUmVoo(lisOrd.getComParam(numeroAero).getVooComParam(numeroVoo));
					System.out.println("Voo removido!");
				}

				if(entrada == 4)
				{
					System.out.println("Digite o número no aeroporto que deseja consultar!");
					int num = in.nextInt();
					//System.out.println(lis.getComParam(num).listaVoos());
				}

				if (entrada == 5)
				{
			//		int qtd = lis.getQtd();
					int qtd = lisOrd.getQtd();
					for (int i = 1; i <= qtd; i++)
					{
						System.out.println(lisOrd.getComParam(i));
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

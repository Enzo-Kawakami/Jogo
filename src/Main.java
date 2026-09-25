void main(){
    Scanner sc = new Scanner(System.in);

    IO.println("Bem-Vindo ao Mundo de Albion Online");
    IO.println("Digite seu Nome de Aventureiro:");
    String nomeJogador = sc.nextLine();

    IO.println("\n"+"Belo Nome!!");
    IO.println("Agora escolha uma classe: ");
    IO.println("(1)Fogo");
    IO.println("(2)Agua");
    int escolha = sc.nextInt();

    Personagem jogador;
    Personagem inimigo;
    if(escolha == 1){
       jogador = new ClasseFogo (nomeJogador,100,100,Classe.Fogo,1,50,50);
    }else{
       jogador = new ClasseAgua(nomeJogador,100,100,Classe.Fogo,1,50,50);
    }

    IO.println("\nMago das Grama Apareceu!!");
    String inimigonome = "Mago das Gramas";
    inimigo = new ClassePlanta(inimigonome,100,100,Classe.Planta,1,50,50);

    while (jogador.StatusVivo() && inimigo.StatusVivo()) {
        IO.println("\n--- SEU TURNO ---");
        IO.println(jogador);
        IO.println(inimigo);
        IO.println("1 - Atacar");
        IO.println("2 - Curar");
        IO.println("3 - Recuperar Energia");
        IO.println("4 - Fugir");


        int acao = sc.nextInt();

        if (acao == 1) {
            jogador.atacar1(inimigo);
            jogador.gastarEnergia(5);
            if (inimigo.StatusVivo()) {
                IO.println("\n--- TURNO DO INIMIGO ---");
                inimigo.atacar1(jogador);
                inimigo.gastarEnergia(5);
            }
        }else if(acao == 2){
                int valorcura = 15;
                jogador.curar(valorcura);
                IO.println("Vocé se curou: +"+valorcura+"vida");
                jogador.gastarEnergia(15);

            } else if(acao == 3) {
            int valorenergia = 15;
            jogador.recuperarEnergia(valorenergia);
            }else if (acao == 4) {
            IO.println("Não Fugiras da sua Primeira Luta!");

            IO.println("\n--- TURNO DO INIMIGO ---");
            inimigo.atacar1(jogador);
            inimigo.gastarEnergia(5);
        } else {
            IO.println("Ação inválida! Você perdeu o turno.");

            IO.println("\n--- TURNO DO INIMIGO ---");
            inimigo.atacar1(jogador);
            inimigo.gastarEnergia(5);
        }
    }

    if (!inimigo.StatusVivo()){
        IO.println("Voce Venceu!!");
    }else if(!jogador.StatusVivo()){
        IO.println("Voce Perdeu");
    }
}

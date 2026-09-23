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
       jogador = new ClasseFogo (nomeJogador,100,Classe.Fogo,10,100);
    }else{
       jogador = new ClasseAgua(nomeJogador,100,Classe.Agua,10,100);
    }

    IO.println("Mago de Gelo Apareceu!!");
    inimigo = new ClasseGelo("Mago de Gelo",100,Classe.Agua,10,100);


    while (jogador.StatusVivo() && inimigo.StatusVivo()) {
        IO.println("--- SEU TURNO ---");
        IO.println("1 - Atacar");
        IO.println("2 - Fugir");

        int acao = sc.nextInt();

        if (acao == 1) {

            jogador.atacar(inimigo);

            if (inimigo.StatusVivo()) {
                IO.println("\n--- TURNO DO INIMIGO ---");
                inimigo.atacar(jogador);
            }
        } else if (acao == 2) {
            IO.println("Não Fugiras dessa Luta!");
        } else {
            IO.println("Ação inválida! Você perdeu o turno.");
        }
    }


    if (inimigo.getVida() < 0){
        IO.println("Voce Venceu!!");
    }else if(jogador.getVida() < 0){
        IO.println("Voce Perdeu");
    }
}

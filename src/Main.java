void main(){
    Scanner sc = new Scanner(System.in);

    IO.println("Bem-Vindo ao Mundo de Albion Online");
    IO.println("Digite seu Nome de Aventureiro");
    String nomeJogador = sc.nextLine();

    IO.println("\n"+"Belo Nome!!");
    IO.println("Agora escolha uma classe: ");
    int escolha = sc.nextInt();

    Personagem jogador;
    if(escolha == 1){
       jogador = new ClasseFogo (nomeJogador,100,Classe.Fogo,10,100);
    }else{
       jogador = new ClasseAgua(nomeJogador,100,Classe.Agua,10,100);
    }

    IO.println("Mago de Gelo Apareceu!!");
    ClasseGelo classeGelo = new ClasseGelo("Mago de Gelo",100,Classe.Agua,10,100);

    IO.println("\n"+jogador.getNome()+" |Vida: "+jogador.getVida());
    IO.println(classeGelo);
    IO.println("Escolha sua Ação:");
    IO.println("Atacar-(1) | Fugir-(2)");
    int acao = sc.nextInt();

    if(acao == 1){
        jogador.atacar(classeGelo);
        if(classeGelo.StatusVivo()){
            IO.println("");
            classeGelo.atacar(jogador);
        }
    }else {
        IO.println("Não Fugiras dessa Luta");
    }
    if (classeGelo.getVida() < 0){
        IO.println("Voce Venceu!!");
    }else if(jogador.getVida() < 0){
        IO.println("Voce Perdeu");
    }
}

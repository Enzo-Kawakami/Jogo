void main() {
    Scanner sc = new Scanner(System.in);

    IO.println("Bem-Vindo ao Mundo de Albion Online");
    IO.println("Digite seu Nome de Aventureiro:");
    String nomeJogador = sc.nextLine();

    IO.println("\n" + "Belo Nome!!");
    IO.println("Agora escolha uma classe: ");
    IO.println("(1)Fogo /(3)Gelo  /(5)Elétrica");
    IO.println("(2)Agua /(4)Terra /(*)Mana");
    int escolha = sc.nextInt();

    Personagem jogador;
    Personagem inimigo = null;
    int dia = 0;

    if (escolha == 1) {
        jogador = new ClasseFogo(nomeJogador, 100, 100, Classe.Fogo, 1, 50, 50);
    } else if (escolha == 2) {
        jogador = new ClasseAgua(nomeJogador, 100, 100, Classe.Agua, 1, 50, 50);
    } else if (escolha == 3) {
        jogador = new ClasseGelo(nomeJogador, 100, 100, Classe.Gelo, 1, 50, 50);
    } else if (escolha == 4) {
        jogador = new ClasseTerra(nomeJogador, 100, 100, Classe.Terra, 1, 50, 50);
    } else if (escolha == 5) {
        jogador = new ClasseEletrica(nomeJogador, 100, 100, Classe.Eletrico, 1, 50, 50);
    } else {
        jogador = new ClasseMana(nomeJogador, 100, 100, Classe.Mana, 1, 50, 50);
    }
    while (jogador.StatusVivo()) {

        dia += 1;

        IO.println("\nDia: " + dia);
        IO.println("Escolha uma opção:");
        IO.println("(1)Caminhar  | (2)Ver Status");
        IO.println("(3)Descansar | (*)Nada");

        int caminho = sc.nextInt();

        if (caminho == 1) {

            int inimigoRamdom = (int) (Math.random() * 5);

            if (inimigoRamdom == 1) {
                String inimigonome = "Demonio do Fogo Queimado";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseFogo(inimigonome, 100, 100, Classe.Mana, 1, 50, 50);
            } else if (inimigoRamdom == 2) {
                String inimigonome = "Peixe Bolha";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseAgua(inimigonome, 100, 100, Classe.Agua, 1, 50, 50);
            } else if (inimigoRamdom == 3) {
                String inimigonome = "Boneco Gelado";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseGelo(inimigonome, 100, 100, Classe.Gelo, 1, 50, 50);
            } else if (inimigoRamdom == 4) {
                String inimigonome = "Golem de Rocha Rochosa";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseTerra(inimigonome, 100, 100, Classe.Terra, 1, 50, 50);
            } else if (inimigoRamdom == 5) {
                String inimigonome = "Bicho Chocante";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseEletrica(inimigonome, 100, 100, Classe.Eletrico, 1, 50, 50);
            } else {
                String inimigonome = "Gosma Gosmenta";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new Inimigo(inimigonome, 10, 1000, Classe.Mana, 1, 50, 50);
            }

            while (jogador.StatusVivo() && inimigo.StatusVivo()) {
                IO.println("\n--- SEU TURNO ---");
                IO.println(jogador);
                IO.println(inimigo);
                IO.println("1 - Atacar / 3 - Recuperar Energia");
                IO.println("2 - Curar / 4 - Bloquear");


                int acao = sc.nextInt();

                if (acao == 1) {
                    jogador.atacar(inimigo);

                    if (inimigo.StatusVivo()) {
                        IO.println("\n--- TURNO DO INIMIGO ---");
                        int acaoInimigo = (int) (Math.random() * 3);

                        if (acaoInimigo == 1) {
                            inimigo.atacar(jogador);
                        } else if (acaoInimigo == 2) {
                            inimigo.recuperarEnergia(20);
                            IO.println(inimigo.getNome() + " está recuperando energia!");
                        } else if(acaoInimigo == 3){
                            inimigo.curar(15);
                            IO.println(inimigo.getNome() + " está se curando!");
                        }else{
                            inimigo.ativarBloqueio();
                        }
                    } else if (acao == 2) {
                        int valorcura = 15;
                        jogador.curar(valorcura);
                        IO.println("\nVoce curou/ +"+valorcura);
                    } else if (acao == 3) {
                        int valorenergia = 15;
                        jogador.recuperarEnergia(valorenergia);
                        IO.println("\nVoce recuperou/ +"+valorenergia);
                    } else if (acao == 4) {
                        IO.println("\nVoce se Defendeu com Sucesso");
                        jogador.ativarBloqueio();

                    } else {
                        IO.println("Ação inválida! Você perdeu o turno.");

                        IO.println("\n--- TURNO DO INIMIGO ---");
                        int acaoInimigo = (int) (Math.random() * 2);

                        if (acaoInimigo == 1) {
                            inimigo.atacar(jogador);
                        } else if (acaoInimigo == 2) {
                            inimigo.recuperarEnergia(20);
                            IO.println(inimigo.getNome() + " está recuperando energia!");
                        } else {
                            inimigo.curar(15);
                            IO.println(inimigo.getNome() + " está se curando!");
                        }

                        if (!inimigo.StatusVivo()) {
                            IO.println("Voce Venceu!!");
                        } else if (!jogador.StatusVivo()) {
                            IO.println("Voce Perdeu");
                        }
                    }
                } else if (caminho == 2) {
                    IO.println("\n" + jogador);

                } else if (caminho == 3) {
                    IO.println("\nVoce Descansou um Pouco");
                    int valorenergia = 45;
                    jogador.recuperarEnergia(valorenergia);
                    int valorcura = 30;
                    jogador.curar(valorcura);
                } else {
                    IO.println("\nVoce Parou para pensar");
                    IO.println("E se distraiu com um passáro");
                }

            }
        }
    }
}
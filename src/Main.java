void main() {
    Scanner sc = new Scanner(System.in);

    IO.println("Bem-Vindo ao Mundo Genérico de Magia");
    IO.println("Digite seu Nome de Aventureiro:");
    String nomeJogador = sc.nextLine();

    IO.println("\n" + "Belo Nome!!");
    IO.println("Agora escolha uma classe: ");
    IO.println("(1)Fogo /(3)Gelo  /(5)Elétrica");
    IO.println("(2)Agua /(4)Terra /(*)Mana");
    int escolha = sc.nextInt();

    Personagem jogador;
    Personagem inimigo = null;
    int dia = 1;
    int pontos = 100;

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

    IO.println("\nBoa Classe!!");
    IO.println("Agora va para sua aventura!!");

    while (jogador.StatusVivo()) {

        IO.println("\nDia: " + dia);
        IO.println("Escolha uma opção:");
        IO.println("(1)Caminhar  | (2)Ver Status");
        IO.println("(3)Descansar | (4)Guia de Inimigos");

        int caminho = sc.nextInt();

        if (caminho == 1) {

            int inimigoRamdom = (int) (Math.random() * 7);

            if (inimigoRamdom == 1) {
                String inimigonome = "Demonio do Fogo Queimado";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseFogo(inimigonome,100+(int) (Math.random() * 3)*10,150, Classe.Mana, 1, 50, 50);
            }
            else if (inimigoRamdom == 2) {
                String inimigonome = "Peixe Bolha";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseAgua(inimigonome,80+(int) (Math.random() * 4)*5,100, Classe.Agua, 1, 50, 50);
            }
            else if (inimigoRamdom == 3) {
                String inimigonome = "Boneco Gelado";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseGelo(inimigonome,85+(int) (Math.random() * 5)*5,110, Classe.Gelo, 1, 50, 50);
            }
            else if (inimigoRamdom == 4) {
                String inimigonome = "Golem de Rocha Rochosa";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseTerra(inimigonome,100+(int) (Math.random() * 6)*5,130, Classe.Terra, 1, 50, 50);
            }
            else if (inimigoRamdom == 5) {
                String inimigonome = "Bicho Chocante";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseEletrica(inimigonome,80+(int) (Math.random() * 4)*5,100, Classe.Eletrico, 1, 50, 50);
            }
            else if (inimigoRamdom == 6){
                String inimigonome = "Rei do Caos";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseCaos(inimigonome, 100+(int) (Math.random() * 9)*100, 1000, Classe.Caos, 1, 50, 50);
            }
            else if (inimigoRamdom == 7){
                String inimigonome = "Morcego Vampirico";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseVampiro(inimigonome, 50+(int) (Math.random() * 5)*10, 1000, Classe.Vampiro, 1, 50, 50);
            }
            else {
                String inimigonome = "Gosma Gosmenta";
                IO.println(inimigonome + " Apareceu!!");
                inimigo = new ClasseGosma(inimigonome, 10+(int) (Math.random() * 99)*10, 1000, Classe.Gosma, 1, 50, 50);
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
                    pontos += 10;


                    if (inimigo.StatusVivo()) {
                        IO.println("\n--- TURNO DO INIMIGO ---");
                        int acaoInimigo = (int) (Math.random() * 3);

                        if (acaoInimigo == 1) {
                            inimigo.atacar(jogador);
                        } else if (acaoInimigo == 2) {
                            inimigo.recuperarEnergia(20);
                            IO.println(inimigo.getNome() + " está recuperando energia!");
                        } else if (acaoInimigo == 3) {
                            inimigo.curar(15);
                            IO.println(inimigo.getNome() + " está se curando!");
                        } else {
                            inimigo.ativarBloqueio();
                            IO.println(inimigo.getNome()+" se defendeu");
                        }
                    }
                } else if (acao == 2) {
                    int valorcura = 15;
                    jogador.curar(valorcura);
                    IO.println("\nVoce se curou/ +" + valorcura);

                    IO.println("\n--- TURNO DO INIMIGO ---");
                    int acaoInimigo = (int) (Math.random() * 2);

                    if (acaoInimigo == 1) {
                        inimigo.atacar(jogador);
                    }
                    else if (acaoInimigo == 2) {
                        inimigo.recuperarEnergia(20);
                        IO.println(inimigo.getNome() + " está recuperando energia!");
                    }
                    else {
                        inimigo.curar(15);
                        IO.println(inimigo.getNome() + " está se curando!");
                    }

                } else if (acao == 3) {
                    int valorenergia = 15;
                    jogador.recuperarEnergia(valorenergia);
                    IO.println("\nVoce recuperou/ +" + valorenergia + "energia");

                    IO.println("\n--- TURNO DO INIMIGO ---");
                    int acaoInimigo = (int) (Math.random() * 2);

                    if (acaoInimigo == 1) {
                        inimigo.atacar(jogador);
                    }
                    else if (acaoInimigo == 2) {
                        inimigo.recuperarEnergia(20);
                        IO.println(inimigo.getNome() + " está recuperando energia!");
                    }
                    else{
                        inimigo.curar(15);
                        IO.println(inimigo.getNome() + " está se curando!");
                    }
                } else if (acao == 4) {
                    IO.println("\nVoce se Defendeu com Sucesso");
                    jogador.ativarBloqueio();
                    pontos += 10;

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
                }
                if (!inimigo.StatusVivo()) {
                    IO.println("Voce Venceu!!");
                    pontos += 100;
                    dia += 1;
                } else if (!jogador.StatusVivo()) {
                    IO.println("Voce Perdeu");
                }
            }
        } else if (caminho == 2) {
            IO.println("\n" + jogador);
            IO.println("Pontuação: "+pontos);

        } else if (caminho == 3) {
            IO.println("\nVoce Descansou um Pouco");
            int valorenergia = 45;
            jogador.recuperarEnergia(valorenergia);
            int valorcura = 30;
            jogador.curar(valorcura);
            dia += 1;
        } else if(caminho == 4){
            IO.println("\n");
            int inimigoRamdom = (int) (Math.random() * 9);


            if (inimigoRamdom == 1) {
                String inimigonome = "Demonio do Fogo Queimado";
                IO.println(inimigonome+": um Demonio que pode aparecer em vulcões e aguentar temperaturas extremas");
                IO.println("Ele geralmente aparece em florestas queimando tudo e causando discórdia em vilas");
            }
            else if (inimigoRamdom == 2) {
                String inimigonome = "Peixe Bolha";
                IO.println(inimigonome+": um peixe que vive em lagos pacificos");
                IO.println("Peixes que não gostam de serem pertubados");
            }
            else if (inimigoRamdom == 3) {
                String inimigonome = "Boneco Gelado";
                IO.println(inimigonome+": Bonecos de Neve que conseguem lançar rajadas poderosas de gelo");
                IO.println("Ninguém consegue explicar como eles não derretem diante ao Sol");
            }
            else if (inimigoRamdom == 4) {
                String inimigonome = "Golem de Rocha Rochosa";
                IO.println(inimigonome+": Seres de pedras massivas");
                IO.println("Dizem que eles tem força suficiente para levantar um vilarejo inteiro");
            }
            else if (inimigoRamdom == 5) {
                String inimigonome = "Bicho Chocante";
                IO.println(inimigonome+": Rato com o corpo capaz de gerar eletricidade");
                IO.println("Tenho certeza que foi feito para desafiar a própria natureza");
            }
            else if (inimigoRamdom == 8){
                String inimigonome = "?????";
                IO.println(inimigonome+": Criatura sem rastros");
                IO.println("Falam que veio para acabar com o conforto e causar o caos");
            }
            else if(inimigoRamdom == 7){
                String inimigonome = "Morcego Vampirico";
                IO.println(inimigonome+": Falam que caso morda Alguem consiguira se tornar um vampiro");
                IO.println("Ou consegue contrair raiva mesmo");
            }
            else {
                String inimigonome = "Gosma Gosmenta";
                IO.println(inimigonome+": Criatura de corpo frágil");
                IO.println("Sinceramente insignificante");
            }
        } else {
            IO.println("\nVoce Parou para pensar");
            IO.println("E se distraiu com um passáro");
            dia += 1;
            pontos -= 10;
        }
    }
    IO.println("\nGAME OVER");
    IO.println("Dias: "+dia);
    IO.println("Pontuação: "+pontos);
}

public class ClasseFogo extends Personagem {



    public ClasseFogo(String nome, int vida, int vidaMax, Classe classe, int ataque, int energia, int energiaMax) {
        super(nome, vida, vidaMax, classe, ataque, energia, energiaMax);
    }

    @Override
    public void atacar1(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Bola de Fogo em "+alvo.getNome());
        dano *= 10;
        gastarEnergia(5);

        if (alvo.getClasse() == Classe.Planta){
            dano *= 2;
            IO.println("Super Efetivo");
        } else if (alvo.getClasse() == Classe.Agua){
            dano /= 2;
            IO.println("Nada Efetivo");
        }else {
            IO.println("");
        }
        alvo.receberDano(dano);
    }

    @Override
    public void atacar2(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Lança Chamas em "+alvo.getNome());
        dano *= 14;
        gastarEnergia(12);

        if (alvo.getClasse() == Classe.Planta){
            dano *= 2;
            IO.println("Super Efetivo");
        } else if (alvo.getClasse() == Classe.Agua){
            dano /= 2;
            IO.println("Nada Efetivo");
        }else {
            IO.println("");
        }
        alvo.receberDano(dano);
    }

    @Override
    public void atacar3(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Punho Fenix em "+alvo.getNome());
        dano *= 22;
        curar(5);
        gastarEnergia(20);

        if (alvo.getClasse() == Classe.Planta){
            dano *= 2;
            IO.println("Super Efetivo");
        } else if (alvo.getClasse() == Classe.Agua){
            dano /= dano;
            IO.println("Nada Efetivo");
        }else {
            IO.println("");
        }
        alvo.receberDano(dano);
    }

}

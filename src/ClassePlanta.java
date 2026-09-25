public class ClassePlanta extends Personagem{

    public ClassePlanta(String nome, int vida, int vidaMax, Classe classe, int ataque, int energia, int energiaMax) {
        super(nome, vida, vidaMax, Classe.Mana, ataque, energia, energiaMax);
    }

    @Override
    public void atacar1(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Rocha Pedrosa em "+alvo.getNome());
        dano *= 15;

        if (alvo.getClasse() == Classe.Agua){
            dano *= 2;
            IO.println("Super Efetivo");
        }else {
            IO.println("");
        }
        alvo.receberDano(dano);
    }

    @Override
    public void atacar2(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Folha Narvalha"+alvo.getNome());
        dano *= 10;

         if (alvo.getClasse() == Classe.Fogo){
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
        IO.println(getNome() + " Usou Brotos Selvagem em "+alvo.getNome());
        dano *= 5;
        gastarEnergia(20);

        if (alvo.getClasse() == Classe.Agua){
            dano *= 2;
            IO.println("Super Efetivo");
        } else if (alvo.getClasse() == Classe.Fogo){
            dano /= 2;
            IO.println("Nada Efetivo");
        }else {
            IO.println("");
        }
        alvo.receberDano(dano);
    }

}

public class ClasseGosma extends Personagem{
    public ClasseGosma(String nome, int vida, int vidaMax, Classe classe, int ataque, int energia, int energiaMax) {
        super(nome, vida, vidaMax, classe, ataque, energia, energiaMax);
    }


    @Override
    public void atacar(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Soquinho em " + alvo.getNome());
        dano *= 10;
        gastarEnergia(-10);
        alvo.receberDano(dano);


    }
}


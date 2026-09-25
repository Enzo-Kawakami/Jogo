public class Inimigo extends Personagem{

    public Inimigo(String nome, int vida, int vidaMax, Classe classe, int ataque, int energia, int energiaMax) {
        super(nome, vida, vidaMax, classe, ataque, energia, energiaMax);
    }

    public boolean StatusVivo(){
        return this.getVida() > 0;
    }

    @Override
    public void atacar1(Personagem alvo) {
        IO.println(this.getNome() + " atacou " + alvo.getNome() + "!");

        int dano = this.getAtaque();
        alvo.receberDano(dano);
    }

    @Override
    public void atacar2(Personagem alvo) {

    }

    @Override
    public void atacar3(Personagem alvo) {

    }

}

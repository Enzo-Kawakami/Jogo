public class Inimigo extends Personagem{

    public Inimigo(String nome, int vida, Classe classe, int ataque, int energia) {
        super(nome, vida, classe, ataque, energia);
    }

    public boolean StatusVivo(){
        return this.getVida() > 0;
    }
    @Override
    public void atacar(Personagem alvo) {
        IO.println(this.getNome() + " atacou " + alvo.getNome() + "!");

        int dano = this.getAtaque();
        alvo.receberDano(dano);
    }

}

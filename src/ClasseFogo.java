public class ClasseFogo extends Personagem {

    public ClasseFogo(String nome, int vida, Classe classe, int ataque, int energia) {
        super(nome,vida, Classe.Fogo, ataque, energia);
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Brasa em "+alvo.getNome());

        if (alvo.getClasse() == Classe.Gelo){
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
}

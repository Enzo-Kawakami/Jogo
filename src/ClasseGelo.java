public class ClasseGelo extends Personagem {

    public ClasseGelo(String nome, int vida, Classe classe, int ataque, int energia) {
        super(nome,vida, Classe.Gelo, ataque, energia);
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + "Usou Raio Congelante"+alvo.getNome());

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

    @Override
    public String toString() {
        return "ClasseGelo{}";
    }
}


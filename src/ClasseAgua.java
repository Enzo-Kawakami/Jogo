public class ClasseAgua extends Personagem {

    public ClasseAgua(String nome, int vida, int vidaMax, Classe classe, int ataque, int energia, int energiaMax) {
        super(nome, vida, vidaMax, classe, ataque, energia, energiaMax);
    }

    @Override
    public void atacar1(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Jatada de Agua em "+alvo.getNome());
        dano *= 10;

        if (alvo.getClasse() == Classe.Fogo){
            dano *= 2;
            IO.println("Super Efetivo");
        } else if (alvo.getClasse() == Classe.Planta){
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
        IO.println(getNome() + " Usou Raio Congelante em "+alvo.getNome());
        dano *= 7;

        if (alvo.getClasse() == Classe.Planta){
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
    public void atacar3(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Onda Tsunamica em "+alvo.getNome());
        dano *= 20;

        if (alvo.getClasse() == Classe.Fogo){
            dano *= 2;
            IO.println("Super Efetivo");
        } else if (alvo.getClasse() == Classe.Planta){
            dano /= 2;
            IO.println("Nada Efetivo");
        }else {
            IO.println("");
        }
        alvo.receberDano(dano);
    }
}

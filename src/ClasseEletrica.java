public class ClasseEletrica extends Personagem{

    @Override
    public void atacar(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Choque do Trovão em "+alvo.getNome());
        dano *= 10;
        gastarEnergia(5);

        if (alvo.getClasse() == Classe.Agua){
            dano *= 2;
            IO.println("Super Efetivo");
        } else if (alvo.getClasse() == Classe.Terra){
            dano /= 2;
            IO.println("Nada Efetivo");
        }else {
            IO.println("");
        }
        alvo.receberDano(dano);
    }

    public ClasseEletrica(String nome, int vida, int vidaMax, Classe classe, int ataque, int energia, int energiaMax) {
        super(nome, vida, vidaMax, classe, ataque, energia, energiaMax);
    }


}

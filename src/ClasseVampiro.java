public class ClasseVampiro extends Personagem{
    public ClasseVampiro(String nome, int vida, int vidaMax, Classe classe, int ataque, int energia, int energiaMax) {
        super(nome, vida, vidaMax, classe, ataque, energia, energiaMax);
    }


    @Override
    public void atacar(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Mordida em " + alvo.getNome());
        dano *= 15;
        gastarEnergia(10);
        if (getEnergia() <= 0) {
            IO.println("Energia insuficiente!!");
        } else {
            curar(10);
            alvo.receberDano(dano);
        }
    }
}



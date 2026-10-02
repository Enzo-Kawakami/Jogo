public class ClasseCaos extends Personagem{
    public ClasseCaos(String nome, int vida, int vidaMax, Classe classe, int ataque, int energia, int energiaMax) {
        super(nome, vida, vidaMax, classe, ataque, energia, energiaMax);
    }


    @Override
    public void atacar(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Ataque do Caos em " + alvo.getNome());
        dano *= 10+(int) (Math.random() * 9)*10;
        gastarEnergia(10);
        if (getEnergia() <= 0) {
            IO.println("Energia insuficiente!!");
        } else {
            alvo.receberDano(dano);
        }
    }
}


public class ClasseAgua extends Personagem {

    public ClasseAgua(String nome, int vida, int vidaMax, Classe classe, int ataque, int energia, int energiaMax) {
        super(nome, vida, vidaMax, classe, ataque, energia, energiaMax);
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = this.getAtaque();
        IO.println(getNome() + " Usou Agua Perfurante em "+alvo.getNome());
        dano *= 10;
        gastarEnergia(5);
        if (getEnergia() <= 0){
            IO.println("Energia insuficiente!!");
        }else{

            if (alvo.getClasse() == Classe.Fogo){
                dano *= 2;
                IO.println("Super Efetivo");
            } else if (alvo.getClasse() == Classe.Gelo){
                dano /= 2;
                IO.println("Nada Efetivo");
            }else {
                IO.println("");
            }
            alvo.receberDano(dano);
        }


    }}

public abstract class Personagem {

    private String nome;
    private int vida;
    private int vidaMax;
    private Classe classe;
    private int ataque;
    private int energia;
    private int energiaMax;

    public abstract void atacar1(Personagem alvo);
    public abstract void atacar2(Personagem alvo);
    public abstract void atacar3(Personagem alvo);

    public int getEnergia() {
        return energia;
    }

    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getVidaMax() {
        return vidaMax;
    }
    public boolean gastarEnergia(int quantidade) {
        if (this.energia >= quantidade) {
            this.energia -= quantidade;
            return true;
        }
        return false;
    }
    public void recuperarEnergia(int quantidade) {
        this.energia += quantidade;
        if (this.energia > energiaMax) {
            this.energia = energiaMax;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public Classe getClasse() {
        return classe;
    }

    public void receberDano(int dano){
        this.vida -= dano;
        if(this.vida < 0){
            this.vida = 0;
    }
    }

    public void curar(int cura){
        this.vida += cura;
        if(this.vida > vidaMax){
            this.vida = vidaMax;
    }
    }
    public boolean StatusVivo(){
        return this.vida > 0;
    }

    public Personagem(String nome, int vida, int vidaMax, Classe classe, int ataque, int energia, int energiaMax) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMax = vidaMax;
        this.classe = classe;
        this.ataque = ataque;
        this.energia = energia;
        this.energiaMax = energiaMax;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", vida=" + vida +
                ", classe=" + classe +
                ", energia=" + energia +
                '}';
    }
}

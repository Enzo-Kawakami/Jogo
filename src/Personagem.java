public abstract class Personagem {

    private String nome;
    private int vida;
    private int vidaMax;
    private Classe classe;
    private int ataque;
    private int energia;

    public abstract void atacar(Personagem alvo);

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getEnergia() {
        return energia;
    }

    public Classe getClasse() {
        return classe;
    }

    public void receberDano(int dano){
        this.vida += dano;
        if(this.vida > vidaMax) this.vida = 0;
    }

    public void curar(int cura){
        this.vida += cura;
        if(this.vida < vidaMax) this.vida = vidaMax;
    }
    public boolean StatusVivo(){
        return this.vida > 0;
    }

    public Personagem(String nome, int vida, Classe classe, int ataque, int energia) {
        this.nome = nome;
        this.vida = vida;
        this.classe = classe;
        this.ataque = ataque;
        this.energia = energia;
    }
}

package petshop.bd.Classes.Animal;


public class Animal {

    private String nome, especie, cpfDono;
    private float peso, altura;
    private int id;


    public Animal(String nome, String especie, float peso, float altura, String cpfDono) {
        super();
        this.nome = nome;
        this.especie = especie;
        this.peso = peso;
        this.altura = altura;
        this.cpfDono = cpfDono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getCpfDono() {
        return cpfDono;
    }

    public void setCpfDono(String cpfDono) {
        this.cpfDono = cpfDono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Especie: " + getEspecie());
        System.out.println("Peso: " + getPeso());
        System.out.println("Altura: " + getAltura());
        System.out.println("Dono: " + getCpfDono());
    }
}

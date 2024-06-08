package Quartos;

public abstract class Quarto {
    private int id;
    private String nome;
    private int maxPessoas;
    private boolean status;
    private double preco;

    public Quarto(int id, String nome, int maxPessoas, boolean status, double preco) {
        this.id = id;
        this.nome = nome;
        this.maxPessoas = maxPessoas;
        this.status = status;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxPessoas() {
        return maxPessoas;
    }

    public void setMaxPessoas(int maxPessoas) {
        this.maxPessoas = maxPessoas;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}




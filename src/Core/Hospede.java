package Core;

public class Hospede {
    private String nome;
    private int anoDeNascimento;
    private String cpf;

    public Hospede(String nome, int anoDeNascimento, String cpf) {

        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome obrigatório! Escreva seu nome para prosseguir");
        }

        if (Validacao.temNumeros(nome)) {
            throw new IllegalArgumentException("Nome inválido! Use somente letras no nome");
        }

        if (anoDeNascimento < 0 || anoDeNascimento > 2024) {
            throw new IllegalArgumentException("Ano de nascimento deve ser entre 0 e 2024");
        }

        if (cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF obrigatório! Escreva seu cpf para prosseguir");
        }

        if (Validacao.temNumerosOuCaracteresEspeciais(cpf)) {
            throw new IllegalArgumentException("CPF inválido! Use somente numeros no cpf");
        }

        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido! Cpf deve conter 11 digitos");
        }

        this.nome = nome;
        this.anoDeNascimento = anoDeNascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade(int anoAtual) {

        if (anoAtual <= anoDeNascimento) {
            throw new IllegalArgumentException("Ano de nascimento invalido");
        }

        return anoAtual - anoDeNascimento;
    }
}


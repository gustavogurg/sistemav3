package Core;

import Quartos.Quarto;

import java.util.ArrayList;
import java.util.UUID;

    public class Reserva {
    private int id;
    private Hospede hospede;
    private Quarto quarto;
    private int adicionalDePessoas;
    private String modalidade;

    public Reserva(Hospede hospede, Quarto quarto, int adicionalDePessoas, String modalidade) {
        this.id = UUID.randomUUID().hashCode();

        if (hospede.getIdade(2024) < 18) {
            throw new IllegalArgumentException("Acesso Bloqueado! Hospede tem que ter mais de 18 anos");
        }

        this.hospede = hospede;


        if (adicionalDePessoas > quarto.getMaxPessoas()) {
            throw new IllegalArgumentException("Tamanho Limitado! O Quarto " + quarto.getNome() + " suporta apenas " + quarto.getMaxPessoas() + " pessoas");
        }

        if (modalidade.isEmpty()) {
            this.modalidade = "1hr";
        } else {
            this.modalidade = modalidade;
        }

        this.quarto = quarto;
        this.adicionalDePessoas = adicionalDePessoas;

    }

    public int getId() {
        return id;
    }

    public Hospede getHospedes() {
        return hospede;
    }

    public void setHospedes(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public int getAdicionalDePessoas() {
        return adicionalDePessoas;
    }

    public void setAdicionalDePessoas(int adicionalDePessoas) {
        this.adicionalDePessoas = adicionalDePessoas;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getModalidade() {
        return this.modalidade;
    }

    double valorTotalReserva() {
    	double valorBase = quarto.getPreco(); // Preço base do quarto
        double valorAdicional = adicionalDePessoas * 10.0; // R$ 10 por pessoa adicional

        switch (modalidade) {
            case "3hr":
                valorBase *= 1.5; // 50% a mais para 3 horas
                break;
            case "Per noite":
                valorBase *= 2.0; // 100% a mais para pernoite
                break;
            // case "1hr": // Valor base já é para 1 hora
        }

        return valorBase + valorAdicional;
    }
    }

}




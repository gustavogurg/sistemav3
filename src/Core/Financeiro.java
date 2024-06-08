package Core;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Financeiro implements JsonExport {
    // ... (atributos, getters e setters)

    public String gerarRelatorioFinanceiro() {
        StringBuilder relatorio = new StringBuilder();
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(localeBR);

        // Resumo Financeiro
        relatorio.append("## Resumo Financeiro ##\n\n");
        double totalFaturado = reservas.stream()
                .mapToDouble(Reserva::valorTotalReserva) // Use o método correto para calcular o valor total da reserva
                .sum();
        relatorio.append("Total Faturado: ").append(formatadorMoeda.format(totalFaturado)).append("\n");

        Map<String, Double> faturadoPorTipo = new HashMap<>();
        for (Reserva reserva : reservas) {
            String tipoQuarto = reserva.getQuarto().getNome(); // Obtenha o nome do quarto
            faturadoPorTipo.put(tipoQuarto, faturadoPorTipo.getOrDefault(tipoQuarto, 0.0) + reserva.valorTotalReserva());
        }
        relatorio.append("\nFaturamento por Tipo de Quarto:\n");
        for (Map.Entry<String, Double> entry : faturadoPorTipo.entrySet()) {
            relatorio.append("- ").append(entry.getKey()).append(": ").append(formatadorMoeda.format(entry.getValue())).append("\n");
        }

        // ... (Outras métricas relevantes, se desejar)

        // Tabela Detalhada
        // ... (Implemente a tabela detalhada conforme necessário)

        return relatorio.toString();
    }
}
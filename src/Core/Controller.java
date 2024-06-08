package Core;

import Quartos.Quarto;
import Quartos.Safira;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Controller {

    private static final ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private static final ArrayList<Quarto> quartos = new ArrayList<Quarto>();

    public static void removerReserva(int id) {
        int idQuarto = 0;

        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                idQuarto = reserva.getQuarto().getId();
                reservas.remove(reserva);
                break;
            }
        }

        for (Quarto quarto : quartos) {
            if (quarto.getId() == idQuarto) {
                quarto.setStatus(true);
            }
        }


    }

    public static void adicionarReserva(Reserva r) {
        reservas.add(r);
    }

    public static ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public static void adicionarQuarto(Quarto q) {
        quartos.add(q);
    }

    public static ArrayList<Quarto> getQuartosDisponiveis() {
        // Filtrar todos os quartos com status = true
        return new ArrayList<Quarto>(quartos
                .stream()
                .filter(Quarto::isStatus)
                .toList());
    }

    public static boolean jaPossuiHospede(Hospede hospede) {
        for (Reserva reserva : reservas) {
            if (Objects.equals(reserva.getHospedes().getCpf(), hospede.getCpf())) {
                return true;
            }
        }
        return false;
    }

    public static Quarto ocuparQuarto(String nomeQuarto) {
        ArrayList<Quarto> quartosDisponiveis = getQuartosDisponiveis();

        if (quartosDisponiveis.size() <= 0) {
            throw new ArrayStoreException("Todos os quartos estão ocupados!");
        }

        ArrayList<Quarto> quartosDisponiveisPeloNome = new ArrayList<Quarto>(quartosDisponiveis
                .stream()
                .filter(q -> Objects.equals(q.getNome(), nomeQuarto) && q.isStatus())
                .toList());

        if (quartosDisponiveisPeloNome.size() <= 0) {
            throw new ArrayStoreException("Todos os quartos " + nomeQuarto + " estão ocupados!");
        }

       for (Quarto quarto : quartos) {
           for (Quarto q : quartosDisponiveisPeloNome) {
               if (Objects.equals(quarto.getId(), q.getId())) {
                   q.setStatus(false);
                   return q;
               }
           }
       }

       return null;

    }

    public static ArrayList<Quarto> getQuartos() {
        return quartos;
    }

}

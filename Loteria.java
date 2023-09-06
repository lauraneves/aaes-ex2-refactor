package inicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loteria {
    public double calcularPremio(List<Integer> numerosEscolhidos, double valorAposta) {
        if (!validarNumeros(numerosEscolhidos)) {
            return 0.0;
        }

        List<Integer> numerosSorteados = sortearNumeros();

        int acertos = contarAcertos(numerosEscolhidos, numerosSorteados);

        return calcularPremioPorAcertos(acertos, valorAposta);
    }

    private boolean validarNumeros(List<Integer> numeros) {
        if (numeros.size() < 6 || numeros.size() > 15) {
            return false;
        }

        for (Integer numero : numeros) {
            if (numero < 1 || numero > 60) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> sortearNumeros() {
        List<Integer> numerosSorteados = new ArrayList<>();
        Random random = new Random();

        while (numerosSorteados.size() < 6) {
            int numero = random.nextInt(60) + 1;
            if (!numerosSorteados.contains(numero)) {
                numerosSorteados.add(numero);
            }
        }

        return numerosSorteados;
    }

    private int contarAcertos(List<Integer> numerosEscolhidos, List<Integer> numerosSorteados) {
        int acertos = 0;

        for (Integer numero : numerosEscolhidos) {
            if (numerosSorteados.contains(numero)) {
                acertos++;
            }
        }

        return acertos;
    }

    private double calcularPremioPorAcertos(int acertos, double valorAposta) {
        switch (acertos) {
            case 6:
                return valorAposta;
            case 5:
                return valorAposta * 0.2;
            case 4:
                return valorAposta * 0.05;
            default:
                return 0.0;
        }
    }
}

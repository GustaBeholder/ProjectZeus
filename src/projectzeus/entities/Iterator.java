package projectzeus.entities;

import java.util.ArrayList;
import java.util.Random;

public class Iterator {

    private static ArrayList<Card> listaCartas = new ArrayList<>();
    private static Integer index;
    private static ArrayList<Integer> passed = new ArrayList<>();

    public Iterator() {
    }

    public static void adicionaCarta(ArrayList<Card> novasCartas) {
        for (Card carta : novasCartas) {
            listaCartas.add(carta);
        }
    }

    public static void shuffleCards() {
        Random gerador = new Random(System.currentTimeMillis());
        Boolean achou = true;
        passed.add(0);

        while (achou) {
            Integer count = 0;
            Integer number = gerador.nextInt(listaCartas.size());
            for (int j = 0; j < passed.size(); j++) {
                if (number == passed.get(j)) {
                    count++;
                    if (count == 12) {
                        achou = false;
                    }
                }
            }
            if (count == 0) {
                index = number;
                passed.add(number);
                achou = false;

            }
        }        
        
    }

    public static Card getProximaCarta() {
        shuffleCards();
        return listaCartas.get(index);
    }

}

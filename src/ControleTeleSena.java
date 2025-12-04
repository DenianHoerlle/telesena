import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ControleTeleSena {
    private final Pessoa[] participants = new Pessoa[20];
    private final Pessoa[] winners = new Pessoa[20];
    private final boolean slowMode = true;

    private final int highestNumber = 60, numbersPerSet = 25 , price = 10;
    private final Set<Integer> winnerNumbers = new HashSet<>();

    private int soldTelesenas = 0, winnersAmount = 0;
    private double grossing = 0, profit = 0, prizePool = 0;

    ControleTeleSena() {}

    public Set<Integer> generateSetNumbers() {
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int i = 1; i <= 60; i++) sortedList.add(i);

        Set<Integer> gameSet = new HashSet<>();

        for (int j = highestNumber; j > (highestNumber - numbersPerSet); j--) {
            int randomNumber = (int)(Math.random() * j);

            gameSet.add(sortedList.get(randomNumber));

            sortedList.remove(randomNumber);
        }

        return gameSet;
    }

    public void buyTelesena(Pessoa customer, int amountOfTelesenas) {
        if (amountOfTelesenas > 15 || amountOfTelesenas <= 0) throw new Error("Tá de palhaçada");

        Telesena[] boughtTelesenas = new Telesena[amountOfTelesenas];

        for (int i = 0; i < amountOfTelesenas; i++)
            boughtTelesenas[i] = new Telesena(generateSetNumbers(), generateSetNumbers(), price);

        soldTelesenas += amountOfTelesenas;

        double purchaseGrossing = amountOfTelesenas * price;

        grossing += purchaseGrossing;
        profit += purchaseGrossing * 0.2;
        prizePool += purchaseGrossing * 0.8;

        customer.setTelesenas(boughtTelesenas);

        for(int i = 0; i < participants.length; i++) {
            if (participants[i] == null) {
                participants[i] = customer;
                break;
            };
        }
    }

    public void sleep() {
        Scanner scan = new Scanner(System.in);

        try{
            if (slowMode) {
                System.out.println("\n\n ===== APERTE QUALQUER TECLA PRA PROSSEGUIR (slowMode == true) =====\n\n");
                scan.nextLine();
            } else Thread.sleep(1000);
        } catch(Exception e) {}
    }

    public void startRaffle() {
        System.out.println("Lista de participantes: ");

//        for(Pessoa names: participants) if (names != null) System.out.print(names.getName() + ", ");
        for(int i =0; i < participants.length; i++) if (participants[i] != null) System.out.print(participants[i].getName() + ", " + (i > 0 && i % 5 == 0 ? "\n" : ""));

        sleep();

        System.out.println("Iniciando sorteio! ");

        sleep();

        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int i = 1; i <= highestNumber; i++) sortedList.add(i);

        for (int j = highestNumber; j > (highestNumber - numbersPerSet); j--) {
            int randomNumber = (int)(Math.random() * j);

            winnerNumbers.add(sortedList.get(randomNumber));

            sortedList.remove(randomNumber);
        }

        for (Pessoa participant: participants)
           if (participant != null)
               for (Telesena currentTelesena: participant.getTelesenas())
                    if (currentTelesena.checkIfWins(winnerNumbers)) {
                        winners[winnersAmount] = participant;
                        winnersAmount++;
                        break;
                    }

        System.out.print("Sorteados primeiros 25 números!\n[");
        for (int winNum: winnerNumbers) System.out.print(winNum + ", ");
        System.out.print("]\nResultado:\n");

        if (winners[0] != null) System.out.println("Temos um vencedor! ");

        else System.out.println("Não houve vencedores... Seguindo o sorteio! ");

        sleep();

        int j = highestNumber - numbersPerSet;

        while(winners[0] == null) {
            int randomNumber = (int)(Math.random() * j);

            int newNumber = sortedList.get(randomNumber);

            winnerNumbers.add(newNumber);

            sortedList.remove(randomNumber);

            for (Pessoa participant: participants)
                if (participant != null) for (Telesena currentTelesena: participant.getTelesenas()) {
                    if (currentTelesena.checkIfWins(newNumber)) {
                        winners[winnersAmount] = participant;
                        winnersAmount++;
                        break;
                    }
                };

            j--;
        }

        printFinalGameInfo();
    }

    private void printFinalGameInfo() {
        System.out.println("Números sorteados: " + winnerNumbers.size());
        System.out.print("[");
        for (Integer num: winnerNumbers) System.out.print(num + ", ");
        System.out.print("]\n");

        int amountOfWinners = 0;
        for (Pessoa winner: winners) if (winner == null) break; else amountOfWinners++;

        System.out.println("Telesenas vendidas: " + soldTelesenas + "\n");

        System.out.println("Quantidade de ganhadores: " + amountOfWinners + "\n");

        System.out.println("Nomes dos ganhadores: ");
        for (Pessoa winner: winners) if (winner != null) System.out.print(winner.getName() + ", ");
        System.out.print("\n");

        System.out.println("Prêmio para cada participante: R$" + (prizePool / amountOfWinners));

        System.out.println("Valor bruto de venda das telesenas: R$" + grossing);
        System.out.println("Valor líquido de venda das telesenas: R$" + profit);
    }

}

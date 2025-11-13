import java.util.*;

public class Telesena {
    private double price;
    private Set<Integer> firstSet = new HashSet<Integer>();
    private Set<Integer> secondSet = new HashSet<Integer>();

    Telesena() {}

    Telesena(Set<Integer> firstSet, Set<Integer> secondSet, double price) {
        this.firstSet = firstSet;
        this.secondSet = secondSet; // TESTE
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public boolean checkIfWins(Set<Integer> winnerSet) {
        for (int currentValue: winnerSet) {
            firstSet.remove(currentValue);
            secondSet.remove(currentValue);
        }

        return (firstSet.isEmpty() || secondSet.isEmpty());
    }

    public boolean checkIfWins(Integer currentValue) {
        firstSet.remove(currentValue);
        secondSet.remove(currentValue);

        return (firstSet.isEmpty() || secondSet.isEmpty());
    }
}

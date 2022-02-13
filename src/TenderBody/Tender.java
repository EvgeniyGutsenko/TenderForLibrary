package TenderBody;

import java.util.*;
import java.util.stream.Collectors;
import Exception.UnsuitableArgumentsException;

public class Tender {

    private int quantity;
    private Skills skills;

    public Tender(Skills skills, int quantity) {
        this.skills = skills;
        this.quantity = quantity;
    }

    public Tender(){
    }

    public Skills getSkills() {
        return skills;
    }

    public int getQuantity() {
        return quantity;
    }

    public Map<String, Integer> convertTenderToMap(List<Tender> tender) {
        return tender.stream().collect(Collectors.toMap(k -> String.valueOf(k.getSkills()), v -> v.getQuantity()));
    }

    public Map<String, Integer> convertWorkerToMap(List<Worker> workers) {

        ArrayList sb = new ArrayList();
        for (Worker w : workers) {
            sb.add(w.getSkills());
        }

        String[] brigade = sb.toString().replaceAll("\\[|\\]|\\<|\\>", "")
                .replaceAll("\\s+", "").split(",");

        Map<String, Integer> mapWorkers = new TreeMap<>();
        for (String worker : brigade) {
            if (mapWorkers.keySet().contains(worker)) {
                mapWorkers.put(worker, mapWorkers.get(worker) + 1);
            } else {
                mapWorkers.put(worker, 1);
            }
        }
        return mapWorkers;
    }

    public boolean equalsBrigadeWithTender(List<Tender> tender, List<Worker> workers) {
        return convertTenderToMap(tender)
                .entrySet().containsAll(convertWorkerToMap(workers)
                        .entrySet()) && convertWorkerToMap(workers)
                .entrySet().containsAll(convertTenderToMap(tender).entrySet());
    }

    public List<Brigade> choiceBrigade(List<Tender> tender, List<Brigade> brigades) throws UnsuitableArgumentsException {
        Integer minPrice = 0;
        int countOfSuitableBrigades = 0;
        List<Integer> prices = new ArrayList<>();
        for (Brigade b : brigades) {
            if (equalsBrigadeWithTender(tender, b.getWorkers())) {
                prices.add(b.getPrice());
                countOfSuitableBrigades++;
            }
        }
        if (countOfSuitableBrigades == 0) {
            throw new UnsuitableArgumentsException("There isn't a suitable brigade");
        }
        minPrice = Collections.min(prices);
        System.out.println("Winner of tender with price = " + minPrice + ":");
        List<Brigade> winner = new ArrayList<>();
        for (Brigade brigade : brigades) {
            if (brigade.getPrice() == minPrice) {
                winner.add(brigade);
            }
        }
        return winner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity(), getSkills());
    }

    @Override
    public String toString() {
        return "Tender{" +
                "quantity=" + quantity +
                ", skills=" + skills +
                '}';
    }
}

package TenderBody;

import java.util.List;
import java.util.Objects;

public class Brigade extends Worker {

    private List<Worker> workers;
    private int price;

    public Brigade(List<Worker> workers, int price) {
        this.workers = workers;
        this.price = price;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brigade)) return false;
        if (!super.equals(o)) return false;
        Brigade brigade = (Brigade) o;
        return getPrice() == brigade.getPrice() && Objects.equals(getWorkers(), brigade.getWorkers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWorkers(), getPrice());
    }

    public String toString() {
        return ("Brigade{" + workers + ", " + "price: " + price + '}' + "\n")
                .replaceAll("\\[|\\]|\\<|\\>", "");
    }
}

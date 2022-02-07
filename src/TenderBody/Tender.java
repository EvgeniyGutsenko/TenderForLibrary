package TenderBody;

import java.util.Objects;

public class Tender {

    private int quantity;
    private Skills skills;

    public Tender(Skills skills, int quantity) {
        this.skills = skills;
        this.quantity = quantity;
    }

    public Tender() {
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tender)) return false;
        Tender tender = (Tender) o;
        return getQuantity() == tender.getQuantity() && getSkills() == tender.getSkills();
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

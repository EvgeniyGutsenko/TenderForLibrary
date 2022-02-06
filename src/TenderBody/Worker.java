package TenderBody;

import java.util.Objects;
import java.util.Set;

public class Worker {

    private Set<Skills> skills;

    public Worker(Set<Skills> skills) {
        this.skills = skills;
    }

    public Worker() {
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return getSkills().equals(worker.getSkills());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkills());
    }

    @Override
    public String toString() {
        return "Worker{" +
                "skills=" + skills +
                '}';
    }
}


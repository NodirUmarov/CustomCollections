public class Patient implements Comparable<Patient> {

    private String name;
    private Priority urgency;

    public Patient(String name, Priority urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    @Override
    public int compareTo(Patient o) {
        if (this.urgency.getOrder() > o.urgency.getOrder()) {
            return 1;
        }
        if (this.urgency.getOrder() < o.urgency.getOrder()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", urgency=" + urgency +
                '}';
    }
}

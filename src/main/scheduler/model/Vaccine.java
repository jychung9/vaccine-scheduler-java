package scheduler.model;

public class Vaccine {
    private final String vaccineName;

    private final int requiredDoses;

    private int availableDoses;

    private Vaccine(VaccineBuilder builder) {
        this.vaccineName = builder.vaccineName;
        this.availableDoses = builder.availableDoses;
        this.requiredDoses = builder.requiredDoses;
    }

    // Getters
    public String getVaccineName() {
        return vaccineName;
    }

    public int getAvailableDoses() {
        return availableDoses;
    }

    public int getRequiredDoses() {
        return requiredDoses;
    }

    // Increment the available doses
    public void increaseAvailableDoses(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Argument cannot be negative!");
        }
        this.availableDoses += num;
    }

    // Decrement the available doses
    public void decreaseAvailableDoses(int num) {
        if (this.availableDoses - num < 0) {
            throw new IllegalArgumentException("Not enough available doses!");
        }
        this.availableDoses -= num;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "vaccineName='" + vaccineName + '\'' +
                ", requiredDoses=" + requiredDoses +
                ", availableDoses=" + availableDoses +
                '}';
    }

    public static class VaccineBuilder {
        private final String vaccineName;

        private final int requiredDoses;

        private int availableDoses;

        public VaccineBuilder(String vaccineName, int requiredDoses) {
            this.vaccineName = vaccineName;
            this.requiredDoses = requiredDoses;
        }

        public VaccineBuilder availableDoses(int availableDoses) {
            this.availableDoses = availableDoses;

            return this;
        }

        public Vaccine build() {
            return new Vaccine(this);
        }
    }
}

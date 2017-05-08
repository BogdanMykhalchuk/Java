package JavaRush.MultiThreading.NotationCalculiator;

class Number {
    private int numerationSystem;
    private String digit;

    public Number(int numerationSystem, String digit) {
        this.numerationSystem = numerationSystem;
        this.digit = digit;
    }

    public int getNumerationSystem() {
        return numerationSystem;
    }

    public String getDigit() {
        return digit;
    }

    @Override
    public String toString() {
        return "Number{" +
                "numerationSystem=" + numerationSystem +
                ", digit='" + digit + '\'' +
                '}';
    }
}

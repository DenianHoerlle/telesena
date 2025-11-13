public class Pessoa {
    private String name;
    private Telesena[] telesenas;
    private double prize = 0;

    Pessoa(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Telesena[] getTelesenas() {
        return telesenas;
    }

    public void setTelesenas(Telesena[] telesenas) {
        this.telesenas = telesenas;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }
}

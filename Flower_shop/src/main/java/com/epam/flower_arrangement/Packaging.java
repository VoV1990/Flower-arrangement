package main.java.com.epam.flower_arrangement;

public class Packaging {
    private String type;

    public Packaging(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}

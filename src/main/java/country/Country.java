package main.java.country;

public class Country {
    private String name;

    Country(String nameCountry) {
        setNameCountry(name);
    }
    public void setNameCountry(String name) {
        this.name = name;
    }
    public String getNameCountry() {
        return name;
    }
    public int getKeyValue() {
        return this.name.hashCode();
    }
}
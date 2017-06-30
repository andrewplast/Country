package main.java.Country;

public class Country {
    private String nameCountry;

    Country(String nameCountry) {
        setNameCountry(nameCountry);
    }
    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }
    public String getNameCountry() {
        return nameCountry;
    }
    public int getKeyValue() {
        return this.nameCountry.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Country EqualCountry = (Country) obj;
        return nameCountry.equals(((Country) obj).getNameCountry());
    }
}
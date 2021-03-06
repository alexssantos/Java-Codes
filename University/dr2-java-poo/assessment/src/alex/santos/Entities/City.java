package alex.santos.Entities;

import alex.santos.Shared.Mock;

import java.util.ArrayList;
import java.util.List;

public class City implements Comparable<City>{

    private String Name;
    private double AreaSquad;
    private List<City> borderCities;
    private int MAX_BOARDS = 40;

    public City(String name, double areaSquad) {
        Name = name;
        AreaSquad = areaSquad;
        borderCities = new ArrayList<>();
    }


    //GET SETs      ----------------------------------------------------------
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getAreaSquad() {
        return AreaSquad;
    }

    public void setAreaSquad(double areaSquad) {
        AreaSquad = areaSquad;
    }


    // METHODS      ------------------------------------------------------------
    public boolean equals(City other){
        if (compareTo(other) == 0){
            return true;
        }
        return false;
    }

    public void setBorderCity(City borderCity) {
        if (borderCities.size() >= MAX_BOARDS){
            throw new IllegalArgumentException("Limite de fronteira com cidades atingido.");
        }
        borderCities.add(borderCity);
    }

    public boolean inBoarder(City other){
        return borderCities.contains(other);
    }

    public List<City> intersectBorderCities(City other){
        List<City> list = new ArrayList<>();

        for (City city : other.borderCities) {
            if(borderCities.contains(city)) {
                list.add(city);
            }
        }

        return list;
    }

    public static boolean existis(String name){
        if (Mock.cidadesList.isEmpty()){
            return false;
        }
        for (City item: Mock.cidadesList) {
            if (item.Name == name){
                return true;
            }
        }
        return false;
    }

    // OVERRIDES    ------------------------------------------------------------
    @Override
    public int compareTo(City other) {
        String filds = (Name+AreaSquad);
        String otherFilds = (other.Name+other.AreaSquad);
        return filds.compareTo(otherFilds);
    }

    @Override
    public String toString() {
        return getName();
    }
}

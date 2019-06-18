package alex.santos.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class City implements Comparable<City>{

    private String Name;
    private double AreaSquad;
    private List<City> borderCities;

    public City(String name, double areaSquad) {
        Name = name;
        AreaSquad = areaSquad;
        borderCities = new ArrayList<>();
    }

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

    public boolean equals(City other){
        if (compareTo(other) == 0){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(City other) {
        String filds = (Name+AreaSquad);
        String otherFilds = (other.Name+other.AreaSquad);
        return filds.compareTo(otherFilds);
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


    //
}

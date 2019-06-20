package alex.santos.Entities;

import alex.santos.Shared.MockAirportMng;

import java.util.ArrayList;
import java.util.List;


public class Airport implements Comparable<Airport>{

    private String AirportCode;
    private String Name;
    private String City;
    private boolean internalStatus;
    private List<Flight> FlightsList;
    private List<City> DestinyCitiesList;


    // constructor
    public Airport(String airportCode, String name, String city) {
        AirportCode = airportCode;
        Name = name;
        City = city;
        FlightsList = new ArrayList<>();
        DestinyCitiesList = new ArrayList<>();
    }


    // GET SETs     ---------------------------------------------------------
    public String getAirportCode() {
        return AirportCode;
    }

    public void setAirportCode(String airportCode) {
        AirportCode = airportCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public List<Flight> getFlightsList() {
        return FlightsList;
    }

    public void setFlightsList(List<Flight> flightsList) {
        FlightsList = flightsList;
    }


    // METHODS      ---------------------------------------------------------
    public boolean isInternational()
    {
        return internalStatus;
    }

    public void switchInternalStatus()
    {
        this.internalStatus = !(this.internalStatus);
    }

    //TODO: metodo - aeronave in aeronaveList (prefix)
    public boolean hasAircraft(){

        return true;
    }

    //TODO:
    public boolean hasRoute(Airport other){

        return true;
    }

    public static String getAirportName(String code){
        String igual = MockAirportMng.aeroportosList.stream()
                .filter(x -> code.equals(x.getAirportCode()))
                .findFirst()
                .map(x -> x.getName())
                .toString();

        return igual;
    }

    public boolean equals(Airport other){
        if (compareTo(other) == 0){
            return true;
        }
        return false;
    }


    // METHODS OVERRIDES ---------------------------------------------------------
    @Override
    public String toString() {
        return AirportCode + " : " + Name + ", " + City;
    }

    @Override
    public int compareTo(Airport other) {
        return getAirportCode().compareTo(other.getAirportCode());
    }

}

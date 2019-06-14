package alex.santos.Entities;

import java.util.List;

public class Airport {

    private int AirportCode;
    private String Name;
    private String City;
    private boolean internalStatus;

    private List<Flight> FlightsList;

    // constructor
    public Airport(int airportCode, String name, String city) {
        AirportCode = airportCode;
        Name = name;
        City = city;
    }


    // GET SETs
    public int getAirportCode() {
        return AirportCode;
    }

    public void setAirportCode(int airportCode) {
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



    // Metodos
    public boolean isInternational()
    {
        return internalStatus;
    }

    public void switchInternalStatus()
    {
        this.internalStatus = !(this.internalStatus);
    }

    @Override
    public String toString() {
        return AirportCode + " : " + Name + ", " + City;
    }
}

package alex.santos.Entities;

import alex.santos.Entities.Interfaces.IAircraft;

import java.util.Date;

public class Flight {

    private final int flightNumber = this.generateFlightNumber();
    private int totalVacancy;

    //public Date takeOffDate;
    //public Date arriveDate;
    private String arriveTimeStr;
    private String arriveDateStr;
    private String takeOffDateStr;
    private String takeOffTimeStr;

    private int airportOrigin;
    private int airportDestiny;
    private IAircraft aircraft;

    public Flight() {
    }

    public Flight(
            String takeOffDate, String takeOffTime, String arriveDate, String arriveTime,
            int airportOriginCode, int airportDestinyCode, IAircraft aircraft)
    {
        this.takeOffDateStr = takeOffDate;
        this.takeOffTimeStr = takeOffTime;
        this.arriveDateStr = arriveDate;
        this.arriveTimeStr = arriveTime;
        this.airportOrigin = airportOriginCode;
        this.airportDestiny = airportDestinyCode;
        this.aircraft = aircraft;
    }

    // GET SETs   /////////////////////////////////////////////////

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getTotalVacancy() {
        return totalVacancy;
    }

    public void setTotalVacancy(int totalVacancy) {
        this.totalVacancy = totalVacancy;
    }

    public String getArriveTimeStr() {
        return arriveTimeStr;
    }

    public void setArriveTimeStr(String arriveTimeStr) {
        this.arriveTimeStr = arriveTimeStr;
    }

    public String getArriveDateStr() {
        return arriveDateStr;
    }

    public void setArriveDateStr(String arriveDateStr) {
        this.arriveDateStr = arriveDateStr;
    }

    public String getTakeOffDateStr() {
        return takeOffDateStr;
    }

    public void setTakeOffDateStr(String takeOffDateStr) {
        this.takeOffDateStr = takeOffDateStr;
    }

    public String getTakeOffTimeStr() {
        return takeOffTimeStr;
    }

    public void setTakeOffTimeStr(String takeOffTimeStr) {
        this.takeOffTimeStr = takeOffTimeStr;
    }

    public int getAirportOrigin() {
        return airportOrigin;
    }

    public void setAirportOrigin(int airportOrigin) {
        this.airportOrigin = airportOrigin;
    }

    public int getAirportDestiny() {
        return airportDestiny;
    }

    public void setAirportDestiny(int airportDestiny) {
        this.airportDestiny = airportDestiny;
    }

    public IAircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(IAircraft aircraft) {
        this.aircraft = aircraft;
    }


    // METODOS ///////////////////////////////////////
    private int generateFlightNumber(){
        return 1;
    }


}

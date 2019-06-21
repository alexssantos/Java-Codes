package alex.santos.Entities;

import alex.santos.Entities.Interfaces.IAircraft;
import alex.santos.Shared.MockAirportMng;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Flight implements Comparable<Flight> {

    private final String EMPTY_COMPANY ="NO COMPANY";

    private final int flightNumber;
    private String company;
    private int totalVacancy;

    //public Date takeOffDate;
    //public Date arriveDate;
    private String arriveTimeStr;
    private String arriveDateStr;
    private String takeOffDateStr;
    private String takeOffTimeStr;

    private String airportOrigin;
    private String airportDestiny;
    private IAircraft aircraft;


    public Flight(
            String takeOffDate, String takeOffTime, String arriveDate, String arriveTime,
            String airportOriginCode, String airportDestinyCode, IAircraft aircraft, String CompanyName)
    {
        takeOffDateStr = takeOffDate;
        takeOffTimeStr = takeOffTime;
        arriveDateStr = arriveDate;
        arriveTimeStr = arriveTime;
        airportOrigin = airportOriginCode;
        airportDestiny = airportDestinyCode;
        this.aircraft = aircraft;
        flightNumber = generateFlightNumber();
        totalVacancy = 156;     //Airbus A320
        company = !(CompanyName.isEmpty()) ? CompanyName :EMPTY_COMPANY;

    }

    // GET SETs   /////////////////////////////////////////////////

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getAirportOrigin() {
        return airportOrigin;
    }

    public void setAirportOrigin(String airportOrigin) {
        this.airportOrigin = airportOrigin;
    }

    public String getAirportDestiny() {
        return airportDestiny;
    }

    public void setAirportDestiny(String airportDestiny) {
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
        return (aircraft.toString()+takeOffDateStr+takeOffTimeStr+arriveDateStr+arriveTimeStr).hashCode();
    }

    public String getFlightInfosByCode(int FlightCode){
        if ( MockAirportMng.voosList.isEmpty()){
            return null;
        }

        java.util.List<Flight> voo = MockAirportMng.voosList.stream().filter(x -> FlightCode == x.getFlightNumber()).collect(Collectors.toList());
        String infos = !voo.isEmpty() ? voo.get(0).toString() : null;
        return infos;
    }

    public Flight getFlightByCode(int FlightCode){
        if ( MockAirportMng.voosList.isEmpty()){
            return null;
        }

        List<Flight> voo = MockAirportMng.voosList.stream().filter(x -> FlightCode == x.getFlightNumber()).collect(Collectors.toList());
        Flight retorno = !voo.isEmpty() ? voo.get(0) : null;
        return retorno;
    }

    //Overrides ///////////////////////////////////////
    @Override
    public String toString() {
        String retorno = "Voo: "+flightNumber+" - "+company
                        +"\nPartida | Aeroporto: "+airportOrigin+" | Data: "+takeOffDateStr+" - "+takeOffTimeStr
                        +"\nDestino | Aeroporto: "+airportDestiny+" | Data: "+arriveDateStr+" - "+arriveTimeStr
                        +"\nTotal Assentos Disponiveis: "+totalVacancy
                        +"\nAeronave: "+ aircraft.toString()
                        +"\nTipo: "+"";

        return retorno;
    }

    @Override
    public int compareTo(Flight voo) {
        return Integer.toString(flightNumber).compareTo(Integer.toString(voo.flightNumber));
    }
}

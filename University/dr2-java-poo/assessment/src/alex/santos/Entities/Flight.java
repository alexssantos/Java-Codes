package alex.santos.Entities;

import alex.santos.Entities.Interfaces.IAircraft;
import alex.santos.Shared.Mock;
import alex.santos.Shared.Utils;

import java.util.Date;
import java.util.stream.Collectors;

public class Flight implements Comparable<Flight> {

    private final String EMPTY_COMPANY ="NO COMPANY";

    private final int flightNumber;
    private String company;
    private int totalVacancy;

    public Date takeOffDate;
    public Date arriveDate;

    private String airportOrigin;
    private String airportDestiny;
    private IAircraft aircraft;


    public Flight(
            Date takeOffDateTime, Date arriveDateTime,
            String airportOriginCode, String airportDestinyCode, IAircraft aircraft, String CompanyName)
    {
        takeOffDate = takeOffDateTime;
        arriveDate = arriveDateTime;
        airportOrigin = airportOriginCode;
        airportDestiny = airportDestinyCode;
        this.aircraft = aircraft;
        flightNumber = generateFlightNumber();
        totalVacancy = 156;     //based on Airbus A320
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

    public Date getTakeOffDate() {
        return takeOffDate;
    }

    public String getTakeOffDateSrt() {
        return Utils.printDate(takeOffDate);
    }

    public String getTakeOffDaySrt() {
        return Utils.printDate(takeOffDate).split(" ")[0];
    }

    public String getTakeOffTimeSrt() {
        return Utils.printDate(takeOffDate).split(" ")[1];
    }

    public void setTakeOffDate(Date takeOffDate) {
        this.takeOffDate = takeOffDate;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    // OLD DATE
    /*public String getArriveTimeStr() {
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
    }*/

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
        return (aircraft.toString()+getTakeOffDate()+getArriveDate()).hashCode();
    }

    public static Flight getFlightByCode(int FlightCode){
        if ( Mock.voosList.isEmpty()){
            return null;
        }

        for (Flight voo : Mock.voosList)
        {
            if (voo.getFlightNumber() == FlightCode){
                return voo;
            }
        }
        return null;
    }

    /*  STREAM
    public Fly getFlightByCode(int FlightCode){
        if ( Mock.voosList.isEmpty()){
            return null;
        }

        List<Fly> voo = Mock.voosList.stream().filter(x -> FlightCode == x.getFlightNumber()).collect(Collectors.toList());
        Fly retorno = !voo.isEmpty() ? voo.get(0) : null;
        return retorno;
    }
    */

    public static String getFlightInfosByCode(int FlightCode){
        if ( Mock.voosList.isEmpty()){
            return null;
        }

        java.util.List<Flight> voo = Mock.voosList.stream().filter(x -> FlightCode == x.getFlightNumber()).collect(Collectors.toList());
        String infos = !voo.isEmpty() ? voo.get(0).toString() : null;
        return infos;
    }

    //Overrides ///////////////////////////////////////
    @Override
    public String toString() {
        String retorno = "Voo: "+flightNumber+" - "+company
                        +"\nPartida | Aeroporto: "+airportOrigin+" | Data: "+ Utils.printDate(takeOffDate)
                        +"\nDestino | Aeroporto: "+airportDestiny+" | Data: "+ Utils.printDate(arriveDate)
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

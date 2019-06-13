package alex.santos.Entities;

import alex.santos.Entities.Interfaces.IAircraft;

import java.util.Date;

public class Flight {
    public int flightNumber;
    public int totalVacancy;
    public String takeOffDateStr;
    public String takeOffTimeStr;
    public Date takeOffDate;
    public String arriveDateStr;
    public String arriveTimeStr;
    public Date arriveDate;

    Airport airportOrigin;
    Airport airportDestiny;
    IAircraft aircraft;


    public Flight(int flightNumber, int totalVacancy, String takeOffDate, String takeOffTime, String arriveDate, String arriveTime, Airport airportOrigin, Airport airportDestiny, IAircraft aircraft) {
        this.flightNumber = flightNumber;
        this.totalVacancy = totalVacancy;
        this.takeOffDateStr = takeOffDate;
        this.takeOffTimeStr = takeOffTime;
        this.arriveDateStr = arriveDate;
        this.arriveTimeStr = arriveTime;
        this.airportOrigin = airportOrigin;
        this.airportDestiny = airportDestiny;
        this.aircraft = aircraft;
    }


}

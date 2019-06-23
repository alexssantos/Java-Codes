package alex.santos.Entities;

import alex.santos.Shared.Mock;
import alex.santos.Shared.Utils;

import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Airport implements Comparable<Airport>{

    public final int AIRPLANES_MAX = 100;
    private String AirportCode;
    private String Name;
    private String CityName;
    private boolean internationalStatus;
    private List<Flight> FlightsList; //voos ToGO ou ToCome.
    private List<City> DestinyCitiesList;

    private List<String> AirportsDestiny;      //airport Codes
    private List<String> AirportsToReceive;    //airport Codes


    // constructor
    public Airport(String airportCode, String name, String cityName) {
        AirportCode = airportCode;
        Name = name;
        if(!City.existis(cityName)){
            throw new IllegalArgumentException("Cidade não Existe. Não pode criar um aeroporto sem cidade.");
        }
        this.CityName = cityName;

        FlightsList = new ArrayList<>();
        DestinyCitiesList = new ArrayList<>();
        AirportsToReceive = new ArrayList<>();
        AirportsDestiny = new ArrayList<>();
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

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public List<Flight> getFlightsList() {
        return FlightsList;
    }

    public void setFlightsList(List<Flight> flightsList) {
        FlightsList = flightsList;
    }

    public List<String> getAirportsDestiny() {
        return AirportsDestiny;
    }

    //NO: setAirportsToGo(List<String> airportsToGo) {}

    public List<String> getAirportsToReceive() {
        return AirportsToReceive;
    }

    //NO: setAirportsToCome(List<String> airportsToCome) {}



    // METHODS      ---------------------------------------------------------
    public boolean isInternational()
    {
        return internationalStatus;
    }

    public void switchInternationalStatus()
    {
        this.internationalStatus = !(this.internationalStatus);
    }

    public boolean addAirportDestiny(String codeNew){
        Airport destiny = getAirportByCode(codeNew);
        if (destiny == null){
            Utils.msgERRO("Aeroporto de codigo: "+codeNew+", não existe!");
            return false;
        }
        AirportsDestiny.add(codeNew);
        destiny.AirportsToReceive.add(this.AirportCode);
        Utils.msg("Aeorporto - codigo: "+codeNew+" - Agora faz parte da lista de voos partindo de "+ AirportCode);
        return true;
    }

    public boolean addAirportToReceive(String codeNew){
        Airport base = getAirportByCode(codeNew);
        if (base == null){
            Utils.msgERRO("Aeroporto de codigo: "+codeNew+", não existe!");
            return false;
        }
        AirportsToReceive.add(codeNew);
        base.AirportsDestiny.add(this.AirportCode);
        Utils.msg("Aeorporto - codigo: "+codeNew+" - Agora faz parte da lista de voos com destino à "+AirportCode);
        return true;
    }

    public boolean equals(Airport other){
        if (compareTo(other) == 0){
            return true;
        }
        return false;
    }

    public boolean hasAircraft(String prefix)
    {
        //Instant now = new Instant.now();

        // nao partiram
        for (Flight item: FlightsList) {
            if (item.getAirportOrigin() == AirportCode
                && item.getAircraft().getPrefix().equals(prefix)
                //&& x.getTakeOffTimeStr() > now

            ){
                return true;
            }
        }

        //ja chegaram
        for (Flight item: FlightsList) {
            if (item.getAirportDestiny() == AirportCode
                && item.getAircraft().getPrefix().equals(prefix)
                //&& x.getArriveTimeStr() < now
            ){
                return true;
            }
        }

        return false;
    }

    public boolean hasRoute(Airport other){
        if (FlightsList.isEmpty()) return false;

        Date now = new Date();
        for (Flight item: FlightsList) {
            if (item.getAirportDestiny().equals(other.AirportCode)
                && item.getTakeOffDate().compareTo(now) < 0){
                return true;
            }
        }
        return true;
    }

    public static String getAirportNameByCode(String code){
        String name;
        for (Airport item : Mock.aeroportosList) {
            if (code.equals(item.getAirportCode()))
            {
                name = item.toString();
                return name;
            }
        }
        return null;
    }

    public static  boolean addNewFlight(Flight newVoo){
        //presumindo ficar 2h +- em cada aeroporto ate voar noavmente.
        Airport origin = Airport.getAirportByCode(newVoo.getAirportOrigin());
        Airport destiny = Airport.getAirportByCode(newVoo.getAirportDestiny());

        boolean hasPlaces = origin != null && destiny != null;
        if (!hasPlaces) return false;


        Date startOrigin = new Date();
        Date endDestiny = new Date();
        try {
            startOrigin = Utils.dateAddHours(newVoo.getTakeOffDate(), -2);
            endDestiny = Utils.dateAddHours(newVoo.getArriveDate(), 2);
        } catch (ParseException e) {
            e.printStackTrace();
        };

        boolean canOrigin = origin.canAddFlight(startOrigin, newVoo.getTakeOffDate());
        boolean canDestiny = origin.canAddFlight(newVoo.getArriveDate(), endDestiny);

        if (canOrigin && canDestiny){
            origin.FlightsList.add(newVoo);
            destiny.FlightsList.add(newVoo);
            return true;
        }
        return false;
    }

    private boolean canAddFlight(Date start, Date end){
        //verificar quantos avios no patio no hoario se nao ultrapassa o maximo.
        int count = 0;
        for (Flight voo: FlightsList) {
            boolean naoFoi = voo.takeOffDate.compareTo(end) < 0
                                && (!voo.getAirportDestiny().equals(getAirportCode()));
            boolean jachegou = voo.arriveDate.compareTo(start) > 0
                                && (voo.getAirportDestiny().equals(getAirportCode()));

            if (naoFoi || jachegou){
                count++;
            }
        }
        if (count>=AIRPLANES_MAX) return false;

        return true;
    }

    public boolean validateNewFlight(){







        return true;
    }

    public static Airport getAirportByCode(String code){
        if (Mock.aeroportosList.isEmpty()){
            Utils.msgERRO("Lista de Aeroportos está vazia.");
            return null;
        }
        for (Airport item: Mock.aeroportosList) {
            if ( item.getAirportCode().equals(code)){
                Utils.msg("Aeroporto encontrado:\n - "+item.toString());
                return item;
            }
        }
        String msg = String.format("NÃO encontrado Aeroporto: "+code);
        Utils.msgERRO(msg);
        return null;
    }



    // METHODS OVERRIDES ---------------------------------------------------------
    @Override
    public String toString() {
        return AirportCode + " : " + Name + ", " + CityName;
    }

    @Override
    public int compareTo(Airport other) {
        return getAirportCode().compareTo(other.getAirportCode());
    }

}

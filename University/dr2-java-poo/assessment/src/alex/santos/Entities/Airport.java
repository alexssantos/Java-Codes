package alex.santos.Entities;

import alex.santos.Entities.Interfaces.IAircraft;
import alex.santos.Entities.Machines.Airplane;
import alex.santos.Shared.Mock;
import alex.santos.Shared.Utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


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
    private List<Airplane> AirplanesStay;       //avioes no chão.


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
        AirplanesStay = new ArrayList<>();
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

    public List<City> getDestinyCitiesList() {
        return DestinyCitiesList;
    }

    // NO: public void setDestinyCitiesList(List<City> destinyCitiesList)

    public void addDestinyCity(City other){
        if (!DestinyCitiesList.contains(other)){
            DestinyCitiesList.add(other);
        }
    }

    private void setAirplanesStay(List<Airplane> airplanesStay) {
        AirplanesStay = airplanesStay;
    }

    // METHODS      ---------------------------------------------------------

    public boolean isInternational()
    {
        return internationalStatus;
    }

    public void switchInternationalStatus()
    {
        this.internationalStatus = !(this.internationalStatus);
    }

    public boolean addAirportDestinyList(String codeNew){
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

    public boolean addAirportToReceiveList(String codeNew){
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


    public int aircraftsAmount(Date start, Date end){
        //verificar quantos avios no patio no hoario se nao ultrapassa o maximo.
        int count = 0;
        for (Flight voo: FlightsList) {
            boolean naoFoi = voo.takeOffDate.compareTo(end) <= 0
                    && (!voo.getAirportDestiny().equals(getAirportCode()));
            boolean jachegou = voo.arriveDate.compareTo(start) >= 0
                    && (voo.getAirportDestiny().equals(getAirportCode()));

            if (naoFoi || jachegou){
                count++;
            }
        }
        return count;
    }

    private boolean canAddFlight(Date start, Date end){
        //verificar quantos avios no patio no hoario se nao ultrapassa o maximo.

        int count = aircraftsAmount(start,end);
        if (count>=AIRPLANES_MAX) return false;

        return true;
    }

    public boolean addFlight(Flight voo){
        boolean isRepeaded = Utils.checkRepeated(this.FlightsList, voo);

        if (isRepeaded) return false;

        this.FlightsList.add(voo);
        IAircraft aviao = voo.getAircraft();

        Airplane novo = (Airplane) aviao;
        this.AirplanesStay.add(novo);

        return true;
    }

    public boolean removeFlight(int codeVoo){
        //return voosList.removeIf(x -> x.getFlightNumber() == codeVoo);        LAMBDA
        if (getFlightByCode(codeVoo) == null){
            return false;
        }

        for (int i=0; i< this.FlightsList.size(); i++){
            Flight voo = this.FlightsList.get(i);
            if (voo.getFlightNumber() == codeVoo){
                Airplane aviao = (Airplane) voo.getAircraft();
                this.AirplanesStay.removeIf(x -> x.equals(aviao));
                this.FlightsList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateFlight(Flight vooNew, int codeVoo){
        if (getFlightByCode(codeVoo) == null){
            return false;
        }

        for (int i=0; i< this.FlightsList.size(); i++){
            if (this.FlightsList.get(i).getFlightNumber() == codeVoo){
                this.FlightsList.set(i,vooNew);
                return true;
            }
        }
        return false;
    }

    public Flight getFlightByCode(int FlightCode){
        if (FlightsList.isEmpty()){
            return null;
        }

        for (Flight voo : FlightsList)
        {
            if (voo.getFlightNumber() == FlightCode){
                return voo;
            }
        }
        return null;
    }

    public int getAmountFlightsByCities(City origin, City destiny){
        int ix =0;
        for (Flight voo: FlightsList) {
            String cityOrigin = Objects.requireNonNull(Airport.getAirportByCode(voo.getAirportOrigin())).CityName;
            String cityDestiny = Objects.requireNonNull(Airport.getAirportByCode(voo.getAirportDestiny())).CityName;

            if (origin.getName().equals(cityOrigin)
                && destiny.getName().equals(cityDestiny)){
                ix++;
            }
        }
        return ix;
    }

    public List<Airplane> getAirplanesStay() {
        return AirplanesStay;
    }

    // STATIC METHODS   -------------------------------------------------

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

    public static  boolean addNewFlight(Flight newVoo){
        //presumindo ficar 2h +- em cada aeroporto ate voar novamente.
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
        boolean canDestiny = destiny.canAddFlight(newVoo.getArriveDate(), endDestiny);

        if (canOrigin && canDestiny){
            origin.FlightsList.add(newVoo);
            destiny.FlightsList.add(newVoo);
            return true;
        }
        return false;
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

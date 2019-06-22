package alex.santos.Entities;

import alex.santos.Shared.MockAirportMng;
import alex.santos.Shared.Utils;


import java.util.ArrayList;
import java.util.List;


public class Airport implements Comparable<Airport>{

    private String AirportCode;
    private String Name;
    private String CityName;
    private boolean internalStatus;
    private List<Flight> FlightsList; //voos ToGO ou ToCome.
    private List<City> DestinyCitiesList;

    private List<String> AirportsToGo;      //airport Codes
    private List<String> AirportsToCome;    //airport Codes


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
        AirportsToCome = new ArrayList<>();
        AirportsToGo = new ArrayList<>();
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

    public List<String> getAirportsToGo() {
        return AirportsToGo;
    }

    //NO: setAirportsToGo(List<String> airportsToGo) {}

    public List<String> getAirportsToCome() {
        return AirportsToCome;
    }

    //NO: -setAirportsToCome(List<String> airportsToCome) {}



    // METHODS      ---------------------------------------------------------
    public boolean isInternational()
    {
        return internalStatus;
    }

    public void switchInternalStatus()
    {
        this.internalStatus = !(this.internalStatus);
    }

    public boolean addAirportToGo(String codeNew){
        if (getAirportByCode(codeNew) == null){
            Utils.msgERRO("Aeroporto de codigo: "+codeNew+", não existe!");
            return false;
        }
        AirportsToGo.add(codeNew);
        Utils.msg("Aeorporto - codigo: "+codeNew+" - Agora faz parte da lista de avioes para ir.");
        return true;
    }

    public boolean addAirportToCome(String codeNew){
        if (getAirportByCode(codeNew) == null){
            Utils.msgERRO("Aeroporto de codigo: "+codeNew+", não existe!");
            return false;
        }
        AirportsToCome.add(codeNew);
        Utils.msg("Aeorporto - codigo: "+codeNew+" - Agora faz parte da lista de avioes para receber.");
        return true;
    }

    //TODO: metodo - aeronave in aeronaveList (prefix)
    public boolean hasAircraft(){
        return true;
    }

    //TODO:
    public boolean hasRoute(Airport other){

        return true;
    }

    public boolean addNewFlight(){

        //1. Verificar aeroportoDestiny com AeroportosToGo do aeroporto
        //2. Verificar aeroportoArrive com AeroportosToCome do aeroporto




        return true;
    }

    public boolean validateNewFlight(){







        return true;
    }

    public static Airport getAirportByCode(String code){
        if (MockAirportMng.aeroportosList.isEmpty()){
            Utils.msgERRO("Lista de Aeroportos vazia.");
            return null;
        }
        for (Airport item: MockAirportMng.aeroportosList) {
            if ( item.getAirportCode().equals(code)){
                Utils.msg("Aeroporto criado:\n"+item.toString());
                return item;
            }
        }
        String msg = String.format("NÃO encontrado Aeroporto: "+code);
        Utils.msgERRO(msg);
        return null;
    }

    public static String getAirportNameByCode(String code){
        String name;
        for (Airport item : MockAirportMng.aeroportosList) {
            if (code.equals(item.getAirportCode()))
            {
                name = item.toString();
                return name;
            }
        }
        return null;
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
        return AirportCode + " : " + Name + ", " + CityName;
    }

    @Override
    public int compareTo(Airport other) {
        return getAirportCode().compareTo(other.getAirportCode());
    }

}

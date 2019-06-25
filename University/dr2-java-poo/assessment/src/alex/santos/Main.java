package alex.santos;

import alex.santos.Entities.Airport;
import alex.santos.Entities.Flight;
import alex.santos.Entities.Machines.Airplane;
import alex.santos.Shared.Mock;
import alex.santos.Shared.Utils;

import java.text.ParseException;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Mock dados = new Mock();


        String galeaoCode = "GIG";
        Airport galeao = Airport.getAirportByCode(galeaoCode);   //Pegando Aeroporto
        Airplane aviao = Mock.avioesList.get(0);

        //Voo   -----------------
        Date partida = new Date();
        Date chegada = new Date();
        try{
            partida = Utils.createDate("25/10/19", "04:00");
            chegada = Utils.createDate("25/10/19", "06:00");
        }catch (ParseException e){e.printStackTrace(); }

        Flight voo = new Flight(partida,chegada,"GIG","CWB",aviao,"Azul");
        // ADD
        System.out.println("\n//ADD");
        galeao.addFlight(voo);
        System.out.println(galeao.getFlightsList());

        //UPDATE
        System.out.println("\n//UPDATE");
        int code = voo.getFlightNumber();
        voo.setAirportDestiny("GRU");   //mudando destino
        galeao.updateFlight(voo, code);
        System.out.println(galeao.getFlightsList());

        // DELETE
        System.out.println("\n//DELETE");
        galeao.removeFlight(voo.getFlightNumber());
        System.out.println(galeao.getFlightsList());

        Flight voo2 = Mock.voosList.get(0);
        String infos = Flight.getFlightInfosByCode(voo2.getFlightNumber());
        System.out.println("\n//FLIGHT - INFOS BY CODE");
        System.out.println(infos);








        Utils.msg("---getAirportNameByCode---");
        String name = Airport.getAirportNameByCode("GIG");
        Utils.msg(name);



        //Adicionar aeroportos entre si.
        Airport GIG = Airport.getAirportByCode("GIG");
        GIG.addAirportDestinyList("CWB");
        Utils.msg(GIG.getAirportsDestiny().toString());

        Airport CWB = Airport.getAirportByCode("CWB");
        Utils.msg(CWB.getAirportsToReceive().toString());

        Utils.msg("------------\nTudo OK!\n------------");
    }
}

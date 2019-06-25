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

        System.out.println("\n// Voo   -----------------");
        Date partida = new Date();
        Date chegada = new Date();
        try{
            partida = Utils.createDate("25/10/19", "04:00");
            chegada = Utils.createDate("25/10/19", "06:00");
        }catch (ParseException e){e.printStackTrace(); }

        Flight voo = new Flight(partida,chegada,"GIG","CWB",aviao,"Azul");
        // ADD
        System.out.println("\n// add");
        galeao.addFlight(voo);
        System.out.println(galeao.getFlightsList());

        //ADD valida e add em ambos
        Airport.addNewFlight(voo);


        //UPDATE
        System.out.println("\n// update");
        int code = voo.getFlightNumber();
        voo.setAirportDestiny("GRU");   //mudando destino
        galeao.updateFlight(voo, code);
        System.out.println(galeao.getFlightsList());

        // DELETE
        System.out.println("\n// delete");
        galeao.removeFlight(voo.getFlightNumber());
        System.out.println(galeao.getFlightsList());

        Flight voo2 = Mock.voosList.get(0);
        String infos = Flight.getFlightInfosByCode(voo2.getFlightNumber());
        System.out.println("\n// voo - INFOS BY CODE");
        System.out.println(infos);


        //Lista de aeronaveis no patio
        try {
            int qtt = galeao.aircraftsAmount(
                    Utils.createDate("25/10/19","02:00"),
                    Utils.createDate("25/10/19","04:00")
            );
            Utils.msg("// quantidade de avioes no patio: "+ qtt );

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("\n// aeroporto -> Internacional");
        galeao.switchInternationalStatus();
        System.out.println(" galeão -> " + galeao.isInternational());

        System.out.println("\n// aeroporto Igual  - equals()");
        Airport galeao2 = Airport.getAirportByCode("GIG");
        System.out.println("equals() : " +galeao.equals(galeao2));

        Utils.msg("\n // getAirportNameByCode ---------");
        String name = Airport.getAirportNameByCode("GIG");
        Utils.msg(name);


        // aviao no aeroporto pelo prefixo.
        System.out.println("\n// aeroporto se tem aeronave  - hasAircraft()");
        boolean res = galeao.hasAircraft("AAA-BR");
        System.out.println("tem aetonave: "+res);

        // rotas entre aeroportos
        System.out.println("\n// rotas entre aeromportos  - hasRoute()");
        Airport cwb = Airport.getAirportByCode("CWB");
        res = galeao.hasRoute(cwb);
        System.out.println("tem rotas: "+res);








        
        //Adicionar aeroportos entre si.
        Airport GIG = Airport.getAirportByCode("GIG");
        GIG.addAirportDestinyList("CWB");
        Utils.msg(GIG.getAirportsDestiny().toString());

        Airport CWB = Airport.getAirportByCode("CWB");
        Utils.msg(CWB.getAirportsToReceive().toString());

        Utils.msg("------------\nTudo OK!\n------------");
    }
}

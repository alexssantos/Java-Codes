package alex.santos;

import alex.santos.Entities.Airport;
import alex.santos.Shared.Mock;
import alex.santos.Shared.Utils;

public class Main {

    public static void main(String[] args) {
        Mock dados = new Mock();

        //Pegando Aeroporto
        String galeaoCode = "GIG";
        Airport galeao = Airport.getAirportByCode(galeaoCode);


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

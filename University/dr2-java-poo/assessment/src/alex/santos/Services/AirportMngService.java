package alex.santos.Services;

import alex.santos.Entities.Airport;
import alex.santos.Shared.MockAirportMng;
import alex.santos.Shared.Utils;

import java.lang.invoke.SerializedLambda;
import java.util.stream.Stream;

public class AirportMngService {


    private Airport x;

    public AirportMngService() {
        startEntities();
    }

    private void startEntities(){
        MockAirportMng dados = new MockAirportMng();

        String galeaoCode = "GIG";
        Airport galeao = MockAirportMng.aeroportosList.stream()
                .filter(x -> x.getAirportCode().equals(galeaoCode))
                .map(x -> (Airport)x);

        if (galeao == null){
            Utils.msgERRO("Aeroporto Galeão NÂO criado.");
        }
        else {
            Utils.msg("Aeroporto Galeão já Criado.");
        }

    }
}

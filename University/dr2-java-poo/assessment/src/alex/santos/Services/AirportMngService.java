package alex.santos.Services;

import alex.santos.Entities.Airport;
import alex.santos.Shared.MockAirportMng;
import alex.santos.Shared.Utils;


public class AirportMngService {

    private MockAirportMng dados;

    public AirportMngService() {
        startEntities();
    }

    private void startEntities(){
        dados = new MockAirportMng();

        String galeaoCode = "GIG";
        Airport galeao = null;
        for (Airport i: MockAirportMng.aeroportosList) {
            if ( i.getAirportCode().equals(galeaoCode)){
                galeao = i;
                break;
            }
        }

        if (galeao == null){
            Utils.msgERRO("Aeroporto Galeão NÂO criado.");
        }
        else {
            Utils.msg("Aeroporto Galeão Criado."+galeaoCode.toString());
            galeao.setFlightsList(MockAirportMng.voosList);
        }
    }
}

package alex.santos;

import alex.santos.Entities.Flight;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Flight voo = new Flight();
        int flightNumber = voo.getFlightNumber();

        System.out.println(flightNumber);
    }
}

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Aircraft {
    private String tailNumber;
    private List<FlightLeg> flightLegs;

    public Aircraft(String tailNumber)
    {
        this.tailNumber = tailNumber;
        flightLegs = new ArrayList<FlightLeg>();
    }

    public List<FlightLeg> getFlightLegs()
    {
        return flightLegs;
    }

    public void addFlightLeg(FlightLeg flightLeg)
    {
        flightLegs.add(flightLeg);
    }

    public List<FlightLeg> filterLegsByAirport(String airportCode)
    {
        List<FlightLeg> filteredLegs = new ArrayList<FlightLeg>();
        for(FlightLeg leg : flightLegs)
        {
            if(leg.getFromAirport().equals(airportCode) || leg.getToAirport().equals(airportCode))
            {
                filteredLegs.add(leg);
            }
        }
        return filteredLegs;
    }

    public String getTailNumber()
    {
        return this.tailNumber;
    }
}

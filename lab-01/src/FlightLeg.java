import java.time.LocalDate;
public class FlightLeg {
    private String fromAirport;
    private String toAirport;
    private LocalDate date;

    FlightLeg(String fromAirport, String toAirport, LocalDate date)
    {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.date = date;
    }

    public String getFromAirport()
    {
        return this.fromAirport;
    }

    public String getToAirport()
    {
        return this.toAirport;
    }

    public LocalDate getDate()
    {
        return this.date;
    }

    public String toString()
    {
        return "From: " + this.fromAirport + " To: " + toAirport + " Date: " + this.date;
    }
}

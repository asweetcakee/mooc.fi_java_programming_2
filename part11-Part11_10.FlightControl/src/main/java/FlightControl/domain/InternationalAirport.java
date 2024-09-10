/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author mefferio
 */
public enum InternationalAirport {
    JFK("John F. Kennedy International Airport", "New York, USA"),
    LHR("London Heathrow Airport", "London, UK"),
    NRT("Narita International Airport", "Tokyo, Japan"),
    CDG("Charles de Gaulle Airport", "Paris, France"),
    DXB("Dubai International Airport", "Dubai, UAE"),
    ATL("Hartsfield-Jackson Atlanta International Airport", "Atlanta, USA"),
    PEK("Beijing Capital International Airport", "Beijing, China"),
    LAX("Los Angeles International Airport", "Los Angeles, USA"),
    HND("Tokyo Haneda Airport", "Tokyo, Japan"),
    SIN("Singapore Changi Airport", "Singapore"),
    SYD("Sydney Kingsford Smith Airport", "Sydney, Australia"),
    ORD("O'Hare International Airport", "Chicago, USA"),
    HKG("Hong Kong International Airport", "Hong Kong, SAR China"),
    DFW("Dallas/Fort Worth International Airport", "Dallas/Fort Worth, USA"),
    AMS("Amsterdam Schiphol Airport", "Amsterdam, Netherlands"),
    FRA("Frankfurt Airport", "Frankfurt, Germany"),
    IST("Istanbul Airport", "Istanbul, Turkey"),
    ICN("Incheon International Airport", "Seoul, South Korea"),
    BKK("Suvarnabhumi Airport", "Bangkok, Thailand"),
    MIA("Miami International Airport", "Miami, USA"),
    SFO("San Francisco International Airport", "San Francisco, USA"),
    GRU("São Paulo/Guarulhos–Governador André Franco Montoro International Airport", "São Paulo, Brazil"),
    YYZ("Toronto Pearson International Airport", "Toronto, Canada"),
    EZE("Ministro Pistarini International Airport", "Buenos Aires, Argentina"),
    MAD("Adolfo Suárez Madrid–Barajas Airport", "Madrid, Spain"),
    BCN("Barcelona-El Prat Airport", "Barcelona, Spain"),
    MUC("Munich Airport", "Munich, Germany"),
    ZRH("Zurich Airport", "Zurich, Switzerland"),
    VIE("Vienna International Airport", "Vienna, Austria"),
    CPT("Cape Town International Airport", "Cape Town, South Africa"),
    BAL("Baltimore/Washington International Thurgood Marshall Airport", "Baltimore, USA"),
    HEL("Helsinki-Vantaa Airport", "Helsinki, Finland"),
    TXL("Berlin Tegel Airport", "Berlin, Germany");

    private String fullname;
    private String location;

    private InternationalAirport(String fullname, String location) {
        this.fullname = fullname;
        this.location = location;
    }

    public String getFullname() {
        return fullname;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.name())
                .append(": ")
                .append(this.fullname)
                .append(" (")
                .append(this.location)
                .append(")")
                .toString();
    }
}

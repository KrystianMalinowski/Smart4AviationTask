
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Flight_Entity {

@SerializedName("flightId")
@Expose
public Integer flightId;
@SerializedName("flightNumber")
@Expose
public Integer flightNumber;
@SerializedName("departureAirportIATACode")
@Expose
public String departureAirportIATACode;
@SerializedName("arrivalAirportIATACode")
@Expose
public String arrivalAirportIATACode;
@SerializedName("departureDate")
@Expose
public String departureDate;
@Override
public String toString() {
	return "Flight_Entity [flightId=" + flightId + ", flightNumber=" + flightNumber + ", departureAirportIATACode="
			+ departureAirportIATACode + ", arrivalAirportIATACode=" + arrivalAirportIATACode + ", departureDate="
			+ departureDate + "]";
}

}
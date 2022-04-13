import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FlightEntity {

@SerializedName("flightId")
@Expose
public Integer flightId;
@SerializedName("baggage")
@Expose
public List<Baggage> baggage = null;
@SerializedName("cargo")
@Expose
public List<Cargo> cargo = null;
@Override
public String toString() {
	return "FlightEntity [flightId=" + flightId + ", baggage=" + baggage + ", cargo=" + cargo + "]";
}

}
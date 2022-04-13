
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Baggage {

@SerializedName("id")
@Expose
public Integer id;
@SerializedName("weight")
@Expose
public Integer weight;
@SerializedName("weightUnit")
@Expose
public String weightUnit;
@SerializedName("pieces")
@Expose
public Integer pieces;
@Override
public String toString() {
	return "Baggage [id=" + id + ", weight=" + weight + ", weightUnit=" + weightUnit + ", pieces=" + pieces + "]";
}


}
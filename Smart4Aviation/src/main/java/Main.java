import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Gson gson = new Gson();
		//Flight Entity
		JsonReader reader = new JsonReader(new FileReader("C:\\Users\\Kris\\Desktop\\FEFE.json"));
		Flight_Entity[] data = gson.fromJson(reader, Flight_Entity[].class);
		List<Flight_Entity> asList = Arrays.asList(data);
//		System.out.println(Arrays.toString(asList.toArray()));	
		//Cargo Entity
		JsonReader reader1 = new JsonReader(new FileReader("C:\\Users\\Kris\\Desktop\\CECE.json"));
		FlightEntity[] data1 = gson.fromJson(reader1, FlightEntity[].class);
		List<FlightEntity> asList1 = Arrays.asList(data1);
//		System.out.println(Arrays.toString(asList1.toArray()));
		
		Scanner in = new Scanner(System.in);
		String command ="";
		
		while(true) {
			System.out.println("Please select option by digit:");
			System.out.println("1. Flight Number request.");
			System.out.println("2. IATA Airport Code request.");
			command=in.nextLine();
			if(command.equals("1")) {
				System.out.println("Please select flight by digit:");
				int numberOfFlights = asList.size();
				for(int i=0;i<numberOfFlights;i++) {
					int number = asList.get(i).flightNumber;
					String dateFlight = asList.get(i).departureDate;
					System.out.println(i + ". Number: " + number + ", Date: "+dateFlight);
				}
				command=in.nextLine();
				int flight = Integer.valueOf(command);
				int cargoWeightKg=0;
				int cargoWeightLb=0;
				int baggageWeightKg=0;
				int baggageWeightLb=0;
				
				int cargoNumber = asList1.get(flight).cargo.size();
				for(int i=0;i<cargoNumber;i++){
					if(asList1.get(flight).cargo.get(i).weightUnit.equals("kg"))
						cargoWeightKg+=asList1.get(flight).cargo.get(i).weight;
					else if(asList1.get(flight).cargo.get(i).weightUnit.equals("lb"))
						cargoWeightLb+=asList1.get(flight).cargo.get(i).weight;
				}
				int baggageNumber = asList1.get(flight).baggage.size();
				for(int i=0;i<baggageNumber;i++){
					if(asList1.get(flight).baggage.get(i).weightUnit.equals("kg"))
						baggageWeightKg+=asList1.get(flight).baggage.get(i).weight;
					else if(asList1.get(flight).baggage.get(i).weightUnit.equals("lb"))
						baggageWeightLb+=asList1.get(flight).baggage.get(i).weight;
				}
				
				double totalCargoWeightKg=cargoWeightLb*2.20462262+cargoWeightKg;
				double totalCargoWeightLb=cargoWeightKg*0.45359237+cargoWeightLb;
				double totalBaggageWeightKg=baggageWeightLb*2.20462262+baggageWeightKg;
				double totalBaggegeWeightLb=baggageWeightKg*0.45359237+baggageWeightLb;
				double totalWeightKg = totalBaggageWeightKg + totalCargoWeightKg;
				double totalWeightLb = totalBaggegeWeightLb + totalCargoWeightLb;
				
				System.out.println("Total cargo weight in kg: " + String.format("%.2f",totalCargoWeightKg));
				System.out.println("Total cargo weight in lb: " + String.format("%.2f",totalCargoWeightLb));
				System.out.println("Total baggage weight in kg: " + String.format("%.2f",totalBaggageWeightKg));
				System.out.println("Total baggage weight in lb: " + String.format("%.2f",totalBaggegeWeightLb));
				System.out.println("Total weight in kg: " + String.format("%.2f",totalWeightKg));
				System.out.println("Total weight in lb: " + String.format("%.2f",totalWeightLb));
				System.out.println(" ");
				}
			else if(command.equals("2")){
				System.out.println("Please select IATA Airport Code by digit:");
				int numberOfIATA = asList.size();
				int numbersForSelect=0;
				for(int i=0;i<numberOfIATA;i++) {
					String IATAA = asList.get(i).arrivalAirportIATACode;
					String IATAD = asList.get(i).departureAirportIATACode;
					String dateFlight = asList.get(i).departureDate;
					System.out.println(numbersForSelect + ". IATA Airport Code: " + IATAA + ", Date: "+dateFlight);
					numbersForSelect++;
					System.out.println(numbersForSelect + ". IATA Airport Code: " + IATAD + ", Date: "+dateFlight);
					numbersForSelect++;
				}
				command=in.nextLine();
				int flight = Integer.valueOf(command);
				numbersForSelect=0;
				String IATA ="";
				for(int i=0;i<numberOfIATA;i++) {
					String IATAA = asList.get(i).arrivalAirportIATACode;
					String IATAD = asList.get(i).departureAirportIATACode;
					if(numbersForSelect==Integer.valueOf(command))
						IATA=IATAA;
					numbersForSelect++;
					if(numbersForSelect==Integer.valueOf(command))
						IATA=IATAD;
					numbersForSelect++;
				}
				
				int numberOfFlightsDeparting =0;
				int numberOfFlightsArriving=0;
				int piecesOfBaggageArriving=0;
				int piecesOfBaggegeDeparting=0;
				
				for(int i =0;i<asList1.size();i++) {
					if(IATA.equals(asList.get(i).arrivalAirportIATACode)) {
						numberOfFlightsArriving++;
						int flightId=asList.get(i).flightId;
						for(int j=0;j<asList1.size();j++) {
							if(flightId==asList1.get(j).flightId)
								for(int k=0;k<asList1.get(j).baggage.size();k++)
									piecesOfBaggageArriving+=asList1.get(j).baggage.get(k).pieces;
						}
					}
					if(IATA.equals(asList.get(i).departureAirportIATACode)) {
						numberOfFlightsDeparting++;
						int flightId=asList.get(i).flightId;
						for(int j=0;j<asList1.size();j++) {
							if(flightId==asList1.get(j).flightId)
								for(int k=0;k<asList1.get(j).baggage.size();k++)
									piecesOfBaggegeDeparting+=asList1.get(j).baggage.get(k).pieces;
						}
					}
				}
				System.out.println(IATA + " - Number of flights departing from this airport: " + numberOfFlightsDeparting);
				System.out.println(IATA + " - Number of flights arriving to this airport: " + numberOfFlightsArriving);
				System.out.println(IATA + " - Total number of baggage arriving to this airport: " + piecesOfBaggageArriving);
				System.out.println(IATA + " - Total number of baggage departing from this airport: " + piecesOfBaggegeDeparting);
				System.out.println(" ");
			}
			else
				System.out.println("You entered the wrong digit");
		}
	
	}

}

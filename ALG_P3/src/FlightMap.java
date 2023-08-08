import java.io.*;
import java.util.*;
/*
 * Created on Oct 13, 2004
 * Modified to include HashMap and StackReferenceBased on March 2, 2018
 * @author class_sandip
 * 
 * Edited by: Alec Howard
 * SID: 1555155
 * March 22, 2021
 */
public class FlightMap {
    HashMap<String,City> cities;

    public FlightMap(String mapFileName) {
    	cities = new HashMap<String,City>();
    	createFlightMap(mapFileName);
    }
    private void createFlightMap(String mapFileName) {
	try {
	    Scanner input = new Scanner(new File(mapFileName));
	    Scanner line;
	    while (input.hasNextLine()){
	    	line = new Scanner(input.nextLine());
	    	String origCity = line.next();
	    	City ct = cities.get(origCity);
	    	if(ct==null) {
	    		ct = new City(origCity);
	    		cities.put(origCity,ct);
	    	}
	    	String destCity = line.next();
	    	if(cities.get(destCity)==null)
	    		cities.put(destCity,new City(destCity));
	    	double cost = line.nextDouble();
	    	ct.addNeighbor(new Destination(destCity, cost));
	    	}
	    	input.close();
		} catch (IOException e) {
	    System.out.println("IOException in reading input file!!!");
		}
    }
    private void unvisitAll() {
    // NEED CODE FOR PROJECT

    }
    private City getNextCity(City ct) {
	// If there are more neighbors to visit from ct,
	// loop
	//   get name of next neighbor 
	//   retrieve the City with that name
	//   if that City is unvisited return it
	//
	// if no unvisited neighbor of ct remains, return null
	
	// NEED CODE FOR PROJECT

    }
    public void findPath(String origin, String destination) {
	//	   ---------------------------------------------------
	//	   Determines whether a sequence of flights between
	//	   two cities exists. Nonrecursive stack version.
	//	   Precondition: origin and destination are the origin
	//	   and destination city names, respectively.
	//	   Postcondition: Prints out a sequence of flights
	//	   connecting origin to destination and the total
	//	   cost, otherwise prints out a failure
	//	   message. Cities visited during search are marked as
	//	   visited in the flight map.  Unmark all cities after finishing search.
	//	   Implementation notes: Uses a stack for the cities of a potential
	//	   path. Calls unvisitAll, markVisited, and getNextCity.
	//	   ---------------------------------------------------
    	City originCity=cities.get(origin);
    	if (originCity == null)
    		System.out.println(origin+" not in map!");
    	else {
    		City destinationCity=cities.get(destination);
    		if (destinationCity == null)
    			System.out.println(destination+" not in map!");
    		else {
    			StackInterface<City> stack = new StackReferenceBased<City>();
    			originCity.markVisited();
    			stack.push(originCity);
	   
    			// NEED CODE FOR PROJECT 
    			// Use stack to search the map. If no path is found print out a message to state that.
    			// If a path is found, print out the path and the total cost
    
    		}	
    	} 
    }// end isPath
}

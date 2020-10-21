/*You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 
 

Constraints:

trips.length <= 1000
trips[i].length == 3
1 <= trips[i][0] <= 100
0 <= trips[i][1] < trips[i][2] <= 1000
1 <= capacity <= 100000*/

//thanks to kunal_mestry
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];// obtenga la variedad de viajes dentro de los viajes
            int passengers = trip[0]; // número de pasajeros está en la posición 0.
            //mantener tupla o par de (posición inicial, pasajeros) y (posición final, -pasajeros)
            //Pasajeros negativos en posición final, ya que necesitamos
            //eliminar pasajeros del recuento cuando los dejamos.
            if (map.containsKey(trip[1])) {
                map.put(trip[1], map.get(trip[1]) + passengers);
            } else {
                map.put(trip[1], passengers);
            }
            if (map.containsKey(trip[2])) {
                map.put(trip[2], map.get(trip[2]) - passengers);
            } else {
                map.put(trip[2], -passengers);
            }
        }
        // obtenemos el mapa ordenado aquí debido al uso de TreeMap.
        int currentCapacity = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //siga agregando pasajeros a la capacidad actual.
            currentCapacity += entry.getValue();
            //si en algún momento la capacidad actual es mayor que la capacidad, devuelva falso.
            if (currentCapacity > capacity)
                return false;
        }
        //verdadero cuando todos los pasajeros pueden ser incluidos en la matriz de viajes.
        return true;
    }
}
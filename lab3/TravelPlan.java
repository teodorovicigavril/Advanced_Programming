package com.company;


import java.util.*;

import static com.company.Main.positionInCity;

public class TravelPlan {
    private City city;
    ArrayList<Integer> preferences;

    public TravelPlan(City city) {
        this.city = new City();
        this.city = city;
        this.preferences = new ArrayList<Integer>();

        Scanner scan = new Scanner(System.in);
        for(Location i: city.getNodes()){
            System.out.print("Preferinta pentru " + i.getName() + " este: ");
            this.preferences.add(scan.nextInt());
        }
    }

    public TravelPlan() {
        this.city = new City();
        this.preferences = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<Integer> preferences) {
        this.preferences = preferences;
    }

    public City getCity() {
        return city;
    }


    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "TravelPlan{" +
                "city=" + city +
                ", preferences=" + preferences +
                '}';
    }

    // Function to find the distance/cost of
    // the start location to all the others locations from city
    public int[] dijkstraDist(Location s, int[] path)
    {
        final int infi = 1000000000;
        int[] dist = new int[getCity().getNodes().size()];

        boolean[] visited = new boolean[getCity().getNodes().size()];
        for(int i = 0; i < getCity().getNodes().size(); i++)
        {
            visited[i] = false;
            path[i] = -1;
            dist[i] = infi;
        }
        dist[positionInCity(s,city)] = 0;
        path[positionInCity(s,city)] = -1;
        int current = positionInCity(s,city);

        int preferinta;


        Set<Integer> sett = new HashSet<>();
        while (true)
        {
            // preferinta will decide on which path we will go
            preferinta = 0;
            // Mark current as visited
            visited[current] = true;
            for(int i = 0; i < s.getCost().size(); i++)
            {
                // extracting the neighbours of locations s, where we can go from location s
                Set<Location> veciniSet = s.getCost().keySet();
                List<Location> veciniList = new ArrayList<>(veciniSet);

                int v = positionInCity(veciniList.get(i),city);

                if (visited[v])
                    continue;


                int alt = 0;
                sett.add(v);
                // finding the curent cost from s to his neighbours
                alt = dist[current] + s.getCost().get(veciniList.get(i));

                // first, we update the cost by preferences
                if(preferinta < getPreferences().get(v)){
                    preferinta = getPreferences().get(v);
                    dist[v] = alt;
                    path[v] = current;
                }
                else {
                    //if the preferences are equals then we check the minimul cost
                    if (preferinta == getPreferences().get(v))
                        if (alt < dist[v]) {
                            dist[v] = alt;
                            path[v] = current;
                        }
                    }
                }
            sett.remove(current);

            if (sett.isEmpty())
                break;

            // The new current
            int minDist = infi;
            int index = 0;

            // Loop to update the distance
            // of the vertices of the graph
            for(int a : sett)
            {
                if (dist[a] < minDist)
                {
                    minDist = dist[a];
                    index = a;
                }
            }
            current = index;

            s = getCity().getNodes().get(current);
        }
        return dist;
    }
}

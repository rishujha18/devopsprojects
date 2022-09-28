package model;

public class GetDetails {
    private String name;
    private String city;
    private int distance;

    
    public GetDetails() {
    }
    
    public GetDetails(String name, String city, int distance) {
        this.name = name;
        this.city = city;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    


    
}

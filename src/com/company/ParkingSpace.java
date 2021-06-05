package com.company;

// ParkingSpace class. Used to store information about the parking places.
public class ParkingSpace implements Comparable<ParkingSpace>{

    // Declaring the Field of the Class.
    public static final int numberOfParkPlaces = 154;
    public static TypeOfSorting typeOfSorting;
    public static ParkingSpace [] parkingPlaces = new ParkingSpace[numberOfParkPlaces];

    private int number;
    private double area;
    private String nameOfUser, description;

    // Main constructor: takes the Number, Area, Name of the User, and the Description of the Parking Place.
    public ParkingSpace(int number, double area, String nameOfUser, String description) {
        this.number = number;
        this.area = Math.floor(area*100)/100;
        this.nameOfUser = nameOfUser;
        this.description = description;
    }

    // Overriding the compareTo function so we can sort them by what we want. Sorting in ascending order.
    @Override
    public int compareTo(ParkingSpace parkingSpace) {
        // If we are comparing with park place #74, we return a specific value in this case, in order to display it at the beginning.
        if(number == 74) return Integer.MIN_VALUE;
        if(parkingSpace.getNumber() == 74) return Integer.MAX_VALUE;

        // In all other cases we compare them as their respective value type.
        return switch (typeOfSorting){
            case NUMBER -> number - parkingSpace.number;
            case AREA -> Double.compare(area, parkingSpace.area);
            case NAME -> nameOfUser.compareTo(parkingSpace.nameOfUser);
        };
    }

    // Returns formatted as an array of an array of strings the data from all the parking places. Used for initializing the JTable.
    public static String [][] getDataFromParkingPlaces(){
        String [][] data = new String[numberOfParkPlaces][4];
        for(int i=0;i<numberOfParkPlaces; ++i){
            data[i][0] = Integer.toString(parkingPlaces[i].getNumber());
            data[i][1] = Double.toString(parkingPlaces[i].getArea());
            data[i][2] = parkingPlaces[i].getNameOfUser();
            data[i][3] = parkingPlaces[i].getDescription();
        }
        return data;
    }

    // Mutators and Accessors of the Field

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static TypeOfSorting getTypeOfSorting() {
        return typeOfSorting;
    }

    public static void setTypeOfSorting(TypeOfSorting typeOfSorting) {
        ParkingSpace.typeOfSorting = typeOfSorting;
    }


    // toString method of the class. Used while debugging.
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParkingSpace{");
        sb.append("number=").append(number);
        sb.append(", area=").append(area);
        sb.append(", nameOfUser='").append(nameOfUser).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

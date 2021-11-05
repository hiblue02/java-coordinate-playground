package rentcompany.car;

public abstract class Car implements Vehicle {

    public double distance;
    public double distancePerLiter;

    public Car(double distance, double distancePerLiter){
        this.distance = distance;
        this.distancePerLiter = distancePerLiter;
    }

    public double getChargeQuantity(){
        return distance/distancePerLiter;
    }

}

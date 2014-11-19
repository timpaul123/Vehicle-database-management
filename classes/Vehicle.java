/*
 * A simple Vehicle class. 
 */

package databasemanagement;

/**
 *
 * @author Tim Carrington
 */
public class Vehicle {
    private final String make;
    private final String model;
    private final String VRN;
    private double odometer;
    
    public Vehicle(String make, String model, String VRN, double odometer)
    {
        this.make = make;
        this.model = model;
        this.VRN = VRN;
        setOdometer(odometer);
    }
    
    public void setOdometer(double newOdometer)
    {
        if(newOdometer < 0)
            throw new IllegalArgumentException("Odometer must be larger than 0");
        if(newOdometer < getOdometer())
            throw new IllegalArgumentException("Value for new Odometer cannot be smaller than original odometer");
       
        this.odometer = newOdometer;
    }
    
    public double getOdometer()
    {
        return odometer;
    }
    
    public String getMakeAndModel()
    {
        return String.format("%s %s", make, model);
    }
    
    public String getVRN()
    {
        return VRN;
    }
    
   
}

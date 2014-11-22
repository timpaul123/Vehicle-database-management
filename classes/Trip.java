/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databasemanagement;
import java.util.Date;
/**
 *
 * @author Tim
 */
public class Trip {
    private final String controlNumber;
    private Date startDate;
    private Date endDate;
    private String locationTo;
    private String locationFrom;
    
    public Trip(String controlNumber, Date endDate, String locationTo, String locationFrom, Date startDate)
    {
        this.controlNumber = controlNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.locationFrom = locationFrom;
        this.locationTo = locationTo;
    }
    
    public String getControlNumber(){
        return controlNumber;
    }
    
    public String getLocationTo(){
        return locationTo;
    }
    
    public String getLocationFrom(){
        return locationFrom;
    }
    
    public Date getStartDate(){
        return startDate;
    }
    
    public Date getEndDate(){
        return endDate;
    }
    
    @Override
    public String toString(){
        return String.format("Trip Control number: %s From: %s To: %s Date out: %s Date returned: %s",
                                getControlNumber(), getLocationFrom(), getLocationTo(), getStartDate(), getEndDate());
    }
}

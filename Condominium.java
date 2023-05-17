
public class Condominium extends Property{
    private String unit;	//holds unit 
    private int floorNum;	//holds floor num
    private final String propertyType = "Condo";	//defining the type
	
    public Condominium() {
        super ();
    }

    @Override
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public int getFloorNum() {
        return floorNum;
    }
    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    @Override
    public String getPropertyType() {
        return propertyType;
    }

   
}
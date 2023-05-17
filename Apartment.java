public class Apartment extends Property{
	private String unit;
    private int floorNum;
    private final String propertyType = "Apartment";
	
    public Apartment(){
		super();
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
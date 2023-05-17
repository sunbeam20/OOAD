import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Property{ 	//model of mvc pattern
	private int uploaderID;
    private ImageIcon imageIcon;
    private int propertyID;
    private String address;
    private int contactNum;
    private String rentStatus;
    private double rentPrice;
    private double propertySize;
    private String description;
    private double deposit;
    private String furnishing;
	private String facilities;
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private boolean hidden;
    private String owner;

	public int getUploaderID() {
        return uploaderID;
    }
    public void setUploaderID(int uploaderID) {
        this.uploaderID = uploaderID;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public int getPropertyID() {
        return propertyID;
    }
    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNum() {
        return contactNum;
    }
    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    public String getRentStatus() {
        return rentStatus;
    }
    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    public double getRentPrice() {
        return rentPrice;
    }
    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public double getPropertySize() {
        return propertySize;
    }
    public void setPropertySize(double propertySize) {
        this.propertySize = propertySize;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getDeposit() {
        return deposit;
    }
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getFurnishing() {
        return furnishing;
    }
    public void setFurnishing(String furnishing) {
        this.furnishing = furnishing;
    }
	public String getFacilities(){
		return facilities;
	}
	public void setFacilities(String facilities){
		this.facilities = facilities;
	}

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }
    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }
    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public void setHidden(){
        hidden = true;
    }
    public void setUnHidden(){
        hidden = false;
    }
    public boolean getHiddentStatus(){
        return hidden;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }
    public String getOwner(){
        return owner;
    }
    
    public abstract String getUnit();	//abstraction
    public abstract int getFloorNum();
    public abstract String getPropertyType();
}
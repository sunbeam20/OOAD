public class Admin extends User{
	private final String userType = "Admin";	// defining type
	public Admin(String username, String password){
		super(username,password);
	}
	@Override
    public String getUserType() {
        return userType;
    }
}
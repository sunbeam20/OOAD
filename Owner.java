public class Owner extends User{
	private final String userType = "Owner";
	public Owner(String username, String password){
		super(username,password);
	}
	@Override
    public String getUserType() {
        return userType;
    }
}
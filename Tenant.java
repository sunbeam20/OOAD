public class Tenant extends User{
	private final String userType = "Tenant";
	public Tenant(String username, String password){
		super(username,password);
	}
	@Override
    public String getUserType() {
        return userType;
    }
}
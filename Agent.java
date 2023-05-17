public class Agent extends User{
	private final String userType = "Agent";
	public Agent(String username, String password){
		super(username,password);
	}
	@Override
    public String getUserType() {
        return userType;
    }
}
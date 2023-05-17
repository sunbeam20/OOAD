public abstract class User{
	static String x = "";
	private String username;
	private String password;
	
	public User(String username, String password){
		this.username = username; this.password = password;
	}
	
	public String getUserName() {
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public static String getX(){
		return x;
	}
	public static void setX(String y){
		x = y;
	}
	public abstract String getUserType();
}
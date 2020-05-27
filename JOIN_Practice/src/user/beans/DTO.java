package user.beans;

public class DTO {
	private int user_Uid;
	private String userID;
	private String userPassword;
	private String userEmail;
	private String userEmailHash;
	private String userEmailChecked;
	public DTO() {
		super();
	}
	public DTO(String userID, String userPassword, String userEmail, String userEmailHash,
			String userEmailChecked) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userEmailHash = userEmailHash;
		this.userEmailChecked = userEmailChecked;
	}
	public int getUser_Uid() {
		return user_Uid;
	}
	public void setUser_Uid(int user_Uid) {
		this.user_Uid = user_Uid;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserEmailHash() {
		return userEmailHash;
	}
	public void setUserEmailHash(String userEmailHash) {
		this.userEmailHash = userEmailHash;
	}
	public String getUserEmailChecked() {
		return userEmailChecked;
	}
	public void setUserEmailChecked(String userEmailChecked) {
		this.userEmailChecked = userEmailChecked;
	}
	

}

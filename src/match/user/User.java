package match.user;

public class User {
	// ÓÃ»§Ãû
	private String username;
	// ÃÜÂë
	private String password;
	private int time;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = this.time+time;
	}
}

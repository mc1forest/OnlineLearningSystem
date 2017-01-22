package web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;

	private Map errors = new HashMap();

	public Map getErrors() {
		return errors;
	}

	public void setErrors(Map errors) {
		this.errors = errors;
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public boolean validate() {
		boolean isOK = true;

		if (this.username == null || this.username.trim().equals("")) {
			isOK = false;
			errors.put("username", "can't be empty");
		} else {
			if (!this.username.matches("[A-Z a-z]{3,8}")) {
				isOK = false;
				errors.put("username", "must be 3-8 numbers or characters");
			}
		}

		if (password == null || password.trim().equals("")) {
			isOK = false;
			errors.put("password", "can't be empty");
		} else {
			if (!password.matches("[A-Z a-z]{3,8}")) {
				isOK = false;
				errors.put("password", "must be 3-8 numbers or characters");
			}
		}

		if (password2 == null || password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "can't be empty");
		} else {
			if (!password2.equals(password)) {
				isOK = false;
				errors.put("password2", "must be the same to above password");
			}
		}

		if (email == null || email.trim().equals("")) {
			isOK = false;
			errors.put("email", "email can't be empty");
		} else {
			if (!email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOK = false;
				errors.put("email", "wrong format");
			}
		}

		if (birthday != null && !birthday.trim().equals("")) {
			try {
				DateLocaleConverter dlc = new DateLocaleConverter();
				dlc.convert(birthday, "dd-MMM-yyyy");
			} catch (Exception e) {
				isOK = false;
				errors.put("birthday", "wrong birthday format");
			}
		}

		return isOK;
	}
}

package regEx;

import java.util.regex.Pattern;

public class RegEx {
	/**
	 * ID 정규식을 확인합니다
	 * 아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.
	 * @return
	 */
	public static boolean checkId(String id) {
		boolean result = false;
		String regId = "[a-z]+[a-z0-9]{5,19}";
		result = Pattern.matches(regId, id);
		return result;
	}
	
	/**
	 * Password 정규식을 확인합니다
	 * 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함해야 합니다.
	 * @param pw
	 * @return
	 */
	public static boolean checkPw(String pw) {
		boolean result = false;
		String regId = "(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}";
		result = Pattern.matches(regId, pw);
		return result;
	}
	
	
	/**
	 * 이메일 정규식을 확인합니다.
	 * @param email
	 * @return
	 */
	public static boolean checkMail(String email) {
		boolean result = false;
		String regId = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		result = Pattern.matches(regId, email);
		return result;
	}
	
	
	/**
	 * 핸드폰 정규식을 확인합니다
	 * @param phone
	 * @return
	 */
	public static boolean checkPhone(String phone) {
		boolean result = false;
		String regId = "^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$";
		result = Pattern.matches(regId, phone);
		return result;
	}
	
	/**
	 * 숫자 정규식을 확인합니다.
	 * 한자리 이상의 숫자여야 하고
	 * 소수점도 받습니다.
	 */
	public static boolean checkNum(String str) {
		boolean result = false;
		String regId = "^[0-9]+(.)?[0-9]?$";
		result = Pattern.matches(regId, str);
		return result;
	}
	
	public static boolean checkInt(String str) {
		boolean result = false;
		String regId = "^[0-9]+$";
		result = Pattern.matches(regId, str);
		return result;
	}
}

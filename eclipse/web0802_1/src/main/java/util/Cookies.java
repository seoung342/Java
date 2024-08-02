package util;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Cookies {
	private Map<String, Cookie> cookieMap = new java.util.HashMap<String, Cookie>();	// 해시맵에 쿠키 저장 위해
			//    키   ,   값 
	public Cookies(HttpServletRequest request) {	// 생성자
		Cookie[] cookies = request.getCookies();	// request 기본 객체에서 쿠키 정보를 가져옴
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);	// 해시맵에 쿠키 저장
			}
		}
	}
	
	public Cookie getCookie(String name) { // 쿠키 꺼내기
		return cookieMap.get(name);
	}
	
	public String getValue(String name) throws IOException{ // 쿠키 값 꺼내기
		Cookie cookie = cookieMap.get(name);
		if(cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), "utf-8"); // 한글 처리
	}
	
	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}

	public static Cookie createCookie(String name, String value)
	throws IOException {
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}

	public static Cookie createCookie(String name, String value, String path, 
		int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	public static Cookie createCookie(String name, String value, String domain,
			String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}

}
package com.example.demo.common.util;

import javax.servlet.http.HttpSession;

import com.example.demo.domain.User;

/**
 * 
 * @author jeongwon
 * @description HttpSession을 통해 이루어지는 작업들 중 중복적으로 일어나는 메소드에 대해서 클래스를 따로 지정해,
 *              중복을 제거함
 *
 */
public class HttpSessionUtil {
  
  public static final String USER_SESSION_KEY = "sessionedUser";
  
  public static boolean isLoginUser(HttpSession session) {
    Object sessionedUser = session.getAttribute(USER_SESSION_KEY);
    if(sessionedUser == null) {
      return false;
    }
    return true;
  }
  
  public static User getUserFromSession(HttpSession session) {
    if(!isLoginUser(session)) {
      return null;
    }
    return (User)session.getAttribute(USER_SESSION_KEY);
  }

}

package com.Joke.util;

import com.Joke.entity.User;
/**
 * 工具类--有关注册的功能实现
 * @author Administrator
 *
 */
public class Register {

	static User user = new User();

	public static String checkName(String name) {
		user.setName(name);
		return null;

	}

	public static String checkID(String ID) {
		if (ID.matches("\\d{1,8}")) {
			user.setID(ID);
			return null;
		} else
			return "ID not conform to the rules";
	}

	public static String checkPasswd(String passwd) {
		if (passwd.matches("\\d{6,15}")) {
			user.setPasswd(passwd);
			return null;
		} else
			return "Password not conform to the rules";
	}

	// 如果以上验证都没有错误信息返回，则执行写入用户信息
	public static String register(String name, String passwd, String ID) {
		user.setName(name);
		user.setPasswd(passwd);
		user.setID(ID);
		return (JDOM.write(user.getName(), user.getPasswd(), user.getID()));

	}
}

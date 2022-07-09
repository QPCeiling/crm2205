package com.bjpowernode.crm.commons.utils;

import cn.hutool.crypto.digest.DigestUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	public static String getMD5(String password) {
		try {
			// 得到一个信息摘要器
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] result = digest.digest(password.getBytes());
			StringBuffer buffer = new StringBuffer();
			// 把每一个byte 做一个与运算 0xff;
			for (byte b : result) {
				// 与运算
				int number = b & 0xff;// 加盐
				String str = Integer.toHexString(number);
				if (str.length() == 1) {
					buffer.append("0");
				}
				buffer.append(str);
			}

			// 标准的md5加密后的结果
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static void main(String[] args) {
		String md5Hex = DigestUtil.md5Hex("ls", "UTF-8");
		String confusionPwd = "oweigwoeigh68546" + md5Hex + "bjpwernode";
		System.out.println(confusionPwd);
		String saltPassword = DigestUtil.md5Hex(confusionPwd, "UTF-8");
		System.out.println(saltPassword);
	}
	
}

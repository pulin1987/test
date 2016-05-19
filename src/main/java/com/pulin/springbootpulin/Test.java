package com.pulin.springbootpulin;

public class Test {
	public static void main(String[] args) {
		String result = "fileName";
		 result = result.length() > 1 ? (result.substring(0, 1) + result.substring(1).replaceAll("([A-Z])", "_$1")) : result;
		 result = "`" + result.toLowerCase() + "`";
		 System.out.println(result);
	}
}

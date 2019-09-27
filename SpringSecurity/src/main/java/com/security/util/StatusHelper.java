package com.security.util;

public class StatusHelper {

	public static Response statusResponse(int code, String message) {

		Response response = new Response();

		response.setCode(code);
		response.setMessage(message);
		return response;

	}

}

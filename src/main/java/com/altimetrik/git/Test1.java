package com.altimetrik.git;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Test1 {

	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping(name = "/getMessage")
	public String getMessage() {

		ResponseEntity<String> p2 = restTemplate.exchange("http://localhost:8090/getMessage", HttpMethod.GET, null, String.class);
		// System.out.println(p2.getBody());
		return part1() + p2.getBody();
	}

	private String part1() {
		return "Dhinahar Shanmugasundaram";
	}

	private String part2() {
		return "Kavitha Palanisamy";
	}

	public static void main(String args[]) {

		String str = "abcd";
		String oriString=str;
		// for (int i = 0; i < str.length(); i++) {
		rec(str,oriString);
		// }

	}
	static int i = 1;
	private static void rec(String str, String oriString) {
		
		if (str.length() > 0) {
			System.out.println(str);
			String s = str.substring(0, str.length() - 1);
			rec(s,oriString);
		}
		rec(oriString.substring(i++),oriString.substring(i++));

	}
	
	public void test(){
		System.out.println("Test");
	}
}

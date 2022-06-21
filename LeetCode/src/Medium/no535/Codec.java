package Medium.no535;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {

	Map<String, String> map;
	final String MYURL = "https://shorts.com/";

	Codec() {
		map = new HashMap<>();
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {

		String key = randomKey();

		while (map.containsKey(key))
			key = randomKey();

		map.put(key, longUrl);

		return MYURL + key;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {

		String key = shortUrl.replace(MYURL, "");

		return map.containsKey(key) ? map.get(key) : null;
	}

	public String randomKey() {

		StringBuilder sb = new StringBuilder();

		int cnt = 8;
		Random ran = new Random();

		while (cnt-- > 0) {
			sb.append((char) 'a' + ran.nextInt(26));
		}

		return sb.toString();
	}

}

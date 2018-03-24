package teel;

import java.util.HashMap;

public class EncodeDecodeURL {
	int c = 1;
	String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	HashMap<String, String> hm  = new HashMap<>();
	
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    		StringBuilder sb = new StringBuilder();
    		long t = c;
    		while (t > 0) {
    			t--;
    			sb.append(map.charAt((int)t%62));
    			t = t/62;
    		}
    		String surl = sb.toString();
    		hm.put(surl, longUrl);
        c++;
        return "http://tinyurl.com/" + surl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hm.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

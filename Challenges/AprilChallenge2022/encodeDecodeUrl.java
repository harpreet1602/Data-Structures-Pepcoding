import java.util.HashMap;

public class encodeDecodeUrl {
   
// 535. Encode and Decode TinyURL
//     tc O(1) sc O(n)
//     Encode the original string to different kind of short string that can be
//     a count or hashCode of that original url
//     Store the encoded url in a hashmap with the original url
//     While decoding, return the value of the key from hashmap
    // Encodes a URL to a shortened URL.
    HashMap<String,String> map = new HashMap<>();
    public String encode(String longUrl) {
        // String key = "http://LC"+map.size();
        String key = ""+map.size();
        // String key = ""+longUrl.hashCode();
        map.put(key,longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    } 
}

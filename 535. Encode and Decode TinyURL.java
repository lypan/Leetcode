// hash code
/* public class Codec {
 *     Map<Integer, String> map = new HashMap<>();
 *
 *     public String encode(String longUrl) {
 *         map.put(longUrl.hashCode(), longUrl);
 *         return "http://tinyurl.com/" + longUrl.hashCode();
 *     }
 *
 *     public String decode(String shortUrl) {
 *         return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
 *     }
 * } */

// random
public class Codec {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();
    String key = getRand();

    public String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

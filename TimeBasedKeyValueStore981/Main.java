package TimeBasedKeyValueStore981;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        TimeMap timeMap1 = new TimeMap();
        timeMap1.set("foo", "bar", 1);
        System.out.println(Objects.equals(timeMap1.get("foo", 1), "bar"));
        System.out.println(Objects.equals(timeMap1.get("foo", 3), "bar"));
        timeMap1.set("foo", "bar2", 4);
        System.out.println(Objects.equals(timeMap1.get("foo", 4), "bar2"));
        System.out.println(Objects.equals(timeMap1.get("foo", 5), "bar2"));
    }
}

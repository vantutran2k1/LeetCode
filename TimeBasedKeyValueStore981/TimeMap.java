package TimeBasedKeyValueStore981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    private class Entry {
        private final String value;
        private final int timestamp;

        public Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private class Entries {
        private final List<Entry> entries;

        public Entries() {
            entries = new ArrayList<>();
            entries.add(new Entry("", 0));
        }

        public void add(Entry entry) {
            entries.add(entry);
        }

        public int size() {
            return entries.size();
        }

        public Entry get(int index) {
            return entries.get(index);
        }
    }

    private final Map<String, Entries> values;

    public TimeMap() {
        values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        values.computeIfAbsent(key, k -> new Entries()).add(new Entry(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!values.containsKey(key))
            return "";

        Entries entries = values.get(key);
        int left = 0, right = entries.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            Entry entry = entries.get(mid);
            if (entry.timestamp <= timestamp)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return entries.get(right).value;
    }
}

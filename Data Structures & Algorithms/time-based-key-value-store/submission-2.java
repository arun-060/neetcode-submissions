class TimeMap {

    private static class Pair {
        int time;
        String value;

        Pair(int t, String v) {
            this.time = t;
            this.value = v;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        int l = 0, r = list.size()-1;
        String result = "";

        while (l <= r) {
            int m = l + (r-l)/2;
            if (list.get(m).time <= timestamp) {
                result = list.get(m).value;
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return result;
    }
}

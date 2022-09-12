class Matching {

    public void incrCount(String key, HashMap<String, Integer> map) { 
        if (map.containsKey(key)) 
            map.put(key, map.get(key) + 1); 
        else 
            map.put(key, 1);
    } // O(k) average time

    public void prepare(String text, int k, HashMap<String, Integer> map) { 
        for (int leftIdx = 0; leftIdx <= text.length() – k; leftIdx++) {
            String word = text.substring(leftIdx, leftIdx + k); 
            incrCount(word, map);
        }
    }

    // pre-cond: word.length() == k
    public int findWordInText(String word, HashMap<String, Integer> map) { 
        return (map.get(word) == null ? 0 : map.get(word).intValue());
    }

}
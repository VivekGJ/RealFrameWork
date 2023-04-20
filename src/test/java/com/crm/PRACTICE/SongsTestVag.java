package com.crm.PRACTICE;

import java.util.*;

public class SongsTestVag
{
    private int capacity;
    private LinkedHashMap<String, List<String>> recentlyPlayed;

    public void recentlyPlayedStore(final int capacity) {
        this.capacity = capacity;
        this.recentlyPlayed = new LinkedHashMap<String, List<String>>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, List<String>> eldest) {
                return size() > capacity; // remove least recently played song if capacity is exceeded
            }
        };
    }

    public void playSong(String user, String song) {
        List<String> songs = recentlyPlayed.getOrDefault(user, new ArrayList<>(capacity));
        songs.remove(song);
        songs.add(0, song);
        recentlyPlayed.put(user, songs);
    }

    public List<String> getRecentlyPlayed(String user) {
        return new ArrayList<>(recentlyPlayed.getOrDefault(user, Collections.<String>emptyList()));
    }
}

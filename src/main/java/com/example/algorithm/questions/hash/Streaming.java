package com.example.algorithm.questions.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Streaming {

    @Test
    public void test() {
        Assertions.assertArrayEquals(new Integer[]{4, 1, 3, 0},
                solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                        new int[]{500, 600, 150, 800, 2500}));
    }

    public Integer[] solution(String[] genres, int[] plays) {

        Map<String, LinkedHashMap<Integer, Integer>> playsMap = new HashMap<>();
        Map<String, Integer> genresMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int songPays = plays[i];

            Integer playCnt = genresMap.getOrDefault(genre, 0);
            genresMap.put(genre, playCnt + songPays);

            LinkedHashMap<Integer, Integer> playList =playsMap.getOrDefault(genre, new LinkedHashMap<>());
            playList.put(i, songPays);
            playsMap.put(genre, playList);
        }

        List<String> sortedGenres = genresMap.entrySet().stream()
                .sorted(((o1, o2) -> o2.getValue().compareTo(o1.getValue())))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> positions = new ArrayList<>();

        for (String genre: sortedGenres) {
            LinkedHashMap<Integer, Integer> integers = playsMap.get(genre);
            List<Map.Entry<Integer, Integer>> playList = integers.entrySet().stream()
                    .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());

            for (int i = 0; i < playList.size(); i++) {
                if(i < 2) {
                    positions.add(playList.get(i).getKey());
                }
            }
        }

        return positions.toArray(new Integer[positions.size()]);
    }
}

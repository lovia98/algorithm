package com.example.algorithm.questions.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BestAlbum {

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{4, 1, 3, 0},
                solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));

        // - c: 1050, p -> 1200
        Assertions.assertArrayEquals(new int[]{1, 4, 3, 2},
                solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{100, 600, 150, 800, 600}));

        Assertions.assertArrayEquals(new int[]{2, 3},
                solution(new String[]{"jazz", "pop", "k-pop", "classic", "pop"}, new int[]{500, 600, 2000, 800, 10}));
    }

    /**
     * 베스트 앨범에 들어갈 노래를 장르별 2개씩 고유 번호를 순서대로 return
     * <p>
     * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
     * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
     * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
     *
     * @param genres
     * @param plays
     * @return
     */
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Map<Integer, Integer>> songs = new HashMap<>(); //음악 index, 플레이 갯수
        Map<String, Integer> genreMap = new HashMap<>(); //장르, 플레이 총 카운트

        makeAlbumMap(genres, plays, songs, genreMap);

        List<Integer> songsNumbers = new ArrayList<>();
        LinkedHashMap<String, Integer> sortedGenre = sortGenre(genreMap);

        sortedGenre.entrySet().forEach(it -> {
            Map<Integer, Integer> songsMap = songs.get(it.getKey());
            LinkedHashMap<Integer, Integer> sortedIntValues = sortedSongCount(songsMap);

            int rank = 0;
            for (Map.Entry<Integer, Integer> entry : sortedIntValues.entrySet()) {
                if (rank < 2) { //장르별로 2개까지만
                    songsNumbers.add(entry.getKey());
                }
                rank++;
            }
        });


        int[] answer = new int[songsNumbers.size()];
        for (int i = 0; i < songsNumbers.size(); i++) {
            answer[i] = songsNumbers.get(i);
        }

        return answer;
    }

    private void makeAlbumMap(String[] genres, int[] plays, Map<String, Map<Integer, Integer>> songs, Map<String, Integer> albumMap) {

        for (int i = 0; i < genres.length; i++) {

            int playCount = plays[i];
            String genre = genres[i];

            if (songs.containsKey(genre)) {
                Map<Integer, Integer> songMap = songs.get(genre);
                songMap.put(i, playCount); //고유 번호, 플레이 수
            } else {
                Map<Integer, Integer> songMap = new HashMap<>();
                songMap.put(i, playCount);
                songs.put(genre, songMap);
            }

            if (albumMap.containsKey(genre)) {
                albumMap.put(genre, albumMap.get(genre) + playCount);
            } else {
                albumMap.put(genre, playCount);
            }
        }
    }

    private static LinkedHashMap<Integer, Integer> sortedSongCount(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


    private static LinkedHashMap<String, Integer> sortGenre(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}

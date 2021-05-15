package com.example.algorithm.woo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    @Test
    public void test() {
        String input = "my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b";

//        System.out.println(input);

        System.out.println(solution(input));
    }

    private enum FileType {
        music, images, movies, other;
    }

    public String solution(String S) {

        Map<String, String> extionsMap = extentionsMap();

        String[] fileInfos = S.split("\n");
        Map<String, Integer> result = initResultMap();

        for (String fileInfo : fileInfos) {
            String[] file = fileInfo.split(" ");

            String fileExtensions = fileExtentions(file[0]);
            String fileSize = fileSize(file[1]);
            String type = extionsMap.getOrDefault(fileExtensions, FileType.other.name());

            Integer typeSize = result.getOrDefault(type, 0);
            result.put(type, typeSize + Integer.valueOf(fileSize));
        }

        return result.keySet().stream()
                .map(type -> type + " " + result.get(type) + "b")
                .collect(Collectors.joining("\n"));
    }

    private String fileSize(String s) {
        return s.replace("b", "");
    }

    private String fileExtentions(String fileName1) {
        String fileName = fileName1;
        int dotIndex = fileName.lastIndexOf(".");
        return fileName.substring(dotIndex);
    }

    private Map<String, Integer> initResultMap() {

        Map<String, Integer> result = new LinkedHashMap<>();

        for(FileType type : FileType.values()) {
            result.put(type.name(), 0);
        }

        return result;
    }

    private Map<String, String> extentionsMap() {
        Map<String, String> typeMap = new HashMap<>();

        typeMap.put(".mp3", FileType.music.name());
        typeMap.put(".aac", FileType.music.name());
        typeMap.put(".flac", FileType.music.name());

        typeMap.put(".mp4", FileType.movies.name());
        typeMap.put(".avi", FileType.movies.name());
        typeMap.put(".mkv", FileType.movies.name());

        typeMap.put(".jpg", FileType.images.name());
        typeMap.put(".bmp", FileType.images.name());
        typeMap.put(".gif", FileType.images.name());

        typeMap.put(".7z", FileType.other.name());
        typeMap.put(".txt", FileType.other.name());
        typeMap.put(".zip", FileType.other.name());
        return typeMap;
    }


}

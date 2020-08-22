package com.example.algorithm.questions.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * <p>
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 * <p>
 * 입출력 예
 * participant	completion	return
 * [leo, kiki, eden]	[eden, kiki]	leo
 * [marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
 * [mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
 */
public class Marathon {

    public static void main(String... args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[] {"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}));
    }

    /**
     * @param participant 참가한 선수들 명단
     * @param completion  완주한 선수들 명단
     * @return
     */
    public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> participantPlayers = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            participantPlayers.put(participant[i]
                    , participantPlayers.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            participantPlayers.put(completion[i], participantPlayers.get(completion[i]) - 1);
        }

        String notCompletionPlayer = "";
        for (String player : participantPlayers.keySet()) {
            if(participantPlayers.get(player) > 0) {
                return player;
            }
        }

        return notCompletionPlayer;
    }
}

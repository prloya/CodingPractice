package com.coder.randomQ.solutions;

import java.util.ArrayList;
import java.util.HashMap;

/*
Tournament Winner:
Each win adds 3 points to the score, loses its 0;
Return team with max score;
{
  "competitions": [["HTML", "C#"], ["C#", "Python"], ["Python", "HTML"]],
  "results": [0, 0, 1]
}
Output: Python
{
  "competitions": [["HTML", "Java"], ["Java", "Python"], ["Python", "HTML"]],
  "results": [0, 1, 1]
}
Output: Java
 */
public class TournamentWinner {
    public static void main(String[] args){
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();

        competitions.add(new ArrayList<String> (){{
            add("HTML");
            add("C#");
        }});

        competitions.add(new ArrayList<String>() {{
            add("C#");
            add("Python");
        }});

        competitions.add(new ArrayList<String>() {{
            add("Python");
            add("HTML");
        }});

        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(1);
        results.add(1);

        System.out.println(tournamentWinner(competitions, results));


    }
    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String bestTeam = "";
        HashMap<String, Integer> teams_scores = new HashMap<>();
        int bestScore = 0;
        teams_scores.put(bestTeam,bestScore);
        for(int i = 0; i < competitions.size(); i++){
            ArrayList<String> competition = competitions.get(i);
            String headTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winnerTeam = results.get(i) == 1 ? headTeam : awayTeam;
            teams_scores.put(winnerTeam, teams_scores.getOrDefault(winnerTeam, 0) + 3);
            if(bestScore <= teams_scores.get(winnerTeam)){
                bestScore = teams_scores.get(winnerTeam);
                bestTeam = winnerTeam;
            }

        }
        return bestTeam;

    }
}

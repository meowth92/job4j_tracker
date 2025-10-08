package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double res = 0D;
        int count = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                res += s.score();
                count++;
            }
        }
        return res / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil p : pupils) {
            double scoreSubject = 0D;
            for (Subject s : p.subjects()) {
                scoreSubject += s.score();
            }
            rsl.add(new Label(p.name(), scoreSubject / p.subjects().size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> pupilsMap = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                int score = pupilsMap.getOrDefault(s.name(), 0);
                pupilsMap.put(s.name(), score + s.score());
            }
        }
        for (Map.Entry<String, Integer> map : pupilsMap.entrySet()) {
            int score = map.getValue() / pupils.size();
            rsl.add(new Label(map.getKey(), score));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double scoreSubject = 0D;
            for (Subject subject : pupil.subjects()) {
                scoreSubject += subject.score();
            }
            rsl.add(new Label(pupil.name(), scoreSubject));
            rsl.sort(Comparator.naturalOrder());
        }
        return rsl.get(pupils.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> pupilsMap = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = pupilsMap.getOrDefault(subject.name(), 0);
                pupilsMap.put(subject.name(), score + subject.score());
            }
        }
        for (Map.Entry<String, Integer> map : pupilsMap.entrySet()) {
            rsl.add(new Label(map.getKey(), map.getValue()));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(pupils.size() - 1);
    }
}
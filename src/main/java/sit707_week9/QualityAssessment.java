package sit707_week9;

import java.util.HashMap;
import java.util.Map;

public class QualityAssessment {

    private Map<String, Integer> scores;

    public QualityAssessment() {
        scores = new HashMap<String, Integer>();
    }

    public String assessQuality(String taskId, int points) {
        if (taskId == null) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        if (points < 0 || points > 5) {
            throw new IllegalArgumentException("Points must be between 0 and 5");
        }
        scores.put(taskId, points);
        return "Quality assessed";
    }

    public int getQualityScore(String taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        if (!scores.containsKey(taskId)) {
            return -1;
        }
        return scores.get(taskId);
    }

    public String getQualityScoreLabel(String taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        if (!scores.containsKey(taskId)) {
            return "Not assessed";
        }
        return scores.get(taskId) + " out of 5";
    }
}

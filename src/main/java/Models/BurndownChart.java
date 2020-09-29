package Models;

import java.time.LocalDate;

public class BurndownChart {
    private int totalPoints;
    private LocalDate[] deadlines;
    private int[] scrumPoints;

    public int getTotalPoints() {
        return totalPoints;
    }

    public LocalDate[] getDeadlines() {
        return deadlines;
    }

    public int[] getScrumPoints() {
        return scrumPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setDeadlines(LocalDate[] deadlines) {
        this.deadlines = deadlines;
    }

    public void setScrumPoints(int[] scrumPoints) {
        this.scrumPoints = scrumPoints;
    }
}

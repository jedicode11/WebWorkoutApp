package WebWorkout.project.model;

import WebWorkout.project.dao.Identifiable;

import java.io.Serializable;
import java.time.LocalDate;

public class Workout implements Comparable<Workout>, Identifiable<Long>, Serializable {
    private static final long COMPLETE_WORKOUT = 10;
    private static long nextId = 0;
    private Long id = ++nextId;
    private String title;
    private String creator;
    private LocalDate startDate;
    private String publisher;
    private double workoutRatings;
    private String tags;
    private String description;

    public Workout() {
    }

    public Workout(Long id) {
        this.id = id;
    }

    public Workout(String title, String creator, String publisher, double workoutRatings, String tags) {
        this.title = title;
        this.creator = creator;
        this.publisher = publisher;
        this.workoutRatings = workoutRatings;
        this.tags = tags;
        this.startDate = LocalDate.now();
    }

    public Workout(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getWorkoutRatings() {
        return workoutRatings;
    }

    public void setWorkoutRatings(double workoutRatings) {
        this.workoutRatings = workoutRatings;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", startDate=" + startDate +
                ", publisher='" + publisher + '\'' +
                ", workoutRatings=" + workoutRatings +
                ", tags='" + tags + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workout)) return false;

        Workout workout = (Workout) o;

        return getId() != null ? getId().equals(workout.getId()) : workout.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public int compareTo(Workout o) {
        return 0;
    }

    public void dailyWorkout() {
    }
}
package com.amotek.planningandfeedback.infrastructure.adapter.persistance.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity(name = "Training")
public class TrainingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uuid;

    private String name;

    private String description;

    private Integer participantsCount;

    private Integer maxParticipantsCount;

    @Column(name = "start_date")
    private Date trainingStartDate;

    private String trainingDay;

    private Time trainingTime;

    private Double duration;

    private String coachUuid;

    private String roomUuid;

    public TrainingEntity() {

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String id) {
        this.uuid = id;
    }

    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(Integer participantsCount) {
        this.participantsCount = participantsCount;
    }

    public Integer getMaxParticipantsCount() {
        return maxParticipantsCount;
    }

    public void setMaxParticipantsCount(Integer maxParticipantsCount) {
        this.maxParticipantsCount = maxParticipantsCount;
    }

    public Date getTrainingStartDate() {
        return trainingStartDate;
    }

    public void setTrainingStartDate(Date trainingStartDate) {
        this.trainingStartDate = trainingStartDate;
    }

    public String getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(String trainingDay) {
        this.trainingDay = trainingDay;
    }

    public Time getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(Time trainingTime) {
        this.trainingTime = trainingTime;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getCoachUuid() {
        return coachUuid;
    }

    public void setCoachUuid(String coachUuid) {
        this.coachUuid = coachUuid;
    }

    public String getRoomUuid() {
        return roomUuid;
    }

    public void setRoomUuid(String roomUuid) {
        this.roomUuid = roomUuid;
    }

    public TrainingEntity(String uuid, String name, String description, Integer participantsCount, Integer maxParticipantsCount, Date trainingStartDate, String trainingDay, Time trainingTime, Double duration, String coachUuid, String roomUuid) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.participantsCount = participantsCount;
        this.maxParticipantsCount = maxParticipantsCount;
        this.trainingStartDate = trainingStartDate;
        this.trainingDay = trainingDay;
        this.trainingTime = trainingTime;
        this.duration = duration;
        this.coachUuid = coachUuid;
        this.roomUuid = roomUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

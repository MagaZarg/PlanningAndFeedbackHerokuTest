ALTER TABLE `training`
    CHANGE COLUMN `participantsCount` `participants_count` SMALLINT(6) NULL DEFAULT NULL,
    CHANGE COLUMN `maxParticipantsCount` `max_participants_count` SMALLINT(6) NULL DEFAULT NULL,
    CHANGE COLUMN `startDate` `start_date` TIMESTAMP NULL DEFAULT NULL,
    CHANGE COLUMN `trainingDay` `training_day` VARCHAR(10) NULL DEFAULT NULL,
    CHANGE COLUMN `trainingTime` `training_time` TIME NULL DEFAULT NULL,
    CHANGE COLUMN `coachUuid` `coach_uuid` VARCHAR(36) NULL DEFAULT NULL,
    CHANGE COLUMN `roomUuid` `room_uuid` VARCHAR(36) NULL DEFAULT NULL;

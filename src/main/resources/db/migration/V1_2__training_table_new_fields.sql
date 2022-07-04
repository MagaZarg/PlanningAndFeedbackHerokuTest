ALTER TABLE `training`
    ADD COLUMN `participantsCount`    SMALLINT    NULL AFTER `description`,
    ADD COLUMN `maxParticipantsCount` SMALLINT    NULL AFTER `participantsCount`,
    ADD COLUMN `startDate`            TIMESTAMP   NULL AFTER `maxParticipantsCount`,
    ADD COLUMN `trainingDay`          VARCHAR(10) NULL AFTER `startDate`,
    ADD COLUMN `trainingTime`         TIME        NULL AFTER `trainingDay`,
    ADD COLUMN `duration`             DOUBLE      NULL AFTER `trainingTime`,
    ADD COLUMN `coachUuid`            VARCHAR(36) NULL AFTER `duration`,
    ADD COLUMN `roomUuid`             VARCHAR(36) NULL AFTER `coachUuid`,
    CHANGE COLUMN `id` `uuid` VARCHAR(36) NOT NULL;

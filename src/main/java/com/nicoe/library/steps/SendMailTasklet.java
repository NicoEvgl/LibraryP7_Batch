package com.nicoe.library.steps;

import com.nicoe.library.service.ReminderService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMailTasklet implements Tasklet {
    private final ReminderService reminderService;

    @Autowired
    public SendMailTasklet(ReminderService reminderService) {
        this.reminderService = reminderService;
    }
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws  Exception {
        reminderService.sendReminderMails();
        return RepeatStatus.FINISHED;
    }
}

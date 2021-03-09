package com.nicoe.library.steps;

import com.nicoe.library.proxies.LibraryProxy;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RefreshReservation implements Tasklet {
    private final LibraryProxy libraryProxy;

    @Autowired
    public RefreshReservation(LibraryProxy libraryProxy) { this.libraryProxy = libraryProxy; }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        libraryProxy.refreshReservation();
        return RepeatStatus.FINISHED;
    }
}

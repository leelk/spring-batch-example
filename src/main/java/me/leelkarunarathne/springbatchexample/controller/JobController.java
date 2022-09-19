package me.leelkarunarathne.springbatchexample.controller;

import me.leelkarunarathne.springbatchexample.config.FileDownloder;
import me.leelkarunarathne.springbatchexample.request.DownloadFileRequestDto;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private Job job;

    @Autowired
    private FileDownloder fileDownloder;


    @PostMapping
    public void save(@RequestBody DownloadFileRequestDto downloadFileRequestDto) throws IOException {
        JobParameters JobParameters = new JobParametersBuilder()
                .addString("myParam", downloadFileRequestDto.getMyParam())
                .addLong("currentMills", System.currentTimeMillis())
                .toJobParameters();
        try {
            JobExecution run = jobLauncher.run(job, JobParameters);

        } catch (JobExecutionAlreadyRunningException e) {
            throw new RuntimeException(e);
        } catch (JobRestartException e) {
            throw new RuntimeException(e);
        } catch (JobInstanceAlreadyCompleteException e) {
            throw new RuntimeException(e);
        } catch (JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }


    public JobParameters getJobParameters() {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addString("myParam", "ABSC");
        return jobParametersBuilder.toJobParameters();
    }

}

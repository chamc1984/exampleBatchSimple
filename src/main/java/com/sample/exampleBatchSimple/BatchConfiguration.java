package com.sample.exampleBatchSimple;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private Tasklet1 tasklet1;

    @Autowired
    private Tasklet2 tasklet2;

    @Bean
    public Job myJob(JobBuilderFactory jobs, Step step1, Step step2) {
        return jobs.get("myJob").incrementer(new RunIdIncrementer()).start(step1).next(step2).build();
    }

    @Bean
    public Step step1() {
        return steps.get("step1").tasklet(tasklet1).build();
    }

    @Bean
    public Step step2() {
        return steps.get("step2").tasklet(tasklet2).build();
    }

}

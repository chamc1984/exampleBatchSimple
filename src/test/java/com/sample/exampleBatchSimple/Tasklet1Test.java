package com.sample.exampleBatchSimple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tasklet1Test {

    @Autowired
    private Tasklet1 tasklet1;

    private StepContribution sc;

    private ChunkContext cc;


    /**
     * 特に意味はない。
     */
    @Test
    public void test01() {
        tasklet1.execute(sc, cc);

    }
}

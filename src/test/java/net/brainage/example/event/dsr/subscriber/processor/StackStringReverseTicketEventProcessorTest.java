package net.brainage.example.event.dsr.subscriber.processor;

import net.brainage.example.event.dsr.model.RawData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class StackStringReverseTicketEventProcessorTest {

    @Configuration
    static class TestConfig {
        @Bean
        public StackStringReverseTicketEventProcessor stackStringReverseTicketEventProcessor() {
            return new StackStringReverseTicketEventProcessor();
        }
    }

    @Autowired
    StackStringReverseTicketEventProcessor stackStringReverseTicketEventProcessor;

    @Test
    public void test_process() {
        RawData inputData = new RawData(1, "T", "ABCDEFG", false);
        RawData outputData = stackStringReverseTicketEventProcessor.process(inputData);

        assertThat(outputData.getId(), is(inputData.getId()));
        assertThat(outputData.getType(), is(inputData.getType()));
        assertThat(outputData.isNeedCtrip(), is(inputData.isNeedCtrip()));
        assertThat(outputData.getData(), is("GFEDCBA"));

        assertThat(outputData, is(not(inputData)));
    }

}

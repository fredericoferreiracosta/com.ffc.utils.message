package com.ffc.utils.message.holidaymessageimpl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

import com.ffc.utils.message.waitingservice.WaitingMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link HolidayMessageImpl}.
 */
public class HolidayMessageImplTest {

    private HolidayMessageImpl myHolidayMessageImpl;
    private static final String PORTUGUESE = "pt-BR";

    @BeforeEach
    public void setUp() {
        myHolidayMessageImpl = new HolidayMessageImpl();
    }

    @Test
    void shouldGetWaitingMessageWhenLanguageIsPortugueseForDecember() {
        // TODO: Mock december

        WaitingMessage waitingMessage = myHolidayMessageImpl.getWaitMessage(PORTUGUESE);

        assertThat(waitingMessage, notNullValue());
        assertThat(waitingMessage.getLanguage(), equalTo(PORTUGUESE));
        assertThat(waitingMessage.getMessage(), is(not(emptyOrNullString())));
    }
}
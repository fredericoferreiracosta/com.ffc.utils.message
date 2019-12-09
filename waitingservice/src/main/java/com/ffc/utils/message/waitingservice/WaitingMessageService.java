package com.ffc.utils.message.waitingservice;

/**
 * Wait message API.
 */
public interface WaitingMessageService {
    /**
     * Generates a random waiting message so it can be used to display to the user.
     * @return
     */
    WaitingMessage getWaitMessage(String language);
}

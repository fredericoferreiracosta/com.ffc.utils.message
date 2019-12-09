package com.ffc.utils.message.integrationtest;

import com.ffc.utils.message.waitingservice.WaitingMessageService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * This will use the waiting service bundle and will print some messages on the console.
 * Despite test being the name, this is actually a bundle and the console test will run
 * inside the @Activate method.
 */
@Component (immediate = true)
public class ConsoleTest {
    private WaitingMessageService myWaitingMessageService;
    private static final String PORTUGUESE = "pt-BR";

    @Activate
    public void activate() {
        System.out.println("ConsoleTest bundle is running. Tests will start: ");

        System.out.println(myWaitingMessageService.getWaitMessage(PORTUGUESE).getMessage());
        System.out.println(myWaitingMessageService.getWaitMessage(PORTUGUESE).getMessage());
        System.out.println(myWaitingMessageService.getWaitMessage(PORTUGUESE).getMessage());
        System.out.println(myWaitingMessageService.getWaitMessage(PORTUGUESE).getMessage());
        System.out.println(myWaitingMessageService.getWaitMessage(PORTUGUESE).getMessage());
        System.out.println(myWaitingMessageService.getWaitMessage(PORTUGUESE).getMessage());
        System.out.println(myWaitingMessageService.getWaitMessage(PORTUGUESE).getMessage());
        System.out.println(myWaitingMessageService.getWaitMessage(PORTUGUESE).getMessage());
        System.out.println(myWaitingMessageService.getWaitMessage(PORTUGUESE).getMessage());
    }

    @Reference
    public void setWaitingMessageService(WaitingMessageService waitingMessageService) {
        myWaitingMessageService = waitingMessageService;
    }
}

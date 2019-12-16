package com.ffc.utils.message.defaultmessageimpl;

import com.ffc.utils.message.waitingservice.WaitingMessage;
import com.ffc.utils.message.waitingservice.WaitingMessageService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component (immediate = true, service = WaitingMessageService.class)
public class DefaultMessageImpl implements WaitingMessageService {

    private static final String PORTUGUSE = "pt-BR";
    private static final String ENGLISH = "en-US";

    @Activate
    public void activate() {
        System.out.println("Default message running...");
    }

    @Override
    public WaitingMessage getWaitMessage(String language) {
        if (PORTUGUSE.equals(language)) {
            return new WaitingMessage(PORTUGUSE, "Aguarde...");
        } else if (ENGLISH.equals(language)) {
            return new WaitingMessage(ENGLISH, "Loading...");
        }

        return null;
    }
}

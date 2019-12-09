package com.ffc.utils.message.holidaymessageimpl;

import com.ffc.utils.message.waitingservice.WaitingMessage;
import com.ffc.utils.message.waitingservice.WaitingMessageService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Component (immediate = true, service = WaitingMessageService.class)
public class HolidayMessageImpl implements WaitingMessageService {

    private static final Map<Month, List<WaitingMessage>> MESSAGES_BY_MONTH = buildMessages();

    @Activate
    public void activate() {
        System.out.println("HolidayMessage bundle running...");
    }

    @Override
    public WaitingMessage getWaitMessage(String language) {

        LocalDate currentDate = LocalDate.now();
        Random random = new Random();

        List<WaitingMessage> currentMonthMessagesByLanguage = MESSAGES_BY_MONTH.get(currentDate.getMonth()).stream()
                .filter(message -> language.equals(message.getLanguage()))
                .collect(Collectors.toList());

        return currentMonthMessagesByLanguage.get(random.nextInt(currentMonthMessagesByLanguage.size()));
    }

    private static Map<Month, List<WaitingMessage>> buildMessages() {
        Map<Month, List<WaitingMessage>> messages = new HashMap<>();

        messages.put(Month.JANUARY, Arrays.asList(
                new WaitingMessage("pt-BR", "Feliz ano novo!")
        ));
        messages.put(Month.FEBRUARY, Arrays.asList(
                new WaitingMessage("pt-BR", "Nada especial este mês")
        ));
        messages.put(Month.MARCH, Arrays.asList(
                new WaitingMessage("pt-BR", "Nada especial este mês")
        ));
        messages.put(Month.APRIL, Arrays.asList(
                new WaitingMessage("pt-BR", "Nada especial este mês")
        ));
        messages.put(Month.MAY, Arrays.asList(
                new WaitingMessage("pt-BR", "Feliz dia das mães")
        ));
        messages.put(Month.JUNE, Arrays.asList(
                new WaitingMessage("pt-BR", "Nada especial este mês")
        ));
        messages.put(Month.JULY, Arrays.asList(
                new WaitingMessage("pt-BR", "Nada especial este mês")
        ));
        messages.put(Month.AUGUST, Arrays.asList(
                new WaitingMessage("pt-BR", "Feliz dia dos pais")
        ));
        messages.put(Month.SEPTEMBER, Arrays.asList(
                new WaitingMessage("pt-BR", "Nada especial este mês")
        ));
        messages.put(Month.OCTOBER, Arrays.asList(
                new WaitingMessage("pt-BR", "Nada especial este mês")
        ));
        messages.put(Month.NOVEMBER, Arrays.asList(
                new WaitingMessage("pt-BR", "Nada especial este mês")
        ));
        messages.put(Month.DECEMBER, Arrays.asList(
                new WaitingMessage("pt-BR", "Feliz natal!")
        ));

        return messages;
    }
}

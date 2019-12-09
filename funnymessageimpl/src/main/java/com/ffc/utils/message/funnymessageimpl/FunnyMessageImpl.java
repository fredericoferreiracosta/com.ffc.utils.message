package com.ffc.utils.message.funnymessageimpl;

import com.ffc.utils.message.waitingservice.WaitingMessage;
import com.ffc.utils.message.waitingservice.WaitingMessageService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component (immediate = true, service = WaitingMessageService.class)
public class FunnyMessageImpl implements WaitingMessageService {

    private static final List<WaitingMessage> MESSAGES = Arrays.asList(
            new WaitingMessage("pt-BR", "Você prefere frango, bife ou tofu?"),
            new WaitingMessage("pt-BR", "Aguarde enquanto fazemos o trabalho duro..."),
            new WaitingMessage("pt-BR", "Estamos verificando a constante gravitacional em sua localidade..."),
            new WaitingMessage("pt-BR", "Respire fundo..."),
            new WaitingMessage("pt-BR", "O servidor é alimentado por um limão e dois eletrodos."),
            new WaitingMessage("pt-BR", "Estamos testando sua paciência..."),
            new WaitingMessage("pt-BR", "Não pense em hipopótamos roxos..."),
            new WaitingMessage("pt-BR", "Siga o coelho branco..."),
            new WaitingMessage("pt-BR", "Por que você não pede um sanduíche?"),
            new WaitingMessage("pt-BR", "Que tal um café?"),
            new WaitingMessage("pt-BR", "Aguarde enquanto nosso satélite se move para a posição correta..."),
            new WaitingMessage("pt-BR", "Os bits estão fluindo lentamente hoje..."),
            new WaitingMessage("pt-BR", "Isso vai ser mais rápido do que você pensa..."),
            new WaitingMessage("pt-BR", "Você é impaciente?"),
            new WaitingMessage("pt-BR", "A última vez que tentei isso, o macaco não sobreviveu. Esperemos que funcione melhor desta vez."),
            new WaitingMessage("pt-BR", "Você esperava ler uma mensagem engraçada aqui?"),
            new WaitingMessage("pt-BR", "Teste de Paciência ....... FALHA"),
            new WaitingMessage("pt-BR", "Esquentando os processadores... espere, o que?"),
            new WaitingMessage("pt-BR", "Reconfigurando a máquina de café..."),
            new WaitingMessage("pt-BR", "Programa carregado, por favor, entre com a raiz quadrada de 598309209839 para continuar:"),
            new WaitingMessage("pt-BR", "Por favor, não se mexa..."),
            new WaitingMessage("pt-BR", "Conte até 10..."),
            new WaitingMessage("pt-BR", "Você está pronto?"),
            new WaitingMessage("pt-BR", "Por que você está tão sério hoje?"),
            new WaitingMessage("pt-BR", "Cuidado onde você aponta esse mouse..."),
            new WaitingMessage("pt-BR", "Levando você para o futuro..."),
            new WaitingMessage("pt-BR", "Computando chances de sucesso...")
    );

    @Activate
    public void activate() {
        System.out.println("Funny message bundle is running...");
    }

    @Override
    public WaitingMessage getWaitMessage(String language) {
        if (language == null) {
            return null;
        }

        Random random = new Random();
        List<WaitingMessage> processedMessages = MESSAGES.stream()
                .filter(message -> language.equals(message.getLanguage()))
                .collect(Collectors.toList());

        return processedMessages.get(random.nextInt(processedMessages.size()));
    }
}

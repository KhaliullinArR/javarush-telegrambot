package com.github.javarushcommunityjrtb;

import com.github.javarushcommunityjrtb.bot.JavaRushTelegramBot;
import com.github.javarushcommunityjrtb.service.SendBotMessageImpl;
import com.github.javarushcommunityjrtb.service.SendBotMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;

    private JavaRushTelegramBot javaRushTelegramBot;

    @BeforeEach
    public void init() {
        javaRushTelegramBot = Mockito.mock(JavaRushTelegramBot.class);
        sendBotMessageService = new SendBotMessageImpl(javaRushTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage()  throws TelegramApiException{
        String chat_id = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chat_id);
        sendMessage.enableHtml(true);



        sendBotMessageService.sendMessage(chat_id, message);

        Mockito.verify(javaRushTelegramBot).execute(sendMessage);
    }
}

package com.github.javarushcommunityjrtb;

import com.github.javarushcommunityjrtb.bot.JavaRushTelegramBot;
import com.github.javarushcommunityjrtb.command.Command;
import com.github.javarushcommunityjrtb.service.SendBotMessageImpl;
import com.github.javarushcommunityjrtb.service.SendBotMessageService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class AbstractCommandTest {
    protected JavaRushTelegramBot javaRushTelegramBot = Mockito.mock(JavaRushTelegramBot.class);

    protected SendBotMessageService sendBotMessageService = new SendBotMessageImpl(javaRushTelegramBot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chat_id = 1234345365L;

        Update update = new Update();

        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chat_id);
        Mockito.when(message.getText()).thenReturn(getCommandMessage());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(javaRushTelegramBot).execute(sendMessage);
    }
}

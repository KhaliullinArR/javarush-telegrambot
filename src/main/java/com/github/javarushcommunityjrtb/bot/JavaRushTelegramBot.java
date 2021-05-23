package com.github.javarushcommunityjrtb.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String name;

    @Value("${bot.token}")
    private String token;

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){

            String message = update.getMessage().getText().trim();
            String chat_id = update.getMessage().getChatId().toString();

            System.out.println(message);

            SendMessage sm = new SendMessage();
            sm.setText("message");
            sm.setChatId(chat_id);

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }
}

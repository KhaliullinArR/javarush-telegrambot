package com.github.javarushcommunityjrtb.bot;

import com.github.javarushcommunityjrtb.command.CommandContainer;
import com.github.javarushcommunityjrtb.service.SendBotMessageImpl;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import static com.github.javarushcommunityjrtb.bot.CommandName.*;

@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {
    public static final String COMMAND_PREFIX = "/";

    private final CommandContainer commandContainer;

    public JavaRushTelegramBot() {
        commandContainer = new CommandContainer(new SendBotMessageImpl(this));
    }


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
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if(message.startsWith(COMMAND_PREFIX)){
                commandContainer.retrieveCommand(message).execute(update);
            }else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
                //commandContainer.retrieveCommand(HELP.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }
}

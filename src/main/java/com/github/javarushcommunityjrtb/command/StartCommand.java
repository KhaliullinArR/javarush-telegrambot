package com.github.javarushcommunityjrtb.command;

import com.github.javarushcommunityjrtb.command.Command;
import com.github.javarushcommunityjrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String START_MESSAGE = "Привет. Я Javarush Telegram Bot. Я помогу тебе быть в курсе последних " +
            "статей тех авторов, котрые тебе интересны. Я еще маленький и только учусь.";



    public StartCommand(SendBotMessageService sendBotMessageService) {

        this.sendBotMessageService = sendBotMessageService;
    }



    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}

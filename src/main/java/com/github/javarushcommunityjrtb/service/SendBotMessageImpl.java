package com.github.javarushcommunityjrtb.service;

import com.github.javarushcommunityjrtb.bot.JavaRushTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

@Service
public class SendBotMessageImpl implements SendBotMessageService{

    private final JavaRushTelegramBot javaRushTelegramBot;

    @Autowired
    public SendBotMessageImpl(JavaRushTelegramBot javaRushTelegramBot) {
        this.javaRushTelegramBot = javaRushTelegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);



        /*SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        InputFile inputFile = new InputFile();
        inputFile.setMedia(new File("src/main/resources/images/Evil_Omni-Man.png"));
        sendPhoto.setPhoto(inputFile);*/


        try {
            javaRushTelegramBot.execute(sendMessage);
//            javaRushTelegramBot.execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}

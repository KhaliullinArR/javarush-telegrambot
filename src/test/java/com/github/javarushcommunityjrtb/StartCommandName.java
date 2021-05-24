package com.github.javarushcommunityjrtb;

import com.github.javarushcommunityjrtb.command.Command;
import com.github.javarushcommunityjrtb.command.StartCommand;

import static com.github.javarushcommunityjrtb.bot.CommandName.*;

public class StartCommandName extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StartCommand.START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}

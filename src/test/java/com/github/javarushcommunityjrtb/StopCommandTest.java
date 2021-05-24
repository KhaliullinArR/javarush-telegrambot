package com.github.javarushcommunityjrtb;

import static com.github.javarushcommunityjrtb.bot.CommandName.*;
import com.github.javarushcommunityjrtb.command.Command;
import com.github.javarushcommunityjrtb.command.StopCommand;

public class StopCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StopCommand.STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}

package com.github.javarushcommunityjrtb;

import static com.github.javarushcommunityjrtb.bot.CommandName.*;
import com.github.javarushcommunityjrtb.command.Command;
import com.github.javarushcommunityjrtb.command.NoCommand;

public class NoCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NoCommand.NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}

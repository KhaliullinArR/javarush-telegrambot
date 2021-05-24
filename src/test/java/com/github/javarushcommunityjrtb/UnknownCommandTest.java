package com.github.javarushcommunityjrtb;

import static com.github.javarushcommunityjrtb.bot.CommandName.*;
import com.github.javarushcommunityjrtb.command.Command;
import com.github.javarushcommunityjrtb.command.UnknownCommand;

public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/dafsd";
    }

    @Override
    String getCommandMessage() {
        return UnknownCommand.UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}

package com.github.javarushcommunityjrtb;

import static com.github.javarushcommunityjrtb.bot.CommandName.*;
import com.github.javarushcommunityjrtb.command.Command;
import com.github.javarushcommunityjrtb.command.HelpCommand;

public class HelpCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HelpCommand.HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}

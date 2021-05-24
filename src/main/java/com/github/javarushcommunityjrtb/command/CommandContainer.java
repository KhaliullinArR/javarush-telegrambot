package com.github.javarushcommunityjrtb.command;

import com.github.javarushcommunityjrtb.service.SendBotMessageImpl;
import com.github.javarushcommunityjrtb.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.github.javarushcommunityjrtb.bot.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;

    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new StartCommand(sendBotMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}

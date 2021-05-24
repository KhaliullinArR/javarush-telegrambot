package com.github.javarushcommunityjrtb;

import com.github.javarushcommunityjrtb.bot.CommandName;
import com.github.javarushcommunityjrtb.command.Command;
import com.github.javarushcommunityjrtb.command.CommandContainer;
import com.github.javarushcommunityjrtb.command.UnknownCommand;
import com.github.javarushcommunityjrtb.service.SendBotMessageImpl;
import com.github.javarushcommunityjrtb.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for Command container")
public class CommandContainerTest {
    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        commandContainer = new CommandContainer(Mockito.mock(SendBotMessageService.class));
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values()).
                forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        String unknownCommand = "/adsfd";

        Command command = commandContainer.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }

}

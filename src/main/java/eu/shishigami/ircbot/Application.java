package eu.shishigami.ircbot;

import eu.shishigami.ircbot.bot.Bot;

import java.util.Properties;

public class Application {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("name", "LoLBotDerp");
        properties.setProperty("server", "irc.dk.quakenet.org");
        properties.setProperty("channel", "#shishi0123");

        Bot bot = new Bot(properties);
    }

}

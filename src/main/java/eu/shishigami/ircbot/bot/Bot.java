package eu.shishigami.ircbot.bot;

import eu.shishigami.ircbot.api.SummonerProvider;
import eu.shishigami.ircbot.model.Summoner;
import org.jibble.pircbot.PircBot;

import java.util.Properties;

public class Bot extends PircBot {

    private SummonerProvider summonerProvider = new SummonerProvider();

    private String name;
    private String server;
    private String channel;

    public Bot(Properties properties) throws Exception {
        this.name = properties.getProperty("name");
        this.server = properties.getProperty("server");
        this.channel = properties.getProperty("channel");

        setName(name);
        connect(server);
        joinChannel(channel);
    }

    @Override
    protected void onMessage(String channel, String sender, String login, String hostname, String message) {
        if (message.startsWith("!summoner")) {
            String region = message.split(" ")[1];
            String name = message.split(" ")[2];

            try {
                Summoner summoner = summonerProvider.byName(region, name);
                sendMessage(channel, summoner.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

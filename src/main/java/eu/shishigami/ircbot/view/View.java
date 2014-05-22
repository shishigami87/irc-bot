package eu.shishigami.ircbot.view;

import eu.shishigami.ircbot.bot.Bot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class View {

    private static final String TITLE = "LoL IRC Bot";

    private JFrame frame;
    private JButton startButton;

    private Bot bot;

    public View() {
        frame = new JFrame(TITLE);
        frame.setSize(200, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initializeComponents();

        frame.setVisible(true);
    }

    private void initializeComponents() {
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Properties properties = new Properties();
                    properties.setProperty("name", "LoLBotDerp");
                    properties.setProperty("server", "irc.dk.quakenet.org");
                    properties.setProperty("channel", "#shishi0123");

                    bot = new Bot(properties);

                    startButton.setEnabled(false);
                    startButton.setText("Started");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        frame.getContentPane().add(startButton);
    }

}

package eu.shishigami.ircbot.api;

import eu.shishigami.ircbot.Configuration;
import eu.shishigami.ircbot.model.Summoner;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SummonerProvider {

    public Summoner byName(String region, String name) throws Exception {
        String strUrl = "https://prod.api.pvp.net/api/lol/" + region + "/v1.4/summoner/by-name/" + name + "?api_key=" + Configuration.API_KEY;
        URL url = new URL(strUrl);
        URLConnection urlConnection = url.openConnection();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();

        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());

        /*
            {
              "shishigami": {
                "id": 19025866,
                "name": "Shishigami",
                "profileIconId": 567,
                "summonerLevel": 30,
                "revisionDate": 1400318848000
              }
            }
        */

        String firstKey = (String) jsonObject.keySet().toArray()[0];
        jsonObject = jsonObject.getJSONObject(firstKey);

        Summoner summoner = new Summoner();
        summoner.setId(jsonObject.getLong("id"));
        summoner.setName(jsonObject.getString("name"));
        summoner.setProfileIconId(jsonObject.getLong("profileIconId"));
        summoner.setSummonerLevel(jsonObject.getInt("summonerLevel"));

        return summoner;
    }

}

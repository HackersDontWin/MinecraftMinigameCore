package net.hackersdontwin.minecraftminigamecore;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {

    private Main plugin;

    private Map<Integer, Game> games = new HashMap<>();
    private Map<Player, Integer> playersPlaying = new HashMap<>();

    public GameManager(Main plugin) {
        this.plugin = plugin;
    }

    public void newGame(int ID) {
        Game game = new Game(plugin, ID);
        games.put(ID, game);
    }

    public void removeGame(int ID) {
        games.remove(ID);
    }

    public boolean doesGameExist(int ID) {
        if(games.containsKey(ID)) {
            return true;
        }
        return false;
    }

    public void sendMessageToGame(int ID, String msg) {
        Game game = games.get(ID);
        game.sendMessage(msg);
    }

    public Game getGame(int ID) {
        return games.get(ID);
    }

    public boolean isPlayerPlaying(Player player) {
        if(playersPlaying.containsKey(player)) {
            return true;
        }
        return false;
    }

    public void removePlayerFromPlayingList(Player player) {
        playersPlaying.remove(player);
    }

    public void addPlayerToPlayingList(Player player, int ID) {
        playersPlaying.put(player, ID);
    }

    public Map<Player, Integer> getPlayersPlaying() {
        return playersPlaying;
    }

}

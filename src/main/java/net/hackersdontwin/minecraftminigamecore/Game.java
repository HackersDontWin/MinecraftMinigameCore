package net.hackersdontwin.minecraftminigamecore;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Main plugin;

    private int ID;
    private List<Player> players = new ArrayList<>();

    public Game(Main plugin, int ID) {
        this.plugin = plugin;
        this.ID = ID;
    }

    public void addPlayer(Player player) {
        players.add(player);
        plugin.getGameManager().addPlayerToPlayingList(player, ID);
    }

    public void removePlayer(Player player) {
        players.remove(player);
        plugin.getGameManager().removePlayerFromPlayingList(player);
    }

    public boolean isPlayerInGame(Player player) {
        if(players.contains(player)) {
            return true;
        }

        return false;
    }

    public void sendMessage(String msg) {
        for(Player player : players) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[GAME MESSAGE] &7" + msg));
        }
    }

    public int getID() {
        return ID;
    }
}

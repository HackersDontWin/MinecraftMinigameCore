package net.hackersdontwin.minecraftminigamecore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeaveGameCMD implements CommandExecutor {

    private Main plugin;

    public LeaveGameCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to do this!");
            return true;
        }

        Player player = (Player) sender;

        if(!plugin.getGameManager().isPlayerPlaying(player)) {
            player.sendMessage(ChatColor.RED + "You are currently not in a game!");
            return true;
        }

        int gameID = plugin.getGameManager().getPlayersPlaying().get(player);
        Game game = plugin.getGameManager().getGame(gameID);
        game.removePlayer(player);

        player.sendMessage(ChatColor.GREEN + "You have left the game!");
        game.sendMessage("&b" + player.getName() + " &7has left the game!");

        return true;
    }
}

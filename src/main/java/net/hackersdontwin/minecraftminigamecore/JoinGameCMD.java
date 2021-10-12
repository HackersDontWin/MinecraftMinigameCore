package net.hackersdontwin.minecraftminigamecore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinGameCMD implements CommandExecutor {

    private Main plugin;

    public JoinGameCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.GREEN + "You have to be a player to do this!");
            return true;
        }

        Player player = (Player) sender;

        if(args.length != 1) {
            player.sendMessage(ChatColor.RED + "Incorrect command usage! Use: /joingame <ID>");
            return true;
        }

        int ID;
        try {
            ID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            player.sendMessage(ChatColor.RED + "The ID must be an integer!");
            return true;
        }

        if(plugin.getGameManager().isPlayerPlaying(player)) {
            player.sendMessage(ChatColor.RED + "You are currently already in a game! You must leave your game before joining another one!");
            return true;
        }

        if (plugin.getGameManager().doesGameExist(ID)) {
            plugin.getGameManager().getGame(ID).addPlayer(player);
            plugin.getGameManager().getGame(ID).sendMessage("&b" + player.getName() + " &7has joined the game!");
        } else {
            player.sendMessage(ChatColor.RED + "A game with ID " + ID + " doesn't exist!");
        }
        return true;
    }
}

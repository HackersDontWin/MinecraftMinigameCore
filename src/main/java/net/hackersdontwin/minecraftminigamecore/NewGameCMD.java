package net.hackersdontwin.minecraftminigamecore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NewGameCMD implements CommandExecutor {

    private Main plugin;

    public NewGameCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Incorrect command usage! Use: /newgame <ID>");
            return true;
        }

        int ID;
        try {
            ID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "The ID must be an integer!");
            return true;
        }

        plugin.getGameManager().newGame(ID);
        sender.sendMessage(ChatColor.GREEN + "A new game with the ID " + ID + " has been created!");

        return true;
    }
}

package net.hackersdontwin.minecraftminigamecore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class SendGameMessageCMD implements CommandExecutor {

    private Main plugin;

    public SendGameMessageCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(args.length >= 2)) {
            sender.sendMessage(ChatColor.RED + "Incorrect command usage! Use: /gamemsg <ID> <message>");
            return true;
        }

        int ID;
        try {
            ID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "The ID must be an integer!");
            return true;
        }
        List<String> stringargs = new ArrayList<>();
        for(int i = 1; i < args.length; i++) {
            stringargs.add(args[i]);
        }
        String message = String.join(" ", stringargs);

        plugin.getGameManager().getGame(ID).sendMessage(message);
        sender.sendMessage(ChatColor.GREEN + "You sent the message: " + ChatColor.translateAlternateColorCodes('&', message));

        return true;
    }
}

package net.hackersdontwin.minecraftminigamecore;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private GameManager gameManager;

    @Override
    public void onEnable() {
        gameManager = new GameManager(this);

        getCommand("newgame").setExecutor(new NewGameCMD(this));
        getCommand("joingame").setExecutor(new JoinGameCMD(this));
        getCommand("leavegame").setExecutor(new LeaveGameCMD(this));
        getCommand("gamemsg").setExecutor(new SendGameMessageCMD(this));
    }

    public GameManager getGameManager() {
        return gameManager;
    }
}

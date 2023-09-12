package dev.beabueno.wisteriaessentials.commands.tabs;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/* This TabCompletion class adds a Name Tab completion for Player names in the argpos position of the command. */

public class PlayerNameTab implements TabCompleter {
    private final int argpos;
    public PlayerNameTab() {
        argpos = 0;
    }
    public PlayerNameTab(int argpos) {
        this.argpos = argpos;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == argpos + 1) {
            List<String> names = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                names.add(player.getName());
            }
            return StringUtil.copyPartialMatches(args[argpos], names, new ArrayList<>());
        }
        return null;
    }
}

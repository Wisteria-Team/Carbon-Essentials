package dev.beabueno.wisteriaessentials.commands.tabs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class GamemodeTab implements TabCompleter {
    private final List<String> opts;
    public GamemodeTab() {
        opts = new ArrayList<>();
        opts.add("survival");
        opts.add("creative");
        opts.add("spectator");
        opts.add("adventure");
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0],opts,new ArrayList<>());
        }
        return null;
    }
}

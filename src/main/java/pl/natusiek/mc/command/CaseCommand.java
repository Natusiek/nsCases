package pl.natusiek.mc.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.natusiek.mc.CasePlugin;
import pl.natusiek.mc.helper.ColorHelper;
import pl.natusiek.mc.helper.ItemBuilder;

import static pl.natusiek.mc.helper.ColorHelper.colored;

public class CaseCommand implements CommandExecutor {

    public static void Case(Player p, int ilosc) { p.getInventory().addItem( new ItemStack[] {new ItemBuilder(Material.ENDER_CHEST).withAmount(ilosc).withName("&6Magiczna Skrzynia").build() }); }

    public CaseCommand(CasePlugin plugin) {
        plugin.getCommand("case").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = ((Player) sender);
        if (!p.hasPermission("natusiek.case")) {
            p.sendMessage(colored(" &4Sorki! &fAle nie masz uprawnien!"));
            return false;
        }
        if (args.length != 2) {
            p.sendMessage(colored("&4Sorki! &fAle zle uzywasz komendy!"));
            p.sendMessage(colored("    &4Uzycie: &7/case all/player ilosc"));
            return false;
        }
        Player b = Bukkit.getPlayer(args[0]);
        if (!args[0].equalsIgnoreCase("all")) {
            if (b == null) {
                p.sendMessage(colored("&4Sorki! &fAle gracz jest offline"));
            }
            Case(b, Integer.parseInt(args[1]));
            b.sendMessage(colored("&fOtrzymales &a" + Integer.parseInt(args[1]) + " &6Magicznych skrzyn od gracza" + p.getName()));
        }
        if (args[0].equalsIgnoreCase("all")) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                Case(all, Integer.parseInt(args[1]));
                all.sendMessage(colored("&7Caly serwer otrzymal &a"+ Integer.parseInt(args[1]) + " &6Magicznych skrzyn!"));
            }
        }
        return true;
    }
}

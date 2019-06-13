package pl.natusiek.mc.helper;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class ColorHelper {

    public static String colored(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> colored(List<String> texts) {
        return texts.stream()
                .map(ColorHelper::colored)
                .collect(Collectors.toList());
    }
}

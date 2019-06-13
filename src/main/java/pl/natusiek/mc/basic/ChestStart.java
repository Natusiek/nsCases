package pl.natusiek.mc.basic;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.natusiek.mc.helper.ItemBuilder;

import static pl.natusiek.mc.helper.ColorHelper.colored;

public class ChestStart {

    private static Inventory inv;

    public static ItemStack grey = new ItemBuilder(Material.STAINED_GLASS_PANE).withName("&8*").build();
    public static ItemStack en2der = new ItemBuilder(Material.ENDER_CHEST).withName("&6* &fKLIKNIJ ABY OTWORZYC!").build();

    public static Inventory getInventory() {
        if(inv == null) update();
        return inv;
    }

    public static void update() {
        if (inv == null) { inv = Bukkit.createInventory(null, 27, colored("&6Magiczna Skrzynia")); }

        inv.setItem(0, grey);
        inv.setItem(1, grey);
        inv.setItem(2, grey);

        inv.setItem(6, grey);
        inv.setItem(7, grey);
        inv.setItem(8, grey);

        inv.setItem(9, grey);
        inv.setItem(10, grey);
        inv.setItem(11, grey);

        inv.setItem(13, en2der);

        inv.setItem(15, grey);
        inv.setItem(16, grey);
        inv.setItem(17, grey);

        inv.setItem(18, grey);
        inv.setItem(19, grey);
        inv.setItem(20, grey);

        inv.setItem(24, grey);
        inv.setItem(25, grey);
        inv.setItem(26, grey);
    }
}
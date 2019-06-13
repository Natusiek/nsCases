package pl.natusiek.mc;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import pl.natusiek.mc.command.CaseCommand;
import pl.natusiek.mc.listener.BlockPlace;
import pl.natusiek.mc.listener.InventoryClick;

import java.util.ArrayList;
import java.util.Random;

public final class CasePlugin extends JavaPlugin {

    private static CasePlugin inst;

    private static ArrayList<ItemStack> drops = new ArrayList<>();
    private static Random random = new Random();

    @Override
    public void onEnable() {
        inst = this;

        new CaseCommand(this);

        this.getServer().getPluginManager().registerEvents(new BlockPlace(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryClick(), this);

        drops.add(new ItemStack(Material.POTION, 1, (short) 8193));
        drops.add(new ItemStack(Material.GOLDEN_APPLE, 1, (short)1));
        drops.add(new ItemStack(Material.POTION, 1, (short) 8226));
        drops.add(new ItemStack(Material.COBBLESTONE, 1));
        drops.add(new ItemStack(Material.POTION, 1, (short) 8259));
        drops.add(new ItemStack(Material.ENDER_PEARL, 3));
        drops.add(new ItemStack(Material.POTION, 1, (short) 8234));
        drops.add(new ItemStack(Material.GOLDEN_APPLE, 2));
        drops.add(new ItemStack(Material.GOLDEN_APPLE, 6, (short)1));
        drops.add(new ItemStack(Material.COBBLESTONE, 32));
        drops.add(new ItemStack(Material.ENDER_PEARL, 1));
    }

    public static ItemStack random() { return drops.get(random.nextInt(drops.size())); }

    public static CasePlugin getInstance() { return inst; }
}

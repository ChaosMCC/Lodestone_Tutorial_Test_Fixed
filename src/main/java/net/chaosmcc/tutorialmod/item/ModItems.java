package net.chaosmcc.tutorialmod.item;

import net.chaosmcc.tutorialmod.Tutorialmod;
import net.chaosmcc.tutorialmod.custome.LodestoneDI;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // Create an instance of LodestoneWandItem with appropriate settings
    public static final Item LDI = new LodestoneDI.LodeStoneDI(new Item.Settings());

    public static void  registerItem() {
        // Register the item with the registry
        Registry.register(Registries.ITEM, new Identifier(Tutorialmod.MOD_ID, "ldi"), LDI);
    }


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        // Add the item to the INGREDIENTS item group
        entries.add(LDI);

    }

    public static Item registerItem(String name, Item item) {
        // Register the item with a given name
        return Registry.register(Registries.ITEM, new Identifier(Tutorialmod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Tutorialmod.LOGGER.info("Registering Mod Items for " + Tutorialmod.MOD_ID);
        // Register the item
        registerItem();

        // Modify the INGREDIENTS item group to include the mod item
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
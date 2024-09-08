package net.chaosmcc.tutorialmod.item;

import net.chaosmcc.tutorialmod.Tutorialmod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class  ModItemGroups {

    public static final ItemGroup LDI_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Tutorialmod.MOD_ID, "ldi"),
            FabricItemGroup.builder().displayName(Text.translatable("LDI"))
                    .icon(() -> new ItemStack(ModItems.LDI)).entries((displayContext, entries) -> {

                        entries.add(ModItems.LDI);


                    }).build());







    public static void registerItemGroups() {
        Tutorialmod.LOGGER.info( "Registering Item Groups for " +Tutorialmod.MOD_ID);
    }
}

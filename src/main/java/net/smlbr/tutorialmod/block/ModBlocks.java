package net.smlbr.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.smlbr.tutorialmod.TutorialMod;
import net.smlbr.tutorialmod.item.ModItemGroup;

public class ModBlocks {

    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()),
            ModItemGroup.TANZANITE);
    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore",
            new OreBlock(
                    FabricBlockSettings.of(Material.STONE)
                            .strength(4f)
                            .requiresTool(),
                    UniformIntProvider.create(5, 10)
            )
            , ModItemGroup.TANZANITE);
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore",
            new OreBlock(
                    FabricBlockSettings.of(Material.STONE)
                            .strength(4f)
                            .requiresTool(),
                    UniformIntProvider.create(5, 10)
            )
            , ModItemGroup.TANZANITE);
    public static final Block ENDSTONE_TANZANITE_ORE = registerBlock("endstone_tanzanite_ore",
            new OreBlock(
                    FabricBlockSettings.of(Material.STONE)
                            .strength(4f)
                            .requiresTool(),
                    UniformIntProvider.create(5, 10)
            )
            , ModItemGroup.TANZANITE);
    public static final Block NETHER_TANZANITE_ORE = registerBlock("nether_tanzanite_ore",
            new OreBlock(
                    FabricBlockSettings.of(Material.STONE)
                            .strength(4f)
                            .requiresTool(),
                    UniformIntProvider.create(5, 10)
            )
            , ModItemGroup.TANZANITE);

    public static Block registerBlock(
            String name,
            Block block,
            ItemGroup tab
    ) {
        registerBlockItem(name, block, tab);
        return Registry.register(
                Registry.BLOCK,
                new Identifier(TutorialMod.TUTORIALMOD_ID, name),
                block
        );
    }

    /**
     *
     * Este método crea un itemd e tipo bloque que está asociado con
     * un bloque específico
     *
     * @param name (String) - nombre del bloque
     * @param block (Block) - clase a la que pertenece el bloque
     * @param tab (ItemGroup) - Grupo de items al que pertenecerá el bloque
     * @return -  Devuelve el bloque ya registrado
     */
    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(
                Registry.ITEM,
                new Identifier(TutorialMod.TUTORIALMOD_ID, name),
                new BlockItem(
                        block,
                        new FabricItemSettings().group(tab)
                )
        );
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.debug("Registering Mod Blocks for " + TutorialMod.TUTORIALMOD_ID);
    }
}

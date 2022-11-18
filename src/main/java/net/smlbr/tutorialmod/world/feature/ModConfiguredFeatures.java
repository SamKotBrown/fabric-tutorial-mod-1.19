package net.smlbr.tutorialmod.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.smlbr.tutorialmod.TutorialMod;
import net.smlbr.tutorialmod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target>  OVERWORLD_TANZANTIE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES
                    , ModBlocks.TANZANITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES
                    , ModBlocks.DEEPSLATE_TANZANITE_ORE.getDefaultState())
    );

    public static final List<OreFeatureConfig.Target>  NETHER_TANZANTIE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER
                    , ModBlocks.NETHER_TANZANITE_ORE.getDefaultState())
    );

    public static final List<OreFeatureConfig.Target> END_TANZANTIE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE)
                    ,ModBlocks.ENDSTONE_TANZANITE_ORE.getDefaultState())
    );

    public static final RegistryEntry< ConfiguredFeature<OreFeatureConfig, ?>> TANZANITE_ORE =
            ConfiguredFeatures.register("tanzanite_ore",
                    Feature.ORE, new OreFeatureConfig(OVERWORLD_TANZANTIE_ORES, 9));
    public static final RegistryEntry< ConfiguredFeature<OreFeatureConfig, ?>> NETHER_TANZANITE_ORE =
            ConfiguredFeatures.register("nether_tanzanite_ore",
                    Feature.ORE, new OreFeatureConfig(NETHER_TANZANTIE_ORES, 12));
    public static final RegistryEntry< ConfiguredFeature<OreFeatureConfig, ?>> ENDSTONE_TANZANITE_ORE =
            ConfiguredFeatures.register("end_tanzanite_ore",
                    Feature.ORE, new OreFeatureConfig(END_TANZANTIE_ORES, 12));

    public static void registerConfigFeatures(){
        TutorialMod.LOGGER.debug("Registering mod configured feature for " + TutorialMod.TUTORIALMOD_ID);
    }
}

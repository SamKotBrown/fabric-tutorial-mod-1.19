package net.smlbr.tutorialmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import net.smlbr.tutorialmod.item.ModItems;

public class ModLootTableModifiers {

    private static final Identifier GRASS_BLOCK_ID = new Identifier("minecraft", "blocks/grass");
    private static final Identifier IGLOO_STRUCTURE_CHEST_ID = new Identifier("minecraft", "blocks/igloo_chest");
    private static final Identifier CREEPER_ID = new Identifier("minecraft", "blocks/creeper");

    /**
     * Gracias a este método podremos cambiar las loot tables predeterminadas de minecraft
     */
    public static  void modifyLootTables() {
        LootTableEvents.MODIFY.register(
                (resourceManager, lootManager, id, tableBuilder, source) -> {

                    if (GRASS_BLOCK_ID.equals(id)) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(0.35f)) //probabilidad de que dropee el item
                                .with(ItemEntry.builder(ModItems.EGGPLANT_SEEDS)) //item que te va a dropear
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                        //numero de items generados
                        tableBuilder.pool(poolBuilder.build());
                    }

                    if (IGLOO_STRUCTURE_CHEST_ID.equals(id)) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(1f)) //probabilidad de que dropee el item
                                .with(ItemEntry.builder(ModItems.EIGHT_BALL)) //item que te va a dropear
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                        //numero de items generados
                        tableBuilder.pool(poolBuilder.build());
                    }

                    if (CREEPER_ID.equals(id)) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(1f)) //probabilidad de que dropee el item
                                .conditionally(EntityPropertiesLootCondition.builder(
                                        LootContext.EntityTarget.KILLER,
                                        new EntityPredicate.Builder().equipment(EntityEquipmentPredicate.Builder.create()
                                                .mainhand(ItemPredicate.Builder.create()
                                                        .items(Items.GOLDEN_SWORD).build()).build()).build()
                                ))
                                .with(ItemEntry.builder(ModItems.EGGPLANT)) //item que te va a dropear
                                 //Solo lo dropea si lo matas con una espada de oro
//                                .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
//                                        .items(Items.GOLDEN_SWORD)).build())
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                        //numero de items generados
                        tableBuilder.pool(poolBuilder.build());
                    }

                });
    }
}

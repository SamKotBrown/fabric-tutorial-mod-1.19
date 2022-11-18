package net.smlbr.tutorialmod.item.Custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallItem extends Item {
    public EightBallItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        /*
        Este tipo de interacciones es esencial que se hagan en la parte dels ervidor;
        el servidor es mejor para acciones que vayan ocurriendo
        entre los bloques items y el mundo / jugadores.
        En el cliente ocurrirán las cosas que se refieran al renderizado del m undo / como
        se ven las cosas
         */
        if (!world.isClient() && hand == Hand.MAIN_HAND){
            //EXECUTED ON THE SERVER
            outputRandomNumber(user);
            user.getItemCooldownManager().set(this, 20);
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Right click to get a random number")
                    .formatted(Formatting.YELLOW));
        } else {
            tooltip.add(Text.literal("Press shift to get more info")
                    .formatted(Formatting.BLUE));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    private void outputRandomNumber(PlayerEntity player) {
        player.sendMessage(Text.literal("Your number is " + getRandomNumber()));
    }

    private int getRandomNumber() {
        return Random.createLocal().nextInt(10);
    }
}

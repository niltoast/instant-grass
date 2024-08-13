package niltoast.instant_grass.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Objects;

public class InstantGrassItem extends Item {

    public InstantGrassItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);

        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = context.getStack();

        if(blockState.isOf(Blocks.DIRT)) {
            if (!world.isClient) {
                world.setBlockState(blockPos, Blocks.GRASS_BLOCK.getDefaultState());

                if (playerEntity instanceof ServerPlayerEntity) {
                    itemStack.damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                }

                Objects.requireNonNull(context.getPlayer()).emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
            }

            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            ParticleUtil.spawnParticlesAround(world, blockPos.add(0, 1, 0), 5, ParticleTypes.HAPPY_VILLAGER);

            return ActionResult.success(world.isClient());
        }

        return ActionResult.FAIL;
    }

    @Override
    public SoundEvent getBreakSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER.value();
    }
}

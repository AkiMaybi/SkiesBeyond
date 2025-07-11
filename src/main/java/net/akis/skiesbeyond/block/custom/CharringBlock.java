package net.akis.skiesbeyond.block.custom;

import net.akis.skiesbeyond.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CharringBlock extends Block {
    public CharringBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_CLUSTER_FALL, SoundCategory.BLOCKS, 3f, 1.5f);
        if (player.getMainHandStack().getItem() == ModItems.SOLAR_ESSENCE) {
            player.setStackInHand(Hand.MAIN_HAND, new ItemStack(ModItems.COMBUSTED_ESSENCE, player.getMainHandStack().getCount()));
        }
        return ActionResult.SUCCESS;

    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == ModItems.SOLAR_ESSENCE) {
                itemEntity.setStack(new ItemStack(ModItems.COMBUSTED_ESSENCE, itemEntity.getStack().getCount()));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}

package net.akis.skiesbeyond.effect;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.MathHelper;

public class JumpForTheStarsEffect extends StatusEffect {
    public JumpForTheStarsEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
            if (entity.isPlayer()) {
                if (JFTSCooldown < 10) {
                    JFTSCooldown = JFTSCooldown + 1;
                } else {
                    if (Screen.hasControlDown() & !entity.isOnGround()) {

                        float yaw = entity.getYaw();
                        double yawRadians = Math.toRadians(yaw);

                        double x = -MathHelper.sin((float) yawRadians) * 0.6;
                        double z = MathHelper.cos((float) yawRadians) * 0.6;

                        entity.setVelocity(x, 0.42, z);
                        JFTSCooldown = 0;
                    }
                }
            } else {
                if (entity.getHealth() >= 10) {
                    entity.setVelocity(0, 5, 0);
                }
            }


        return super.applyUpdateEffect(entity, amplifier);
    }

    private int JFTSCooldown = 0;


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}

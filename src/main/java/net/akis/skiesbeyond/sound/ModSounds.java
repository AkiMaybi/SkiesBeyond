package net.akis.skiesbeyond.sound;

import net.akis.skiesbeyond.SkiesBeyond;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent CHISEL_USE = registerSoundEvent("chisel_use");

    public static final SoundEvent CHARRING_BLOCK_BREAK = registerSoundEvent("charring_block_break");
    public static final SoundEvent CHARRING_BLOCK_STEP = registerSoundEvent("charring_block_step");
    public static final SoundEvent CHARRING_BLOCK_PLACE = registerSoundEvent("charring_block_place");
    public static final SoundEvent CHARRING_BLOCK_HIT = registerSoundEvent("charring_block_hit");
    public static final SoundEvent CHARRING_BLOCK_FALL = registerSoundEvent("charring_block_fall");

    public static final BlockSoundGroup CHARRING_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            CHARRING_BLOCK_BREAK, CHARRING_BLOCK_STEP, CHARRING_BLOCK_PLACE, CHARRING_BLOCK_HIT, CHARRING_BLOCK_FALL);

    public static final SoundEvent STARJUMP = registerSoundEvent("starjump");
    public static final RegistryKey<JukeboxSong> STARJUMP_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(SkiesBeyond.MOD_ID, "starjump"));


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(SkiesBeyond.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        SkiesBeyond.LOGGER.info("Registering " + SkiesBeyond.MOD_ID + "Sounds");
    }
}

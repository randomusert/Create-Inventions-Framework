package io.github.randomusert.mods.create_inventions_framework.init;


import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import io.github.randomusert.mods.create_inventions_framework.Create_inventions_framework;
import io.github.randomusert.mods.create_inventions_framework.blocks.entity.GrinderBlockEntity;
import net.minecraft.world.level.block.Block;

public class CIFBlockEntities {
    private static final CreateRegistrate REGISTRATE = Create_inventions_framework.registrate();

    public static final BlockEntityEntry<GrinderBlockEntity> GRINDER = REGISTRATE
            .blockEntity("grinder", GrinderBlockEntity::new)
            .validBlock(CIFBlocks.GRINDER)
            .register();

    public static void register() {
    }
}

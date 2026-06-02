package io.github.randomusert.mods.create_inventions_framework.init;

import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.github.randomusert.mods.create_inventions_framework.Create_inventions_framework;
import io.github.randomusert.mods.create_inventions_framework.blocks.GrinderBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class CIFBlocks {
    private static final CreateRegistrate REGISTRATE = Create_inventions_framework.registrate();

/*
    public static final DeferredBlock<Block> GRINDER = BLOCKS.register("grinder",
            () -> new GrinderBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()));*/
    public static final BlockEntry<GrinderBlock> GRINDER = REGISTRATE.block("grinder", GrinderBlock::new)
        .initialProperties(SharedProperties::stone)
        .transform(pickaxeOnly())
        .blockstate((c, p) -> BlockStateGen.axisBlock(c,p,s -> AssetLookup.partialBaseModel(c,p)))
        .addLayer(() -> RenderType::cutout)
        .item()
        .transform(customItemModel())
        .register();

    public static void register() {
    }
}

package io.github.randomusert.mods.create_inventions_framework.datagen;

import io.github.randomusert.mods.create_inventions_framework.Create_inventions_framework;
import io.github.randomusert.mods.create_inventions_framework.worldgen.CIFStructureSets;
import io.github.randomusert.mods.create_inventions_framework.worldgen.CIFStructures;
import io.github.randomusert.mods.create_inventions_framework.worldgen.CIFTemplatePools;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CIFDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TEMPLATE_POOL, CIFTemplatePools::bootstrap)
            .add(Registries.STRUCTURE, CIFStructures::bootstrap)
            .add(Registries.STRUCTURE_SET, CIFStructureSets::bootstrap);

    public CIFDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Create_inventions_framework.MODID));
    }
}

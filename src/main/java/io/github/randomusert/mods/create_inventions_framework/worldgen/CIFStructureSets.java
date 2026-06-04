package io.github.randomusert.mods.create_inventions_framework.worldgen;

import io.github.randomusert.mods.create_inventions_framework.Create_inventions_framework;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

import java.util.List;
import java.util.Optional;

public class CIFStructureSets {
    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);


        RandomSpreadStructurePlacement placement = new RandomSpreadStructurePlacement(
                Vec3i.ZERO,
                StructurePlacement.FrequencyReductionMethod.DEFAULT,
                1.0F,
                143576239,
                Optional.empty(),
                32,
                8,
                RandomSpreadType.LINEAR
        );


        StructureSet structureSet = new StructureSet(
                List.of(new StructureSet.StructureSelectionEntry(
                        structures.getOrThrow(Create_inventions_framework.createKey(Registries.STRUCTURE, "ore_geode_structure")),
                        1 // Weight
                )),
                placement
        );

        context.register(Create_inventions_framework.createKey(Registries.STRUCTURE_SET, "ore_geode_set"), structureSet);

        StructureSet ruinedWorkshopStructure = new StructureSet(
                List.of(new StructureSet.StructureSelectionEntry(
                        structures.getOrThrow(Create_inventions_framework.createKey(Registries.STRUCTURE, "ruined_workshop_structure")),
                        1 // Weight
                )),
                placement
        );

        context.register(Create_inventions_framework.createKey(Registries.STRUCTURE_SET, "ruined_workshop_set"), ruinedWorkshopStructure);
    }
}

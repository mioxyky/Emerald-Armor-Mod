# Graph Report - Emerald-Armor-Mod  (2026-08-21)

## Corpus Check
- cluster-only mode — file stats not available

## Summary
- 102 nodes · 186 edges · 14 communities (11 shown, 3 thin omitted)
- Extraction: 100% EXTRACTED · 0% INFERRED · 0% AMBIGUOUS
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `b38ce45b`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- EmeraldArmorModNeoForge.java
- Override
- Override
- Override
- EmeraldArmorModForge.java
- gradlew
- EmeraldArmorModConstants
- net.minecraft.sounds.SoundEvent

## God Nodes (most connected - your core abstractions)
1. `EmeraldArmorModNeoForge` - 13 edges
2. `EmeraldArmorModForge` - 12 edges
3. `EmeraldArmorModFabric` - 10 edges
4. `EmeraldArmorMaterial` - 10 edges
5. `EmeraldArmorMaterial` - 10 edges
6. `EmeraldArmorMaterial` - 10 edges
7. `EmeraldToolTier` - 8 edges
8. `EmeraldToolTier` - 8 edges
9. `EmeraldToolTier` - 8 edges
10. `EmeraldArmorModConstants` - 2 edges

## Surprising Connections (you probably didn't know these)
- `EmeraldArmorModNeoForge` --references--> `net.minecraft.world.item.CreativeModeTab`  [EXTRACTED]
  neoforge/src/main/java/net/noxysoff/emeraldarmor/neoforge/EmeraldArmorModNeoForge.java →   _Bridges community 0 → community 4_
- `EmeraldArmorMaterial` --implements--> `net.minecraft.world.item.ArmorMaterial`  [EXTRACTED]
  forge/src/main/java/net/noxysoff/emeraldarmor/forge/EmeraldArmorModForge.java →   _Bridges community 1 → community 0_
- `EmeraldArmorMaterial` --implements--> `net.minecraft.world.item.ArmorMaterial`  [EXTRACTED]
  neoforge/src/main/java/net/noxysoff/emeraldarmor/neoforge/EmeraldArmorModNeoForge.java →   _Bridges community 2 → community 0_
- `EmeraldArmorMaterial` --implements--> `net.minecraft.world.item.ArmorMaterial`  [EXTRACTED]
  fabric/src/main/java/net/noxysoff/emeraldarmor/fabric/EmeraldArmorModFabric.java →   _Bridges community 3 → community 0_

## Import Cycles
- None detected.

## Communities (14 total, 3 thin omitted)

### Community 0 - "EmeraldArmorModNeoForge.java"
Cohesion: 0.17
Nodes (15): EmeraldArmorModFabric, EmeraldArmorModNeoForge, PlayerTickEvent, net.fabricmc.api.ModInitializer, net.minecraft.resources.ResourceLocation, net.minecraft.world.item.ArmorMaterial, net.minecraft.world.item.Item, net.minecraft.world.item.Items (+7 more)

### Community 1 - "Override"
Cohesion: 0.17
Nodes (5): EmeraldArmorMaterial, EmeraldToolTier, Override, Type, net.minecraft.world.item.crafting.Ingredient

### Community 2 - "Override"
Cohesion: 0.21
Nodes (4): EmeraldArmorMaterial, EmeraldToolTier, Override, Type

### Community 3 - "Override"
Cohesion: 0.22
Nodes (4): EmeraldArmorMaterial, EmeraldToolTier, Override, Type

### Community 4 - "EmeraldArmorModForge.java"
Cohesion: 0.29
Nodes (7): EmeraldArmorModForge, PlayerTickEvent, net.minecraft.world.item.CreativeModeTab, net.minecraftforge.eventbus.api.IEventBus, net.minecraftforge.fml.common.Mod, net.minecraftforge.registries.DeferredRegister, net.minecraftforge.registries.RegistryObject

## Knowledge Gaps
- **3 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `EmeraldArmorModNeoForge` connect `EmeraldArmorModNeoForge.java` to `Override`, `EmeraldArmorModForge.java`?**
  _High betweenness centrality (0.115) - this node is a cross-community bridge._
- **Why does `EmeraldArmorModForge` connect `EmeraldArmorModForge.java` to `EmeraldArmorModNeoForge.java`, `Override`?**
  _High betweenness centrality (0.109) - this node is a cross-community bridge._
- **Why does `EmeraldArmorMaterial` connect `Override` to `EmeraldArmorModNeoForge.java`?**
  _High betweenness centrality (0.105) - this node is a cross-community bridge._
![titre mod](https://cdn.modrinth.com/data/cached_images/d2a58042944716b89c73b6dfc40aaf3ef754476b.png)

# Emerald Armor Mod

Emerald Armor Mod is a multi-loader Minecraft mod workspace for **Minecraft 1.20.1** with modules for:

- Fabric
- Forge
- NeoForge legacy 1.20.1

The workspace is prepared so later Minecraft ports can keep the same mod id, recipes, models, texture layout, and item balance while updating only loader-specific APIs when Minecraft changes.

> Note: Minecraft version `26.x` uses Mojang's new version-numbering scheme. A single Java source set cannot realistically cover every loader API from 1.20.1 through future 26.x releases without version-specific ports, so this repository starts with a clean 1.20.1 multi-loader base.

## Features

- Emerald helmet, chestplate, leggings, and boots.
- Emerald sword, pickaxe, axe, shovel, and hoe.
- Crafting recipes for every armor and tool item using vanilla emeralds and sticks.
- Balance below diamond:
  - armor durability multiplier: `30` instead of diamond's `33`;
  - armor protection: `2 / 5 / 6 / 2` instead of diamond's `3 / 6 / 8 / 3`;
  - armor toughness: `1.0` instead of diamond's `2.0`;
  - tool durability: `1400` instead of diamond's `1561`;
  - tool mining speed: `7.0` instead of diamond's `8.0`;
  - enchantability: `8` instead of diamond's `10`.
- Wearing the emerald helmet grants **Hero of the Village II** while equipped.

## Where to put your textures

Shared assets live in the `common` module and are copied into each loader build.

Put item textures here:

```text
common/src/main/resources/assets/emerald_armor_mod/textures/item/
```

Expected item texture names:

```text
emerald_helmet.png
emerald_chestplate.png
emerald_leggings.png
emerald_boots.png
emerald_sword.png
emerald_pickaxe.png
emerald_axe.png
emerald_shovel.png
emerald_hoe.png
```

Put worn armor model textures here:

```text
common/src/main/resources/assets/emerald_armor_mod/textures/models/armor/
```

Expected armor model texture names:

```text
emerald_layer_1.png
emerald_layer_2.png
```

No binary placeholder textures are committed, so GitHub/Codex text extraction stays compatible. Add your final PNG textures with the names above before testing in-game.

## Cloud / Codex workflow

When this project is edited in Codex/cloud, the code lives in this remote workspace first. I can modify files, run terminal checks, commit changes, and prepare a pull request from here, but you still test Minecraft gameplay on your own computer because the cloud environment normally has no Minecraft account session or graphical game window.

Recommended workflow:

1. Let Codex finish the change and create the pull request.
2. Pull/merge the branch locally, or download the branch/PR from GitHub.
3. Run the Gradle build command locally to generate the mod jars.
4. Run one loader client locally to test gameplay.
5. Copy the jar from the matching loader's `build/libs/` folder into your Minecraft instance's `mods/` folder.

## Useful commands

Run these from the repository root. On Windows PowerShell, use the same commands with `./gradlew` if a Gradle wrapper is added later; for now this workspace uses the installed `gradle` command.

### Build/export jars

```bash
gradle build
```

Individual loader jars:

```bash
gradle :fabric:build
gradle :forge:build
gradle :neoforge:build
```

Built jars are exported under:

```text
fabric/build/libs/
forge/build/libs/
neoforge/build/libs/
```

Use the jar that matches your Minecraft instance loader:

- Fabric instance: copy the `fabric/build/libs/...fabric...jar` file.
- Forge instance: copy the `forge/build/libs/...forge...jar` file.
- NeoForge instance: copy the `neoforge/build/libs/...neoforge...jar` file.

Do not put all three jars in the same instance at the same time.

### Launch Minecraft for testing

```bash
gradle :fabric:runClient
gradle :forge:runClient
gradle :neoforge:runClient
```

Server test runs:

```bash
gradle :fabric:runServer
gradle :forge:runServer
gradle :neoforge:runServer
```

### Refresh IDE files

Import the root `settings.gradle` / `build.gradle` in IntelliJ IDEA or VS Code with Gradle support, then use the Gradle tasks above.

## Project layout

```text
common/   shared constants, recipes, item models, lang, textures
fabric/   Fabric loader entrypoint and registration
forge/    Forge loader entrypoint and registration
neoforge/ NeoForge 1.20.1 legacy-compatible entrypoint and registration
```

<p align="center">
  <img src="https://cdn.modrinth.com/data/cached_images/d2a58042944716b89c73b6dfc40aaf3ef754476b.png" alt="Emerald Armor Mod" width="180" />
</p>

<h1 align="center">Emerald Armor Mod</h1>

<p align="center">
  <strong>A multi-loader Minecraft mod adding emerald armor and tools</strong>
</p>

<p align="center">
  <a href="https://github.com/mioxyky/Emerald-Armor-Mod/releases/latest">
    <img src="https://img.shields.io/github/v/release/yourusername/Emerald-Armor-Mod?label=Latest%20Release&style=for-the-badge" alt="Latest Release" />
  </a>
  <a href="https://github.com/mioxyky/Emerald-Armor-Mod/blob/main/LICENSE">
    <img src="https://img.shields.io/github/license/yourusername/Emerald-Armor-Mod?style=for-the-badge" alt="License" />
  </a>
  <a href="https://github.com/mioxyky/Emerald-Armor-Mod/issues">
    <img src="https://img.shields.io/github/issues/yourusername/Emerald-Armor-Mod?style=for-the-badge" alt="Issues" />
  </a>
  <br/>
  <a href="https://modrinth.com/mod/emerald-armor">
    <img src="https://img.shields.io/badge/Modrinth-Download-green?style=for-the-badge&logo=modrinth" alt="Modrinth" />
  </a>
  <a href="https://www.curseforge.com/minecraft/mc-mods/emerald-armorr">
    <img src="https://img.shields.io/badge/CurseForge-Download-orange?style=for-the-badge&logo=curseforge" alt="CurseForge" />
  </a>
</p>

---

## 📋 Overview

**Emerald Armor Mod** adds a complete set of emerald armor and tools to Minecraft **1.20.1**, positioned as a progression step between iron and diamond. The mod is built as a **multi-loader workspace** supporting Fabric, Forge, and NeoForge from a single codebase.

| Feature | Status |
|---------|--------|
| **Minecraft Version** | 1.20.1 |
| **Mod Version** | **3.1.0** |
| **Loaders** | Fabric, Forge, NeoForge (Legacy 1.20.1) |
| **Language** | Java 17 |
| **License** | MIT |

---

## ✨ Features

### 🛡️ Armor Set
| Item | Durability Multiplier | Protection | Toughness |
|------|----------------------|------------|-----------|
| Helmet | 30 | 2 | 1.0 |
| Chestplate | 30 | 5 | 1.0 |
| Leggings | 30 | 6 | 1.0 |
| Boots | 30 | 2 | 1.0 |

> **Comparison:** Diamond uses multiplier `33`, protection `3/6/8/3`, toughness `2.0`

### ⛏️ Tool Set
| Tool | Durability | Mining Speed | Enchantability |
|------|------------|--------------|----------------|
| Sword | 1400 | 7.0 | 8 |
| Pickaxe | 1400 | 7.0 | 8 |
| Axe | 1400 | 7.0 | 8 |
| Shovel | 1400 | 7.0 | 8 |
| Hoe | 1400 | 7.0 | 8 |

> **Comparison:** Diamond uses durability `1561`, speed `8.0`, enchantability `10`

### 🎯 Unique Effect
**Emerald Helmet** grants **Hero of the Village II** while equipped — perfect for trading with villagers!

### 📜 Crafting
All items use standard vanilla recipes with emeralds and sticks. No custom recipe types — just drop into any crafting table.

---

## 🚀 Installation

### For Players

1. **Download** the correct JAR for your mod loader:
   - **Fabric:** `fabric/build/libs/emerald-armor-mod-3.1.0-fabric.jar`
   - **Forge:** `forge/build/libs/emerald-armor-mod-3.1.0-forge.jar`
   - **NeoForge:** `neoforge/build/libs/emerald-armor-mod-3.1.0-neoforge.jar`

2. **Place** the JAR in your Minecraft instance's `mods/` folder

3. **Launch** Minecraft with the matching loader profile

> ⚠️ **Do not** install multiple loader JARs in the same instance.

### Downloads
- [Modrinth](https://modrinth.com/mod/emerald-armor-mod) — Recommended, fastest downloads
- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/emerald-armor-mod) — Alternative source
- [GitHub Releases](https://github.com/yourusername/Emerald-Armor-Mod/releases) — Direct from source

---

## 🛠️ For Developers

### Prerequisites
- Java 17+
- Gradle (wrapper included via `./gradlew`)

### Project Structure
```
Emerald-Armor-Mod/
├── common/          # Shared code: items, recipes, models, lang, textures
├── fabric/          # Fabric loader entrypoint & registration
├── forge/           # Forge loader entrypoint & registration
├── neoforge/        # NeoForge 1.20.1 legacy entrypoint & registration
├── build.gradle     # Root build configuration
├── settings.gradle  # Module definitions
└── gradle.properties # Version & dependency versions
```

### Building
```bash
# Build all loaders
./gradlew build

# Build individual loaders
./gradlew :fabric:build
./gradlew :forge:build
./gradlew :neoforge:build
```

Output JARs appear in each module's `build/libs/` directory.

### Running for Testing
```bash
# Client (play test)
./gradlew :fabric:runClient
./gradlew :forge:runClient
./gradlew :neoforge:runClient

# Server
./gradlew :fabric:runServer
./gradlew :forge:runServer
./gradlew :neoforge:runServer
```

### IDE Setup
Import the root `settings.gradle` into **IntelliJ IDEA** or **VS Code** with Gradle support. The multi-project structure will be recognized automatically.

---

## 🎨 Adding Textures

Shared assets live in the `common` module and are copied into each loader build.

### Item Textures
```
common/src/main/resources/assets/emerald_armor_mod/textures/item/
```

Expected files:
```
emerald_helmet.png       emerald_chestplate.png
emerald_leggings.png     emerald_boots.png
emerald_sword.png        emerald_pickaxe.png
emerald_axe.png          emerald_shovel.png
emerald_hoe.png
```

### Armor Model Textures
```
common/src/main/resources/assets/emerald_armor_mod/textures/models/armor/
```

Expected files:
```
emerald_layer_1.png      emerald_layer_2.png
```

> 💡 No binary placeholder textures are committed. Add your final PNG files before testing in-game.

---

## 📦 Dependencies

| Dependency | Version |
|------------|---------|
| Minecraft | 1.20.1 |
| Fabric Loader | ≥0.16.0 |
| Fabric API | 0.92.6+1.20.1 |
| Forge | 47.4.0 |
| NeoForge | Legacy 1.20.1 |

---

## 🤝 Contributing

Contributions are welcome! Please:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Development Guidelines
- Follow existing code style and conventions
- Keep loader-specific code in their respective modules
- Shared logic belongs in `common/`
- Test on all three loaders before submitting

---

## 📄 License

This project is licensed under the **MIT License** — see [LICENSE](LICENSE) for details.

---

## 🙏 Credits

- **Author:** [Noxysoff](https://github.com/Noxysoff)
- **Mod ID:** `emerald_armor_mod`
- **Group:** `net.noxysoff.emeraldarmor`

---

## 🔗 Links

- [GitHub Repository](https://github.com/yourusername/Emerald-Armor-Mod)
- [Issue Tracker](https://github.com/yourusername/Emerald-Armor-Mod/issues)
- [Modrinth](https://modrinth.com/mod/emerald-armor-mod)
- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/emerald-armor-mod)

---

<p align="center">
  Made with ❤️ for the Minecraft modding community
</p>

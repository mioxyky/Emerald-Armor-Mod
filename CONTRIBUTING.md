# Contributing

Thank you for your interest in contributing to **Emerald Armor Mod**!

## Getting Started

1. Fork the repository
2. Clone your fork: `git clone https://github.com/YOUR_USERNAME/Emerald-Armor-Mod.git`
3. Create a branch: `git checkout -b feature/your-feature`
4. Make your changes
5. Test locally with `./gradlew build`
6. Commit and push: `git commit -m "Add your feature"`
7. Open a Pull Request

## Development Setup

### Prerequisites
- Java 17 or higher
- Git

### Build
```bash
./gradlew build
```

### Run in development
```bash
./gradlew fabric:runClient    # Fabric
./gradlew forge:runClient     # Forge
./gradlew neoforge:runClient  # NeoForge
```

## Code Style

- Follow standard Java conventions
- Use 4 spaces for indentation
- Keep classes focused and well-documented
- Run `./gradlew spotlessApply` (if configured) before committing

## Pull Request Guidelines

- Keep PRs focused on a single feature or fix
- Update `CHANGELOG.md` under `[Unreleased]`
- Ensure `./gradlew build` passes
- Reference any related issues

## Reporting Bugs

Open an issue using the bug report template and include:
- Minecraft version
- Mod loader (Fabric/Forge/NeoForge)
- Steps to reproduce
- Expected vs actual behavior

## License

By contributing, you agree that your contributions will be licensed under the [MIT License](LICENSE).

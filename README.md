# Legacy mixin-wrapper

A bundle of mixin and mixin-extras

[![Jitpack State](https://jitpack.io/v/Water-OR/LegacyMixinWrapper.svg)](https://jitpack.io/#Water-OR/LegacyMixinWrapper)

## Usage

> [!NOTE]
> replace `{version}` with actual release tag

```kotlin
repositories {
    maven("https://jitpack.io") {
        content { includeGroupByRegex("com\\.github\\.(.)+") }
    }
}

dependencies {
    runtimeOnly("com.github.Water-OR:LegacyMixinWrapper:{tag}")
}
```

## Links
- [mixin](https://github.com/SpongePowered/Mixin)
- [fabric-mixin](https://github.com/FabricMC/Mixin)
- [mixin-extras](https://github.com/LlamaLad7/MixinExtras)
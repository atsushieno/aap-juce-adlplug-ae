# aap-juce-adlplug-ae: port of ADLplug-AE to AAP

It is almost identical to atsushieno/aap-juce-adlplug as a plugin, but the
entire build structure has changed and it is CMake based project now.

It is atsushieno/ADLplug-AE, a modernized build of jpcima/ADLplug, ported to
[AAP (Audio Plugins For Android)](https://github.com/atsushieno/aap-core),
using [aap-juce](https://github.com/atsushieno/aap-juce).

A short background on the build changes: it became impossible to maintain
aap-juce-adlplug which was based on old JUCE and Projucer. Therefore I tried
to migrate to ADLplug's CMake build setup, but turned out that it was not
the CMake build system JUCE offers. And that prevented us from adopting it
as AAP cmake support.

Since the actual plugin implementation should not be too different from
what JUCE normally expects, we ended up creating another plugin build called
ADLplug-AE.


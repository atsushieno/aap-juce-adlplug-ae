# aap-juce-adlplug-ae: port of ADLplug-AE to AAP

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

This app is somewhat special in that one source repo contains two plugins:
ADLplug-AE and OPNplug-AE. We create separate app modules for each (it is
currently impossible at JUCE to build two plugins within an app package).

## License

ADLplug-AE is released under the AGPLv3 license.

aap-juce-adlplug-ae is released under the AGPLv3 license.


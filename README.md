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
ADLplug-AE and OPNplug-AE, and one app package contains both. Each plugin has
its own JUCE runtime, and two JUCE runtimes cannot share a process, so each
plugin runs in its own process (`:adlplug` and `:opnplug`), with its own
AudioPluginService and AudioPluginViewService. JUCE is initialized in each of
them by aap-juce `JuceAudioPluginServiceExtension`; the main process (plugin
manager UI and MIDI device service) does not load JUCE at all. See
"Running plugins in separate processes" in aap-core `docs/DEVELOPERS.md`.

This requires aap-core 0.11.2 or later, and an aap-juce that contains
`JuceAudioPluginServiceExtension`. Hosts built with aap-core 0.11.1 or earlier
support only one AudioPluginService per package, so they see only ADLplug-AE:
OPNplug-AE's service declares its metadata (`aap_metadata_opnplug.xml`) as
`#SecondaryPlugins`, which they ignore. To build against local checkouts of them,
set the `AAP_DIR` and `AAP_JUCE_DIR` environment variables.

The MIDI device service exposes one device with a port for each plugin.

## License

ADLplug-AE is released under the AGPLv3 license.

aap-juce-adlplug-ae is released under the AGPLv3 license.


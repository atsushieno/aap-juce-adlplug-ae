# aap-juce-adlplug-ae: port of ADLplug-AE to AAP

It is almost identical to atsushieno/aap-juce-adlplug as a plugin, but the
entire build structure has changed and it is CMake based project now.

A short background on the build changes: it became impossible to maintain
aap-juce-adlplug which was based on old JUCE and Projucer. Therefore I tried
to migrate to ADLplug's CMake build setup, but turned out that it was not
the CMake build system JUCE offers. And that prevented us from adopting it
as AAP cmake support.

Since the actual plugin implementation should not be too different from
what JUCE normally expects, we ended up creating another plugin build called
ADLplug-AE.

The default build results only in OPNplug-AE, but it would be possible to
also build ADLplug-AE. The build script is not implemented enough to do so yet.

Also: it builds but the aap_metadata.xml defaults everything to 0 (which
seems to be the implemented behavior in ADLplug).

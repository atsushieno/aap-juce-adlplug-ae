package org.androidaudioplugin.ports.juce.adlplug_ae

import org.androidaudioplugin.AudioPluginService
import org.androidaudioplugin.AudioPluginViewService

// ADLplug-AE and OPNplug-AE each have their own JUCE runtime, which cannot share a process.
// ADLplug-AE uses the stock AudioPluginService and AudioPluginViewService in the ":adlplug"
// process, and OPNplug-AE uses these classes in the ":opnplug" process (see AndroidManifest.xml).
// A manifest can declare a component class only once, hence these otherwise empty classes.

class OpnplugAudioPluginService : AudioPluginService()

class OpnplugAudioPluginViewService : AudioPluginViewService()

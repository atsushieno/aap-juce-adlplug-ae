package org.androidaudioplugin.ports.juce.adlplug_ae

import android.content.Context
import androidx.annotation.RequiresApi
import org.androidaudioplugin.PluginInformation
import org.androidaudioplugin.hosting.AudioPluginHostHelper
import org.androidaudioplugin.midideviceservice.AudioPluginMidiDeviceService
import org.androidaudioplugin.midideviceservice.AudioPluginMidiUmpDeviceService

// Each plugin is exposed as a MIDI device of its own, as it was when they were in separate apps.
// (StandaloneAudioPluginMidiDeviceService would expose all the plugins in this package through one
// device, where it maps a port to a plugin by matching the device name and port name to the plugin name.)

private const val ADLPLUG_ID = "juceaap:adlplug-ae"
private const val OPNPLUG_ID = "juceaap:opnplug-ae"

private fun getLocalPlugin(context: Context, pluginId: String): List<PluginInformation> =
    AudioPluginHostHelper.queryAudioPluginServices(context, context.packageName)
        .flatMap { it.plugins }.filter { it.pluginId == pluginId }

class AdlplugMidiDeviceService : AudioPluginMidiDeviceService() {
    override val plugins get() = getLocalPlugin(applicationContext, ADLPLUG_ID)
}

class OpnplugMidiDeviceService : AudioPluginMidiDeviceService() {
    override val plugins get() = getLocalPlugin(applicationContext, OPNPLUG_ID)
}

@RequiresApi(35)
class AdlplugMidiUmpDeviceService : AudioPluginMidiUmpDeviceService() {
    override val plugins get() = getLocalPlugin(applicationContext, ADLPLUG_ID)
}

@RequiresApi(35)
class OpnplugMidiUmpDeviceService : AudioPluginMidiUmpDeviceService() {
    override val plugins get() = getLocalPlugin(applicationContext, OPNPLUG_ID)
}

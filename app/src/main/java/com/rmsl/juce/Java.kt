// For binary compatibility with JUCE JNI, we have to name this class under this package.

package com.rmsl.juce

import android.content.Context

class Java
{
    companion object {
        // This app contains two JUCE plugins, and each runs in its own process. The plugin
        // library is loaded in each process by JuceAudioPluginServiceExtension (aap-juce),
        // not here: loading one here would bring its JUCE runtime into every process.

        @JvmStatic
        external fun initialiseJUCE(applicationContext: Context)
    }
}

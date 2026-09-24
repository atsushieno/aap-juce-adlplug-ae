// For binary compatibility with JUCE JNI, we have to name this class under this package.

package com.rmsl.juce

import android.content.Context

class Java
{
    companion object {
        // This app contains two JUCE plugin libraries. aap-juce JuceAppInitializer loads each of
        // them and initializes JUCE for it, so we do not load any library here.

        @JvmStatic
        external fun initialiseJUCE(applicationContext: Context)
    }
}

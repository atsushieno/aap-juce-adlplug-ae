
PWD=$(shell pwd)
AAP_JUCE_DIR=$(PWD)/external/aap-juce

# Specify the app name. It will show up as the Main Launcher.
APP_NAME=OPNplug-AE

APP_BUILD_DIR=$(PWD)
# Specify the app repo as a submodule
APP_SRC_DIR=$(PWD)/external/ADLplug-AE
# Typical JUCE app submodules JUCE, but the location is up to the project.
JUCE_DIR=$(APP_SRC_DIR)/external/JUCE

APP_ICON=$(APP_SRC_DIR)/external/ADLplug/resources/application/OPNplug-96.png

APP_SHARED_CODE_LIBS="$(APP_NAME)_artefacts/lib$(APP_NAME)_SharedCode.a libADLMIDI.a libOPNMIDI.a libwopl.a libADLplug_fmt.a libsimple-ini.a libwopn.a"

# It can be any name, just make sure you generate the diff for AAP support,
# otherwise it will only build for Android without AAP.
# Make sure to include submodule changes (by e.g. git diff --submodule=diff)
PATCH_FILE=$(PWD)/aap-juce-support.patch
PATCH_DEPTH=1

# JUCE patches if any
JUCE_PATCHES= \
        $(shell pwd)/external/aap-juce/juce-patches/7.0.12/disable-cgwindowlistcreateimage.patch

include $(AAP_JUCE_DIR)/Makefile.cmake-common

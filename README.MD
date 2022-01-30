# Keylogger Application

## Problem Statement
Design a keylogger.
####Expected Features:
1. Capture all strokes of keys
2. Work in all Operating system.
3. Hidden from the Antivirus.

## Overview
Keylogger app is a Java application is a simple key logging software that has three primary goals:
1. Execute in hidden mode in background.
2. Detect and capture Keystrokes.
3. Generate keystrokes log in a file.

## Technology used
- JAVA

## Library used
- [JNativeHook](https://github.com/kwhat/jnativehook)

## Requirements
- Java 1.8 - 17 
- 256 MB of RAM
- OS (Check Supported OS section)


## How to Run Keylogger [Using an IDE]

1. Clone this repository from GitHub:

       $ https://github.com/seemantshekhar43/keylogger_app.git

2. Import this repo as a JAVA project in an IDE (IntelliJ/NetBeans) :

4. Run Main Class.

Note: In case your IDE does not detect the `jnativehook` library, then [add jnativehook-2.2.1.jar file present in lib directory as external jars](http://www.wikihow.com/Add-JARs-to-Project-Build-Paths-in-Eclipse-(Java)).


## How to Run Keylogger [Using an IDE]

1. Download the latest binary from the release and unzip the contents.
2. Execute `runner.bat` from compiled folder. 
3. Now your keylogger application is up and running. You can verify the same in Task Manager.
4. To stop the app. Press `F9` key.
5. You can find generated log file in the same directory.

## Supported OS

* Apple OS X 10.5 - 10.15
   * amd64, aarch64
   * Enable Access for Assistive Devices
* Windows 2000 - 10
   * i586, amd64, arm7
* X11 Linux
   * i586, amd64, arm7, aarch64
   * libxkbfile.so.1
   * libxkbcommon-x11.so.0
   * libxkbcommon.so.0
   * libX11-xcb.so.1
   * libX11.so.6
   * libxcb.so.1
   * libXinerama.so.1
   * libXt.so.6
   * libXtst.so.6
   * libc.so.6
   * libxcb-xkb.so.1
   * libdl.so.2
   * libXau.so.6
   * libXdmcp.so.6
   * libXext.so.6
   * libSM.so.6
   * libICE.so.6
   * libbsd.so.0
   * libuuid.so.1
   * librt.so.1
   * libpthread.so.0

### Future Scopes
* Allow user to select desired key combination to end keylogger app.
* Mouse clicks, scrolls and positions can also be logged.
* Convert this console application to a maven or gradle project. 

## Licence

Licenced under GNU GENERAL PUBLIC LICENSE v3.0.


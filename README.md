# olivsoft-swing
A new home for the Desktop version of the OlivSoft Navigation Software

This repo is in _maintenance_ mode, it is being ported onto a REST architecture with a Web UI.
See [here](https://github.com/OlivierLD/raspberry-coffee/tree/master/RESTNavServer).

**This is a Work in Progress**

The goal is to have that thing working as it used to.

## How to build
After cloning the repo:
```
$ cd release
$ ../gradlew clean shadowJar
```

## How to run

```
$ cd release/all-scripts
$ ./olivsoft.sh
```
Other scripts are available, depending on your system.

## Some notes
> _Warning:_ This is a bit too demanding for a Raspberry Pi, even the Raspberry 4 B.
 
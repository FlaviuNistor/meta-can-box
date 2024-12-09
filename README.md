# meta-can-box
Meta layer for building a CAN box setup on top of RPI4.

## Description

Goal is to generate a custom linux image that will start autoomatically the can-box app.

The target for the image it is to be as small as posible and boot as fast as posible.

## Dependencies

This layer depends on:

* URI: git://git.yoctoproject.org/poky
  * branch: scarthgap
  * revision: HEAD
* URI: git.yoctoproject.org/meta-raspberrypi
  * branch: scarthgap
  * revision: HEAD 
* URI: git.openembedded.org/meta-openembedded
  * branch: scarthgap
  * revision: HEAD

## Quick Start

1. git clone https://git.yoctoproject.org/poky -b nanbield
2. git clone https://git.yoctoproject.org/meta-raspberrypi -b nanbield
3. git clone https://git.openembedded.org/meta-openembedded -b nanbield
4. source poky/oe-init-build-env can-box-build
5. Add this layer to bblayers.conf and the dependencies above
6. Set MACHINE in local.conf to raspberrypi4 or raspberrypi4-64
7. bitbake rpi-can-tester-image
8. Use bmaptool to copy the generated .wic.bz2 file to the SD card
9. Boot your RPI

## Maintainers

* Flaviu Nistor `<flaviu.nistor at gmail.com>`

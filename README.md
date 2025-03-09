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

1. Make sure you have all the prerequierments https://docs.yoctoproject.org/ref-manual/system-requirements.html#supported-linux-distributions
2. git clone https://git.yoctoproject.org/poky -b scarthgap
3. git clone https://git.yoctoproject.org/meta-raspberrypi -b scarthgap
4. git clone https://git.openembedded.org/meta-openembedded -b scarthgap
5. source poky/oe-init-build-env can-box-build
6. Add the above layers to bblayers.conf https://docs.yoctoproject.org/dev/dev-manual/layers.html
7. Set MACHINE in local.conf MACHINE = "raspberrypi4-64" (or raspberrypi for 32 bit OS)
8. Set DISTRO in local.conf DISTRO ?= "can-box-rootfs"
8. bitbake rpi-can-tester-image
9. Use bmaptool to copy the generated .wic.bz2 file to the SD card
10. Boot your RPI

## Note

If you are using Ubuntu2024 and have issues starting bitbake use: sudo apparmor_parser -R /etc/apparmor.d/unprivileged_userns

## Maintainers

* Flaviu Nistor `<flaviu.nistor at gmail.com>`

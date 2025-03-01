SUMMARY = "Build and install can-box aplication."
DESCRIPTION = "This application is designed to run as a server and communicate over UART with \
a client side desktop GUI application. This will transform the board into a can-box and provide \
basic CAN-FD functionality."
LICENSE = "CLOSED"

LIC_FILES_CHKSUM = ""
BB_STRICT_CHECKSUM = "0"
TARGET_CC_ARCH += "${LDFLAGS}"

DEPENDS = "libsocketcan libusb1"
RDEPENDS:${PN} = "libsocketcan libusb1"

SRCREV = "${AUTOREV}" 
SRC_URI = "git://github.com/FlaviuNistor/can-box.git;branch=development;protocol=https"
S = "${WORKDIR}/git"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
DEBUG_BUILD = "1"
# The autotools configuration I am basing this on seems to have a problem with a race condition when parallel make is enabled
PARALLEL_MAKE = ""

inherit autotools
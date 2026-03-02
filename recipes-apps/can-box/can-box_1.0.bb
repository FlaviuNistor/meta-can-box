SUMMARY = "Build and install can-box aplication."
DESCRIPTION = "This application is designed to run as a server and communicate over Ethernet with a client \
via websockets. This will transform the board into a can-box and provide basic CAN-FD functionality."
LICENSE = "CLOSED"

LIC_FILES_CHKSUM = ""
BB_STRICT_CHECKSUM = "0"

inherit allarch

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/FlaviuNistor/can-box.git;protocol=https;branch=development"

S = "${WORKDIR}/git"
SERVER_DESTINATION = "/opt/can-box"

do_install(){  
    install -d ${D}${SERVER_DESTINATION}
    cp -r ${S}/. ${D}${SERVER_DESTINATION}/
    chmod -R 755 ${D}${SERVER_DESTINATION}
}

FILES:${PN} += "${SERVER_DESTINATION}"

# As it likely to be a different arch from the Yocto build, disable checking by adding "arch" to INSANE_SKIP
INSANE_SKIP:${PN} += "arch"
INSANE_SKIP:${PN}-dbg += "arch"
INSANE_SKIP:${PN} += "file-rdeps"

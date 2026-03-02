SUMMARY = "Startup files for can-box aplication."
DESCRIPTION = "Systemd needed service to start a script that configures CAN interface \
and start the can-box application after NETWORK."
LICENSE = "CLOSED"

inherit systemd
inherit allarch

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "can-box.service" 

SRC_URI = "file://can-box.service \
"
SCRIPT_DESTINATION = "/opt/can-box"

do_install:append(){  
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/can-box.service ${D}${systemd_system_unitdir}
}

FILES:${PN} += "\
        ${systemd_system_unitdir}/can-box.service \
"

# As it likely to be a different arch from the Yocto build, disable checking by adding "arch" to INSANE_SKIP
INSANE_SKIP:${PN} += "arch"
INSANE_SKIP:${PN}-dbg += "arch"
INSANE_SKIP:${PN} += "file-rdeps"

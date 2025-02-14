FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

CMDLINE += "quiet logo.nologo modules-load=dwc2,g_serial"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

CMDLINE += "quiet logo.nologo vt.global_cursor_default=0 modules-load=dwc2,g_serial"
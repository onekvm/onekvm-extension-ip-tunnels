HOMEPAGE = "https://github.com/onekvm/onekvm-extension-ip-tunnels"
SUMMARY = "Optional OneKVM IP tunnel environment"
DESCRIPTION = "Installs GRE, IPIP, SIT, VXLAN, GENEVE, FOU and BareUDP kernel support. Configure interfaces in OneKVM Network settings; no resident service is needed."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c79ff39f19dfec6d293b95dea7b07891"
PR = "r2"

ONEKVM_COMPONENT_GIT_URI ??= "git://github.com/onekvm/onekvm-extension-ip-tunnels.git;protocol=https;branch=main"
ONEKVM_COMPONENT_SRCREV ??= ""

SRC_URI = "${ONEKVM_COMPONENT_GIT_URI}"
SRCREV = "${ONEKVM_COMPONENT_SRCREV}"
COMPATIBLE_MACHINE = "^onekvm-"

inherit onekvm-extension

ONEKVM_EXTENSION_ID = "ip-tunnels"
ONEKVM_EXTENSION_API_VERSION = "2"
ONEKVM_EXTENSION_MANIFEST_TEMPLATE = "${S}/manifest.json.in"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    oe_runmake install DESTDIR=${D} PREFIX=${ONEKVM_EXTENSION_ROOT} VERSION=${PV} ARCH=${TARGET_ARCH}
}

ALLOW_EMPTY:${PN}-dbg = "1"

# The signed module package remains separate and must match the device kernel.
# The extension host accepts onekvm-kernel-module-* feed dependencies.
RDEPENDS:${PN} += "onekvm-kernel-module-ip-tunnels"

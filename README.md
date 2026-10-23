# OneKVM ip-tunnels extension

Installs GRE, IPIP, SIT, VXLAN, GENEVE, FOU and BareUDP kernel support. Configure interfaces in OneKVM Network settings; no resident service is needed.

The manifest, health command, assets, and payload installation rules belong to
this repository. `oe-recipes/` contains its OpenEmbedded layer; the distro pins
both source and layer with `kas/components.lock`.

Build the IPK from `onekvm-distro`:

```sh
make ONEKVM_MACHINE=onekvm-nanokvm build extension ip-tunnels
```

To stage the payload locally:

```sh
make install DESTDIR=/tmp/onekvm-ip-tunnels-stage PREFIX=/data/onekvm/apps/ip-tunnels/0.1.0 VERSION=0.1.0 ARCH=riscv64
```

The extension remains disabled by default. OneKVM settings own configuration;
the health command does not change network interfaces or firewall policy.

License: `GPL-3.0-only` for the extension; MIT for OE layer metadata.

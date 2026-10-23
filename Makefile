PREFIX ?= /usr/local/lib/onekvm/extensions/ip-tunnels
VERSION ?= 0.1.0
ARCH ?= unknown

.PHONY: install
install:
	install -d $(DESTDIR)$(PREFIX)/bin
	install -m 0755 onekvm-ip-tunnels $(DESTDIR)$(PREFIX)/bin/onekvm-ip-tunnels
	sed -e 's/@VERSION@/$(VERSION)/g' -e 's/@ARCH@/$(ARCH)/g' manifest.json.in > $(DESTDIR)$(PREFIX)/manifest.json
	chmod 0644 $(DESTDIR)$(PREFIX)/manifest.json

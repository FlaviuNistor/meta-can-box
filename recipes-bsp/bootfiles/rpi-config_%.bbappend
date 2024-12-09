do_deploy:append() {
    echo "# Disable Bluetooth" >> $CONFIG
    echo "dtoverlay=disable-bt" >> $CONFIG

    echo "# Enable SPI" >> $CONFIG
    echo "dtparam=spi=on" >> $CONFIG

    echo "# Enable Seeed CAN Hat " >> $CONFIG
    echo "dtoverlay=seeed-can-fd-hat-v1" >> $CONFIG

    echo "# Enable USB interface " >> $CONFIG
    echo "dtoverlay=dwc2" >> $CONFIG
    echo "dr_mode=host" >> $CONFIG
}
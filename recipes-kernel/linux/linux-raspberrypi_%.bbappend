# The dtbo gets compiled based on the kernel repo Makefile
# Make sure the dtbo is copied in the deploy folder
RPI_KERNEL_DEVICETREE_OVERLAYS:append = " overlays/seeed-can-fd-hat-v1.dtbo"
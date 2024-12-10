# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

#IMAGE_INSTALL:append = " \ 
#			nano \
#"

# Make sure the dtbo is copied in the wic file
RPI_KERNEL_DEVICETREE_OVERLAYS:append = " overlays/seeed-can-fd-hat-v1.dtbo"

# Define a variable to hold the list of systemd unit config files to be modified.
# Modify the video console config files.
LOCAL_GETTY := " \
     ${IMAGE_ROOTFS}${systemd_system_unitdir}/getty@.service \
"
# Define a function that modifies the systemd unit config files with the autologin arguments
local_autologin () {
	sed -i -e 's/^\(ExecStart *=.*getty \)/\1--autologin root /' ${LOCAL_GETTY}
}

# Add the function so that it is executed after the rootfs has been generated
ROOTFS_POSTPROCESS_COMMAND += "local_autologin; "
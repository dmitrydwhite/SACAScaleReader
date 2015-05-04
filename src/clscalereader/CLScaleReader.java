/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clscalereader;

import java.util.List;

import javax.usb.UsbConfiguration;
import javax.usb.UsbConst;
import javax.usb.UsbControlIrp;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbInterface;
import javax.usb.UsbInterfacePolicy;

/**
 *
 * @author dmitry_white
 */
public class CLScaleReader {
    
    public ScaleDevice connectedScale;

    /**
     * Constructor setting instance variable
     */
    public CLScaleReader() {
        this.connectedScale = new ScaleDevice((short) 0x8002, (short) 0x5a5c);
    }
    
    public UsbDevice findScale (UsbHub hub) {
        UsbDevice scale;
        
        for (UsbDevice device : (List<UsbDevice>) hub.getAttachedUsbDevices()) {
            if (device.isUsbHub()) {
                scale = findScale((UsbHub) device);
                if (scale != null) return scale;
            }
            else {
                UsbDeviceDescriptor descriptor = device.getUsbDeviceDescriptor();
                if (descriptor.idVendor() == this.connectedScale.getVendorId() &&
                    descriptor.idProduct() == this.connectedScale.getProductId()) {
                return device;
            }
            }
        }
        
        return null;
    }
    
    public void setNewScale(short idVendor, short idProduct) {
        ScaleDevice updatedScale = new ScaleDevice (idVendor, idProduct);
        this.connectedScale = updatedScale;
    }
    
    /**
     * @param args the command line arguments
     * @throws javax.usb.UsbException
     */
    public static void main(String[] args) throws UsbException {
        // Check for the scale we think we want.
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clscalereader;

/**
 *
 * @author dmitry_white
 */
public class ScaleDevice {
    /**
     * Private variables for the scale device
     */
    private short idVendor;
    private short idProduct;
    
    /**
     * Constructor with Vendor ID and Product ID
     * @param idVendor
     * @param idProduct 
     */
    public ScaleDevice (short idVendor, short idProduct) {
        this.idVendor = idVendor;
        this.idProduct = idProduct;
    }
    
    /**
     * Getter for Vendor ID
     * @return Vendor ID
     */
    public short getVendorId () {
        return this.idVendor;
    }
    
    /**
     * Getter for Product ID
     * @return Product ID
     */
    public short getProductId () {
        return this.idProduct;
    }
    
    /**
     * Method to retrieve both Vendor ID and Product ID
     * @return Array[VendorID, ProductID] as shorts
     */
    public short[] getScaleDeviceInfo () {
        short[] deviceInfo = new short[2];
        deviceInfo[0] = this.idVendor;
        deviceInfo[1] = this.idProduct;
        
        return deviceInfo;
    }
}

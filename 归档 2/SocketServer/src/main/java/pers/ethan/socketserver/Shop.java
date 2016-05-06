package pers.ethan.socketserver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Shop implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3929874464784178981L;
	private ShopMaster shopMaster;

	public ShopMaster getShopMaster() {
		return shopMaster;
	}

	public void setShopMaster(ShopMaster shopMaster) {
		this.shopMaster = shopMaster;
	}
	
	public static void main(String args[]){
		Shop shop1 = new Shop();
		ShopMaster shopMaster1 = new ShopMaster();
		shopMaster1.setName("Ethan");
		shop1.setShopMaster(shopMaster1);
		try {
			Shop shop2 = (Shop)deepCopy(shop1);
			System.out.println(shop1.getShopMaster().getName());
			System.out.println(shop2.getShopMaster().getName());
			shop2.getShopMaster().setName("Echo");
			System.out.println(shop1.getShopMaster().getName());
			System.out.println(shop2.getShopMaster().getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object deepCopy(Shop shop) throws IOException, ClassNotFoundException{
		byte[] bytes = seriliaze(shop);
		Object object = deseriliaze(bytes);
		return object;
	}
	
	public static byte[] seriliaze(Object object) throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        return baos.toByteArray();
    }
	
	public static Object deseriliaze(byte[] byteArray) throws IOException, ClassNotFoundException{
        ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }
	
}

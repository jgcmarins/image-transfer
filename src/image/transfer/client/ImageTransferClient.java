
/*
* 
* Sun Apr 19 21:31:48 BRT 2015
* author: Joao Gustavo Cabral de Marins
* e-mail: jgcmarins@gmail.com
* 
*/

package image.transfer.client;

import java.net.Socket;
import java.io.InputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.Scanner;

public class ImageTransferClient {

	private String server;
	private int port;
	private String imagename;

	ImageTransferClient(String server, int port, String imagename) {
		this.server = server;
		this.port = port;
		this.imagename = imagename;
	}

	public void Transfer() {
		try {
			Socket s = new Socket(this.server, this.port);
			InputStream is = s.getInputStream();

			Scanner reader = new Scanner(is);
			System.out.print(reader.nextLine());

			BufferedImage bi = ImageIO.read(is);

			s.close();

			ImageIO.write(bi, "jpg", new File(this.imagename));
		} catch(Exception e) { e.printStackTrace(); }
	}

	public static void main(String args[]) {
		ImageTransferClient itc = new ImageTransferClient("localhost", 12345, "clientside/kobe.jpg");
		itc.Transfer();
	}
}

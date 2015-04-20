
/*
* 
* Sun Apr 19 20:55:05 BRT 2015
* author: Joao Gustavo Cabral de Marins
* e-mail: jgcmarins@gmail.com
* 
*/

package image.transfer.server;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.OutputStream;
import java.io.PrintWriter;

public class ImageTransferServer {

	private String filename;
	private int port;

	public ImageTransferServer(String filename, int port) {
		this.filename = filename;
		this.port = port;
	}

	public void Transfer() {
		try {
			ServerSocket ss = new ServerSocket(this.port);
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();

			BufferedImage bi = ImageIO.read(new File(this.filename));

			PrintWriter pw = new PrintWriter(os, true);
			pw.println("Image is ready!");

			ImageIO.write(bi, "jpg", os);

			s.close();
			ss.close();
		} catch(Exception e) { e.printStackTrace(); }
	}

	public static void main(String args[]) {
		ImageTransferServer its = new ImageTransferServer("serverside/kobe.jpg", 12345);
		its.Transfer();
	}
}

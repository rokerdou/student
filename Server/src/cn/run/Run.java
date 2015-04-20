package cn.run;

import java.io.FileNotFoundException;
import java.io.IOException;

import cn.domain.Config;
import cn.net.Service;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			Config scon = new Config("Service.properties");
			System.out.println(scon.getInt("ServerPort"));
			Service ser = new Service(scon.getInt("ServerPort"));
			try {
				ser.OpenService();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

}

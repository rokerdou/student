package cn.domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	  private Properties serconfig = new Properties();
	  private static Config in;

	  public Config()
	  {
	  }

	  public Config(String filename)
	 
	  {
	    String path = System.getProperty("user.dir") + "\\" + filename;

			try {
				this.serconfig.load(new FileInputStream(path));
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    in = this;
	  }

	  public Config getInstance()
	  {
	    return in;
	  }

	  public int getInt(String name)
	  {
	    return Integer.parseInt(this.serconfig.getProperty(name));
	  }
	  public String getString(String name)
	  
	  {
		  return   (this.serconfig.getProperty(name));
	  }
}

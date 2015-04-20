package cn.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Service   extends Thread
{
	  private ServerSocket server;
	  public static int l = 0;
	  private final ExecutorService pool;
	  private int port;

	  public Service(int ports)
	  {
	    try
	    {
	     port=ports;
	      this.server = new ServerSocket(port);

	      this.pool = Executors.newCachedThreadPool();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("服务器初始化失败");
	    }
	  }

	  public boolean check()
	  {
	    return true;
	  }

	  public void OpenService() throws IOException 
	  {
	    try {
	    	System.out.println("服务器端口号:"+port);
	      this.server = new ServerSocket(123);
	      
	      this.start();
	   
	    }
	    catch (IOException e)
	    {
	      throw new IOException("端口号被占用");
	    }
	  }

	  public void run()
	  {
	    while (true)    
	      {
	        Socket ss = null;
			try {
				ss = this.server.accept();
				this.pool.execute(new Handler(ss));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} l += 1;
	        System.out.println("人来了" + l);
	        
	      }

	  }
	}
package cn.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import cn.domain.Message;
import cn.domain.MessageData;

public class Handler extends Thread{
	  private Socket client;
	  private DbManger db= DbManger.getInstance();
	  private Message msg=null;

	public Handler(Socket ss)
	  {
	    this.client = ss;
	  }
	@Override
	public void run() {
	      try {
			ObjectInputStream ois = new ObjectInputStream(this.client.getInputStream());
		      ObjectOutputStream oos = new ObjectOutputStream(
		  	        this.client.getOutputStream());
				this.msg = ((Message)ois.readObject());
				if(msg.State==MessageData.REQUEST_LOGIN)
				{
					Message respose = db.Login(msg.user, msg.password, msg.LoginType);
				      oos.writeObject(respose);
				      oos.flush();
					
				}
				if(msg.State==MessageData.REQUEST_ADDSTU)
				{
					Message respose = db.AddnewStu(msg.stu);
				      oos.writeObject(respose);
				      oos.flush();
				}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      finally
	      {
	    	  msg=null;
	      }

	}

}

package udemy.ds.arrays;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.GregorianCalendar;

public class ArraySample {

	public static void main(String[] args) {
		int[] intArray = new int[7];
		
		intArray[0] = 10;
		intArray[1] = 35;
		intArray[2] = -15;
		intArray[3] = 22;
		intArray[4] = -3;
		intArray[5] = 55;
		intArray[6] = 90;
		
		for(int i = 0; i < intArray.length; i ++)
			System.out.println(intArray[i]);
	
		/* try {
		      String ipAddress = "54.241.84.17";
		      InetAddress inet = InetAddress.getByName(ipAddress);
		     
		 
		      System.out.println("Sending Ping Request to " + inet.getHostAddress());
		 
		      long finish = 0;
		      long start = new GregorianCalendar().getTimeInMillis();
		 
		      if (inet.isReachable(5000)){
		        finish = new GregorianCalendar().getTimeInMillis();
		        System.out.println("Ping RTT: " + (finish - start + "ms"));
		      } else {
		        System.out.println(ipAddress + " NOT reachable.");
		      }
		    } catch ( Exception e ) {
		      System.out.println("Exception:" + e.getMessage());
		    }
	*/
		/*boolean vpnStatus;
		
		try {
            Socket dummySocket =  new Socket();
            dummySocket.connect(new InetSocketAddress("sa-east-1.apsiwifi.com", 8192),5000);
            dummySocket.close();
            vpnStatus = true;
        } catch (Exception e) {
        	e.printStackTrace();
            vpnStatus = false;
        }
	
		System.out.println("vpnStatus " + vpnStatus);*/
	}

}

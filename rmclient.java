import java.io.*;
import java.net.*;
public class rmclient
{
  public static void main(String args[])throws IOException
  {
         Socket s=null;
         String comd;
         s=new Socket("localhost",3000);
         System.out.println("\nClient Ready...\n");
         System.out.println("\nServer socket connected...\n");
         BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
         OutputStream os=s.getOutputStream();
         DataOutputStream ot=new DataOutputStream(os);
         InputStream is=s.getInputStream();
         DataInputStream ins=new DataInputStream(is);
         System.out.println("Enter the command to be executed ?  ");
         comd=br.readLine();
         //ot.write(comd.getBytes());
         ot.writeUTF(comd);
        // ot.flush();
         //System.out.println(" send");
         String st=new String(ins.readUTF());
         System.out.println(" "+st);
         String err=new String(ins.readUTF());
         System.out.println("Exited with error code "+err); 
         os.close();
         ot.close();
         is.close();
         ins.close();
         s.close();
 }
   
}

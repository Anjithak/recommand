import java.io.*;
import java.lang.*;
import java.net.*;
public class rmserver
{
  public static void main(String args[])throws IOException
  {
     String com,line,str=" ";
     ServerSocket ss=new ServerSocket(3000);
     System.out.println("\nServer Ready...\n");
     Socket s=ss.accept();
     System.out.println("Client socket connected...\n");
     InputStream is=s.getInputStream();
     DataInputStream ins=new DataInputStream(is);
     DataOutputStream out=new DataOutputStream(new DataOutputStream(s.getOutputStream()));
     com=ins.readUTF();
     System.out.println(com+" command is executing...\n");
     Process p=null;
     try{
          Runtime rt=Runtime.getRuntime();
          p=rt.exec(com);
          //System.out.println(com+" command is executing...\n");
	  BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
           while ((line = input.readLine()) != null) {
               // System.out.println(line);
              str+=line+"\n";
            }
        out.writeUTF(str);
        int exitVal = p.waitFor();
         out.writeUTF(" "+exitVal);
         }
      catch(Exception e)
       {
         System.out.println("Error : "+e);
       }
      ins.close();
      is.close();
      out.close();
      s.close();
      ss.close();
    }
}

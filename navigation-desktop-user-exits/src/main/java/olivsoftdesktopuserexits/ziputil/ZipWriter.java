package olivsoftdesktopuserexits.ziputil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipWriter
{
  public static void zip(String orig, String into) throws Exception
  {
    FileOutputStream fos = new FileOutputStream(into);
    ZipOutputStream zos  = new ZipOutputStream(fos);
    
    ZipEntry ze = new ZipEntry(orig);
    
    zos.putNextEntry(ze);
    FileInputStream fin = new FileInputStream(orig);
    copy(fin, zos);
    zos.closeEntry();
    fin.close();
    
    zos.close();
  }
 
  public static void copy(InputStream is, OutputStream os) throws IOException
  {
    synchronized (is)
    {
      synchronized (os)
      {
        byte[] buffer = new byte[256];
        while (true)
        {
          int bytesRead = is.read(buffer);
          if (bytesRead == -1)
            break;
          os.write(buffer, 0, bytesRead);
        }
      }
    }
  }
}

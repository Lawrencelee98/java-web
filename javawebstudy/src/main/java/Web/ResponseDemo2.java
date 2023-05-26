package Web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/pic")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileInputStream fis = new FileInputStream("D:\\MyLab\\javawebstudy\\src\\main\\pic\\hacker.png");
        ServletOutputStream os = resp.getOutputStream();
        int len = 0;
        byte[] buff = new byte[1024];
        while((len = fis.read(buff))!=-1){
            os.write(buff,0, len);
        }
        fis.close();
    }
}

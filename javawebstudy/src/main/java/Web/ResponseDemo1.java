package Web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseDemo1 extends HttpServlet {
/*
    1. PrintWriter getWriter() 获取字符输出流
    2. ServletOutputStream getOutputStream() 获取字节输出流
 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置状态码
        resp.setStatus(302);
        // 2. 设置头
//        resp.setHeader("Location", "/params");
//        resp.setHeader("content-type", "text/html");
        // 解决response中文乱码问题，需要设置charset
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.write("<h1>aaa</h1>");
        pw.write("<h1>你好</h1>");
    }
}

package Web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet(urlPatterns = "/params")
public class RequestParams extends HttpServlet {
/*
String GetMethod()
String getContextPath() 获取虚拟目录
StringBuffer getRequestURL() 获取URL
String getReqeustURI() 获取URI
String getQueryString() 获取Get请求参数
String getHeader(String name) 根据请求头获取值
ServletInputStream getInputStream() 获取字节流输入流
BufferedReader getReader() 获取字符输入流
*/

/*
通用获取参数方法啊
Map<String, Sting[]> getParameterMap() 获取所有参数Map集合
String[] getParameterValues(String name) 获取单个参数的值，值是数组
String getParameter(String name) 获取单个此参数的值，值只有一个
 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get/Post ....");
        // 解决Post中文乱码
        req.setCharacterEncoding("UTF-8");

        // 解决Get中文乱码
        // 原因是，tomcat进行url解码，默认解码字符集为ISO—8559-1
        String name = req.getParameter("name");
        // 1. 先将数据转化为字节数据
        byte[] name_bytes = name.getBytes(StandardCharsets.ISO_8859_1);
        // 2. 再将字节数据转换为utf-8编码
        name = new String(name_bytes, StandardCharsets.UTF_8);
        System.out.println("name: "+name);

        System.out.println("-------------");

        String[] hobys = req.getParameterValues("hoby");
        for(String hoby : hobys){
            System.out.println(hoby);
        }

        Map<String, String[]> map = req.getParameterMap();
        for(String key : map.keySet()){
            System.out.print(key + ":");
            String[] values = map.get(key);
            for(String value : values){
                System.out.println(value);
            }
        }
        System.out.println("-------------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
        // 解决Post请求中文乱码的问题，由于使用BufferReader的编码有问题，所以无法显示中文
        // 只需要重新设置一下编码格式就行
        // req.setCharacterEncoding("UTF-8");

        // Tomcat8 之后的版本已经可以自动解析UTF-8，所以不会再出现乱码的问题

    }
}

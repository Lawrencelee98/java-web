package Web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
// 用Servlet 接口来实现web服务

//@param:1.loadOnStartup:
//负数的话servlet是在第一次被访问的时候创建，0以上的话是服务器开始运行就创建。
@WebServlet("/interface")
public class ServletInterface implements Servlet {
    /*
        1.初始化方法
        2.默认情况下Servlet第一次被访问时调用

     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(">>>initing...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /*
        内存释放或者服务器销毁时调用，用于销毁servlet对象
    */
    @Override
    public void destroy() {

    }
}

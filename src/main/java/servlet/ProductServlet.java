package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;
import product.ProductTest;
import product.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "ProductServlet", urlPatterns =  "/product")
public class ProductServlet  implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);
    private transient ServletConfig config;


    // Метод вызывается контейнером после того как был создан класс сервлета
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // Сохраняем полученную от сервера конфигурацию
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }


    // Метод вызывается для каждого нового HTTP запроса к данному сервлету
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("Request");
        servletResponse.getWriter().println("<h1>Servlet content</h1>");
        List<Product> list = ProductTest.listOfProduct(10);
        for (Product prod:list
             ) {
            servletResponse.getWriter().println("<h1>" +  prod.toString() +"</h1>");
        }

    }

    @Override
    public String getServletInfo() {
        return "ProductServlet";
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }
}

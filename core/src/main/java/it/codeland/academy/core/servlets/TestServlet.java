package it.codeland.academy.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Iterator;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/products")
public class TestServlet extends SlingAllMethodsServlet {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ResourceResolver resolver = request.getResourceResolver();
        Page page = resolver.adaptTo(PageManager.class).getPage("/content/academy-issa/us/en/home-page");
        logger.info("Error here {}",page);
        Iterator<Page> pageList = page.listChildren();
        JSONArray products = new JSONArray();

        while (pageList.hasNext()){
            Page currentPage = pageList.next();
        JSONObject product = new JSONObject();
        try {
            product.put("name",currentPage.getTitle());
            product.put("image","https://cdn-images.farfetch-contents.com/15/62/34/42/15623442_28152563_600.jpg");
            product.put("Description",currentPage.getDescription()!= null ? currentPage.getDescription(): "Not provided");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        products.put(product);
        }


        response.setContentType("application/json");
        response.getWriter().write(products.toString());
    }
}

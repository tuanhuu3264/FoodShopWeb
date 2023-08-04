package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/admin.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("    \r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"float-left\">\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"logo\"><img class=\"image-logo\" src=\"images/Artboard 1.png\" alt=\"\"></div>\r\n");
      out.write("          \r\n");
      out.write("            <div class=\"categories\"><a href=\"\">Dashboard</a> <i class=\"fa fa-home \"></i></div>\r\n");
      out.write("            <div class=\"categories\"><a href=\"\">Product</a> <i class=\"fa fa-shopping-bag\"></i></div>\r\n");
      out.write("            <div class=\"categories\"><a href=\"\">Manage account</a> <i class=\"fa fa-users\"></i></div>\r\n");
      out.write("            <div class=\"categories\"><a href=\"\">Order</a> <i class=\"fa fa-cart-plus\"></i></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"float-right\">\r\n");
      out.write("            \r\n");
      out.write("             <div class=\"login\">\r\n");
      out.write("                <div class=\"search-item\">\r\n");
      out.write("                    <input type=\"text\" placeholder=\"Search\" class=\"search\">\r\n");
      out.write("                    <button type=\"submit\" class=\"button-search\"><i class=\"fa fa-search\"></i></button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"two-items\">\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <a href=\"\">Hi admin</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <div>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-user-circle account-user\"> Account</i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>                       \r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-arrow-circle-right\"> Logout</i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("               \r\n");
      out.write("             </div>\r\n");
      out.write("             <div>\r\n");
      out.write("\r\n");
      out.write("             </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

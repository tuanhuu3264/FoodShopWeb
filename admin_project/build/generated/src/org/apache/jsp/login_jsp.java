package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("    <title>Document</title>\n");
      out.write("</head>\n");
      out.write("<body  >\n");
      out.write("    <form class=\"login\" action=\"login\" method=\"get\">\n");
      out.write("        <div class=\"logo\">\n");
      out.write("            <img src=\"images/Artboard 1.png\" alt=\"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"title\">\n");
      out.write("            <h1>Sign in</h1>\n");
      out.write("        </div>\n");
      out.write("        <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("        <div class=\"input-container\">       \n");
      out.write("          <input type=\"text\" id=\"username\" name=\"username\" placeholder=\"Username\">\n");
      out.write("          <i class=\"fa fa-user\"></i>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"input-container\">\n");
      out.write("         \n");
      out.write("          <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Password\">\n");
      out.write("          <i class=\"fa fa-lock\"></i>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"remember-me\">\n");
      out.write("          <input type=\"checkbox\" id=\"remember\" name=\"remember\">\n");
      out.write("          <label for=\"remember\">Remember me</label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"signin\">\n");
      out.write("            <button type=\"submit\"><i class=\"fa fa-arrow-circle-right\"> Sign in</i></button>      \n");
      out.write("        </div>\n");
      out.write("        <div class=\"signup\">        \n");
      out.write("          <button><i class=\"fa fa-user-plus\"> \n");
      out.write("            <a href=\"register.jsp\">Sign up New Account</a>\n");
      out.write("        </i></button>\n");
      out.write("        </div>\n");
      out.write("         \n");
      out.write("      </form>\n");
      out.write("</body>\n");
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

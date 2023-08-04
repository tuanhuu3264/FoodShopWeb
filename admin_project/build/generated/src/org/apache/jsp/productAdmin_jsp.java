package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class productAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/admin.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/productAdmin.css\">\n");
      out.write("    <title>Document</title>\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("       <div class=\"float-left\">\n");
      out.write("            <div class=\"logo\"><img class=\"image-logo\" src=\"images/no background.png\" alt=\"\"></div>\n");
      out.write("            <button class=\"categories\"><a href=\"\">Account <i class=\"fa fa-user\"></i></a></button>\n");
      out.write("            <button class=\"categories\"><a href=\"dashboard\">Dashboard</a> <i class=\"fa fa-home \"></i></button>\n");
      out.write("            <button class=\"categories\"><a href=\"productaction\">Product</a> <i class=\"fa fa-shopping-bag\"></i></button>\n");
      out.write("            <button class=\"categories\"><a href=\"outstock\">Out Of Stock</a> <i class=\"fa fa-shopping-bag\"></i></button>\n");
      out.write("            <button class=\"categories\"><a href=\"account\">Manage account</a> <i class=\"fa fa-users\"></i></button>\n");
      out.write("            <button class=\"categories\"><a href=\"order\">Order</a> <i class=\"fa fa-cart-plus\"></i></button>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"float-right\">\n");
      out.write("            \n");
      out.write("             <div class=\"login\">\n");
      out.write("                <div class=\"search-item\">\n");
      out.write("                 <form action=\"productaction\" method=\"post\">\n");
      out.write("                     <input type=\"hidden\" name=\"action\" value=\"search\">\n");
      out.write("                     <input type=\"text\" placeholder=\"Search\" class=\"search\" name=\"search\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.search}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <button class=\"button-search\"><i class=\"fa fa-search\"></i></button>\n");
      out.write("                </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"two-items\">\n");
      out.write("                    <div>\n");
      out.write("                        <a href=\"\">Hi admin</a>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div>\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-user-circle account-user\"> Account</i></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div>                       \n");
      out.write("                        <a href=\"\"><i class=\"fa fa-arrow-circle-right\"> Logout</i></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("               \n");
      out.write("             </div>\n");
      out.write("             <div>\n");
      out.write("                 <form action=\"productaction\" method=\"post\">\n");
      out.write("                     <input type=\"hidden\" value=\"create\" name=\"action\">\n");
      out.write("                 <button class=\"create\">Create</button>\n");
      out.write("                 </form>\n");
      out.write("                 <div class=\"item\">\n");
      out.write("                     <div class=\"item-list\">\n");
      out.write("                        <table class=\"table-list\">\n");
      out.write("                            <tr class=\"name-colums\">\n");
      out.write("                                <th>ID</th>\n");
      out.write("                                <th>Name</th>\n");
      out.write("                                <th>Image</th>\n");
      out.write("                                <th>Price</th>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            \n");
      out.write("                        </table>\n");
      out.write("                     </div>\n");
      out.write("                </div>\n");
      out.write("                 \n");
      out.write("             </div>\n");
      out.write("             </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("<div>\n");
      out.write("   \n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.listP}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("o");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.getImagepath()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" style=\"width:140px; height: 140px;\"></td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.getPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td class=\"button\">\n");
          out.write("                                    <form action=\"productaction\" method=\"post\">\n");
          out.write("                                        <input type=\"hidden\" value=\"outstock\" name=\"action\" >\n");
          out.write("                                        <input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"sid\">\n");
          out.write("                                    <button class=\"delete\" style=\"display:inline-block\">Out Stock</button>\n");
          out.write("                                    </form>\n");
          out.write("                                    \n");
          out.write("                                    \n");
          out.write("                                </td>\n");
          out.write("                                <td>\n");
          out.write("                                    <form action=\"update\" method=\"post\">\n");
          out.write("                                        <input type=\"hidden\" value=\"update\" name=\"action\">\n");
          out.write("                                        <input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"sid\">\n");
          out.write("                                    <button class=\"update\" style=\"display:inline-block\">Update</button>\n");
          out.write("                                    </form>\n");
          out.write("                                </td>\n");
          out.write("                             </tr>\n");
          out.write("                             ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}

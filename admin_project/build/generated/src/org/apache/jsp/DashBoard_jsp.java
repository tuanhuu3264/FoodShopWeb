package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DashBoard_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/admin.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/dist/apexcharts.css\">    \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/dashboard.css\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"float-left\">\r\n");
      out.write("            <div class=\"logo\"><img class=\"image-logo\" src=\"images/no background.png\" alt=\"\"></div>\r\n");
      out.write("         \r\n");
      out.write("            <button class=\"categories\"><a href=\"dashboard\">Dashboard</a> <i class=\"fa fa-home \"></i></button>\r\n");
      out.write("            <button class=\"categories\"><a href=\"product\">Product</a> <i class=\"fa fa-shopping-bag\"></i></button>\r\n");
      out.write("            <button class=\"categories\"><a class=\"out-of-stock\" href=\"outstock\">Out Of Stock</a> <i class=\"fa fa-shopping-bag\"></i></button>\r\n");
      out.write("            <button class=\"categories\"><a href=\"account\">Manage account</a> <i class=\"fa fa-users\"></i></button>\r\n");
      out.write("            <button class=\"categories\"><a href=\"order\">Order</a> <i class=\"fa fa-cart-plus\"></i></button>\r\n");
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
      out.write("            <div class=\"list-box\">\r\n");
      out.write("             <div class=\"boxDash\">\r\n");
      out.write("                <h2>Year's Revenue</h2>\r\n");
      out.write("                <p style=\"font-size: 150%; font-weight: bold;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.yearrevenue}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("            </div>\r\n");
      out.write("             \r\n");
      out.write("             <div class=\"boxDash\">\r\n");
      out.write("                <h2>Month's Revenue</h2>\r\n");
      out.write("                <p style=\"font-size: 150%; font-weight: bold;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.monthrevenue}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"boxDash\">\r\n");
      out.write("                <h2>Month's Refused</h2>\r\n");
      out.write("                <p style=\"font-size: 150%; font-weight: bold;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.refusedOrder}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"charts\">\r\n");
      out.write("                <div class=\"chart-card\"> \r\n");
      out.write("                     <div id=\"columnChart\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"chart-card\">\r\n");
      out.write("                     <div id=\"areaChart\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/apexcharts\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("var data = [];\r\n");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("var quantities = data.map(function(item) {\r\n");
      out.write("  return item.quantity;\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var names = data.map(function(item) {\r\n");
      out.write("  return item.name;\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var options = {\r\n");
      out.write("  series: [{\r\n");
      out.write("    name: 'Product',\r\n");
      out.write("    data: quantities\r\n");
      out.write("  }],\r\n");
      out.write("  chart: {\r\n");
      out.write("    type: 'bar',\r\n");
      out.write("    height: 350\r\n");
      out.write("  },\r\n");
      out.write("  plotOptions: {\r\n");
      out.write("    bar: {\r\n");
      out.write("      horizontal: false,\r\n");
      out.write("      columnWidth: '55%',\r\n");
      out.write("      endingShape: 'rounded'\r\n");
      out.write("    },\r\n");
      out.write("  },\r\n");
      out.write("  dataLabels: {\r\n");
      out.write("    enabled: false\r\n");
      out.write("  },\r\n");
      out.write("  stroke: {\r\n");
      out.write("    show: true,\r\n");
      out.write("    width: 2,\r\n");
      out.write("    colors: ['transparent']\r\n");
      out.write("  },\r\n");
      out.write("  xaxis: {\r\n");
      out.write("    categories: names\r\n");
      out.write("  },\r\n");
      out.write("  yaxis: {\r\n");
      out.write("    title: {\r\n");
      out.write("      text: 'Number Items'\r\n");
      out.write("    }\r\n");
      out.write("  },\r\n");
      out.write("  title: {\r\n");
      out.write("    text: 'Top 5 Products Bought',\r\n");
      out.write("    align: 'left'\r\n");
      out.write("  },\r\n");
      out.write("  fill: {\r\n");
      out.write("    colors: ['#093759'],\r\n");
      out.write("    opacity: 1\r\n");
      out.write("  },\r\n");
      out.write("  tooltip: {\r\n");
      out.write("    y: {\r\n");
      out.write("      formatter: function (val) {\r\n");
      out.write("        return  val + \" Items\";\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("  }\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("var chart = new ApexCharts(document.querySelector(\"#columnChart\"), options);\r\n");
      out.write("chart.render();\r\n");
      out.write("\r\n");
      out.write("// ---------Dashboard2------------//\r\n");
      out.write("var data2 = [];\r\n");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("var Times = data2.map(function(revenue) {\r\n");
      out.write("  return revenue.time;\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var Money = data2.map(function(revenue) {\r\n");
      out.write("  return revenue.money;\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var options2 = {\r\n");
      out.write("  series: [{\r\n");
      out.write("    name: \"Money($)\",\r\n");
      out.write("    data: Money\r\n");
      out.write("  }],\r\n");
      out.write("  chart: {\r\n");
      out.write("    height: 350,\r\n");
      out.write("    type: 'line',\r\n");
      out.write("    zoom: {\r\n");
      out.write("      enabled: false\r\n");
      out.write("    }\r\n");
      out.write("  },\r\n");
      out.write("  dataLabels: {\r\n");
      out.write("    enabled: false\r\n");
      out.write("  },\r\n");
      out.write("  stroke: {\r\n");
      out.write("    curve: 'straight',\r\n");
      out.write("    colors: ['#093759'] // Set purple color for the line\r\n");
      out.write("  },\r\n");
      out.write("  title: {\r\n");
      out.write("    text: 'Revenue by Month',\r\n");
      out.write("    align: 'left'\r\n");
      out.write("  },\r\n");
      out.write("  grid: {\r\n");
      out.write("    row: {\r\n");
      out.write("      colors: ['#f3f3f3', 'transparent'],\r\n");
      out.write("      opacity: 0.5\r\n");
      out.write("    }\r\n");
      out.write("  },\r\n");
      out.write("  xaxis: {\r\n");
      out.write("    categories: Times\r\n");
      out.write("  }\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("var chart2 = new ApexCharts(document.querySelector(\"#areaChart\"), options2);\r\n");
      out.write("chart2.render();\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.Tlist}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("o");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  var item = {\r\n");
          out.write("    name: '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("',\r\n");
          out.write("    quantity: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.getQuantity()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("  };\r\n");
          out.write("  data.push(item);\r\n");
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

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.revenues}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("o");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  var revenue = {\r\n");
          out.write("    time: '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ o.getTime()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("',\r\n");
          out.write("    money: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.getMoney()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("  };\r\n");
          out.write("  data2.push(revenue);\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}

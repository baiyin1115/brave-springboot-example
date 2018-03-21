package brave.springboot;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import brave.http.HttpTracing;
import brave.servlet.TracingFilter;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
@Slf4j
@WebFilter(urlPatterns = "/api/*", filterName = "wechatDelegatingTracingFilter")
public class WechatDelegatingTracingFilter implements Filter {

  @Autowired
  HttpTracing httpTracing;

  Filter delegate; // servlet ensures create is directly followed by init, so no need for volatile

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    Filter tracingFilter = delegate;
    if (tracingFilter == null) { // don't break on initialization error.
      chain.doFilter(request, response);
    } else {
      tracingFilter.doFilter(request, response, chain);
    }
  }

  @Override public void init(FilterConfig filterConfig) {
//    ApplicationContext ctx = getRequiredWebApplicationContext(filterConfig.getServletContext());
//    HttpTracing httpTracing = ctx.getBean(HttpTracing.class);;
    delegate = TracingFilter.create(httpTracing);
  }

  @Override public void destroy() {
    // TracingFilter is stateless, so nothing to destroy
  }
}

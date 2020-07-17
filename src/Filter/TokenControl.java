//package Filter;
//
//import Module.TokenTool;
//import org.apache.commons.lang.StringUtils;
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//
//
//public class TokenControl implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
//            throws IOException, ServletException{
//        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper((HttpServletRequest) request) {
//
//            @Override
//            public String getHeader(String name) {
//                // 先从原本的Request中获取头，如果为空且名字为token，则从参数中查找并返回
//                String superHeader = super.getHeader(name);
//                if("token".equals(name) && StringUtils.isEmpty(superHeader)){
//                    String token = request.getParameter("token");
//                    if (StringUtils.isNotEmpty(token)) {
//                        return token ;
//                    }
//                }
//                return superHeader;
//            }
//        };
//        filterChain.doFilter(requestWrapper,response);
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
//

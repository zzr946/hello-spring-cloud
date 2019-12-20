package com.zzr.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Zull的过滤功能
 * 此处模拟登录拦截
 */
@Component //交由容器管理
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤类型
     * 返回一个字符串代表过滤器的类型，在 Zuul 中定义了四种不同生命周期的过滤器类型
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     * 数值越小，执行越靠前
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要过滤
     * 返回true:需要，false:不需要
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取请求参数  通过RequestContext获得HttpServletRequest
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //通过 HttpServletRequest 获取请求参数值
        String token = request.getParameter("token");

        if(token==null){
            //如果请求参数为空，表示没有登录，则不进行路由转发，直接返回（拦截）
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);//设置返回的响应码 401：没有权限
            try {
                //设置响应字符串编码格式
                HttpServletResponse response=currentContext.getResponse();
                response.setContentType("text/html;charset=utf-8");

                //将响应字符串写在页面上
                currentContext.getResponse().getWriter().write("非法请求");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        return null;
    }
}

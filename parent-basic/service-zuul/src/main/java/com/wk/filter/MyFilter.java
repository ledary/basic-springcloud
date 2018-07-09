package com.wk.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.protocol.RequestContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wgp on 2018/7/7.
 */
public class MyFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(MyFilter.class);


    /*
    pre 路由之前
    routing 路由之时
    post  路由之后
    error  发送错误调用
    filterOrder：过滤的顺序
    shouldFilter 这里可以写逻辑判断，是否要过滤，为true永远过滤。
    run : 过滤器的具体逻辑，可用很复杂，包括sql,nosql去判断该请求到底有没有权限。
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s",request.getMethod(),
                request.getRequestURL().toString()));

        Object accessToken = request.getParameter("token");
        if(accessToken == null){
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            try{
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                return null;
            }
        }
        log.info("ok");
        return null;
    }
}

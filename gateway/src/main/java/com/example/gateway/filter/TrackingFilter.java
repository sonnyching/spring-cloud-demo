package com.example.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TrackingFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    public static final String CORRELATION_ID = "CORRELATION_ID";

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();

        logger.info("前往"+ctx.getRequest().getRequestURI()+"，来自："+ctx.getRequest().getRemoteHost());

        if(!isCorrelationIdPresent()){
            String id= generateCorrelationId();
            logger.info("没有关联ID,生成新id:"+id);
            ctx.addZuulRequestHeader(CORRELATION_ID,id);
        }else{
            logger.info("已存在关联ID,id:"+getCorrelationId());
        }

        return null;
    }

    private String generateCorrelationId(){
        return UUID.randomUUID().toString();
    }

    private String getCorrelationId(){
        RequestContext context = RequestContext.getCurrentContext();

        if(context.getRequest().getHeader(CORRELATION_ID) != null){
            return context.getRequest().getHeader(CORRELATION_ID);
        }else if(context.getZuulRequestHeaders().get(CORRELATION_ID) != null){
            return context.getZuulRequestHeaders().get(CORRELATION_ID);
        }

        return null;
    }

    private boolean isCorrelationIdPresent(){
        return getCorrelationId() != null;
    }


}

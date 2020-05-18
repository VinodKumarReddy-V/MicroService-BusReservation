package com.xyz.zuulbus;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulBusReservationFilter  extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		System.out.println("In Zuul filter ");
		
		RequestContext  rctx = RequestContext.getCurrentContext();
		HttpServletRequest req = rctx.getRequest();
		
		System.out.println(req.getMethod() + " " + req.getRequestURL().toString());
		System.out.println("Pre Filter "+ String.format("%s request to %s",req.getMethod(),req.getRequestURL().toString()));
		
		return null;
	}

	@Override
	public String filterType() {
		
		return "pre";  // There are pre /post options to get filter the urls Invoke ...
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}

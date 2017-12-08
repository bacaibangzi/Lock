package com.sc.framework.utils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class RedirectResponseWrapper extends HttpServletResponseWrapper
{
    private String redirect;

    public RedirectResponseWrapper(HttpServletResponse response)
    {
        super(response);
        // TODO Auto-generated constructor stub
    }

    public String getRedirect()
    {
        return redirect;
    }

    public void sendRedirect(String string)
    {
        this.redirect = string;
    }
}

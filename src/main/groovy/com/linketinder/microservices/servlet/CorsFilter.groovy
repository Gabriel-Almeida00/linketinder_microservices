package com.linketinder.microservices.servlet

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletResponse

@WebFilter("/*")
class CorsFilter implements Filter {
    @Override
    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response

        httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8080")
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE")
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization")

        chain.doFilter(request, response)
    }

    @Override
    void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    void destroy() {}
}

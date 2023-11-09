package com.linketinder.microservices.servlet

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import javax.servlet.http.HttpServletResponse

class ServletResponse {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()


    void writeResponse(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8")
        response.setContentType("application/json; charset=UTF-8")
    }

    void writeErrorResponse(HttpServletResponse response, int statusCode, String errorMessage) throws IOException {
        response.setStatus(statusCode)
        response.setCharacterEncoding("UTF-8")
        response.setContentType("application/json; charset=UTF-8")

        String errorResponse = "{ \"error\": \"" + errorMessage + "\" }"
        response.getWriter().write(errorResponse)
    }

    void methodGet(HttpServletResponse response, Object data) {
        try {
            writeResponse(response)
            response.setStatus(HttpServletResponse.SC_OK)

            String json = gson.toJson(data)
            try (PrintWriter out = response.getWriter()) {
                out.print(json)
            }
        } catch (Exception e) {
            writeErrorResponse(response, HttpServletResponse.SC_BAD_REQUEST, e.getMessage())
        }
    }

    void methodPost(HttpServletResponse response, Runnable operation) {
        try {
            writeResponse(response)
            operation.run()
            response.setStatus(HttpServletResponse.SC_CREATED)
        } catch (Exception e) {
            this.writeErrorResponse(response, HttpServletResponse.SC_BAD_REQUEST, e.getMessage())
        }
    }

    void methodPostLogin(HttpServletResponse response, Runnable operation) {
        try {
            writeResponse(response)
            operation.run()
            response.setStatus(HttpServletResponse.SC_OK)
        } catch (Exception e) {
            this.writeErrorResponse(response, HttpServletResponse.SC_NOT_FOUND, e.getMessage())
        }
    }


    void methodPostLoginSuccess(HttpServletResponse response, int candidatoId) {
        try {
            writeResponse(response)
            response.setStatus(HttpServletResponse.SC_OK)

            try (PrintWriter out = response.getWriter()) {
                out.print(candidatoId)
            }
        } catch (Exception e) {
            this.writeErrorResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage())
        }
    }

    void methodPut(HttpServletResponse response, Runnable operation) {
        try {
            writeResponse(response)
            operation.run()
            response.setStatus(HttpServletResponse.SC_OK)
        } catch (Exception e) {
            this.writeErrorResponse(response, HttpServletResponse.SC_NOT_FOUND, e.getMessage())
        }
    }

    void methodDelete(HttpServletResponse response, Runnable operation){
        try{
            operation.run()
            response.setStatus(HttpServletResponse.SC_NO_CONTENT)
        } catch (Exception e) {
            this.writeErrorResponse(response, HttpServletResponse.SC_NOT_FOUND, e.getMessage())
        }
    }
}

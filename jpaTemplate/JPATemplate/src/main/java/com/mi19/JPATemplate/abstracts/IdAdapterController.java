package com.mi19.JPATemplate.abstracts;

import com.mi19.JPATemplate.embeddable.BiId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class IdAdapterController {

    @RequestMapping(path = "/api/{path}/{id}")
    public void idSimple(HttpServletRequest request, HttpServletResponse response, @PathVariable String path, @PathVariable Object id ) throws ServletException, IOException {
        request.setAttribute("id", id);
        request.getRequestDispatcher("/api/"+path).forward(request,response);
    }
    @RequestMapping(path = "/api/{path}/{firstId}/{secondId}")
    public void idDouble(HttpServletRequest request, HttpServletResponse response, @PathVariable String path, @PathVariable Object firstId, @PathVariable Object secondId ) throws ServletException, IOException {
        request.setAttribute("id", new BiId<Object,Object>(firstId,secondId));
        request.getRequestDispatcher("/api/"+path).forward(request,response);
    }
    @RequestMapping(path = "/api/{path}/from/{parentId}")
    public void parentIdSimple(HttpServletRequest request, HttpServletResponse response, @PathVariable String path,@PathVariable Object parentId ) throws ServletException, IOException {
        request.setAttribute("parent_id", parentId);
        request.getRequestDispatcher("/api/"+path+"/from").forward(request,response);
    }
    @RequestMapping(path = "/api/{path}/from/{firstId}/{secondId}")
    public void parentIdDouble(HttpServletRequest request, HttpServletResponse response, @PathVariable String path, @PathVariable Object firstId, @PathVariable Object secondId ) throws ServletException, IOException {
        request.setAttribute("parent_id", new BiId<Object,Object>(firstId,secondId));
        request.getRequestDispatcher("/api/"+path+"/from").forward(request,response);
    }
}

package com.express.servlet;

import com.express.bean.Place;
import com.express.bean.Send;
import com.express.dao.PlaceDao;
import com.express.dao.SendDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by tong on 17-4-6.
 */
@WebServlet(name = "SelectPlaceUserServlet",urlPatterns = "/SelectPlaceUserServlet")
public class SelectPlaceUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int userId = Integer.parseInt(request.getParameter("userId"));

        PlaceDao dao = new PlaceDao();
        List<Place> list = dao.selectUserPlace(userId);
        JSONArray jsonArray = JSONArray.fromObject(list);
        out.print(jsonArray.toString());

        out.flush();
        out.close();
    }
}

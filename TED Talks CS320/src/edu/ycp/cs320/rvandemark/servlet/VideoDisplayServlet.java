package edu.ycp.cs320.rvandemark.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.rvandemark.model.Engine;
import edu.ycp.cs320.rvandemark.model.Video;

public class VideoDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("/_view/videoDisplay.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Engine.setVideo(new Video (
			"https://www.ted.com/talks/ashton_cofer_a_young_inventor_s_plan_to_recycle_styrofoam",
			2.6666666666666666666666666666
		));
		
		req.setAttribute("video", Engine.getVideo());
		req.getRequestDispatcher("/_view/videoDisplay.jsp").forward(req, resp);
	}
}

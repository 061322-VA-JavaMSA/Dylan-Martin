package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.ReimbursementDto;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.ReimbursementNotCreatedException;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import com.revature.util.CorsFix;

/*- 
 * Handles all of the requests made to /users(/...)
 */
public class ReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
	private ReimbursementService rs = new ReimbursementService();
	// object to convert to JSON format
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Specifying that the response content-type will be JSON
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		String pathInfo = req.getPathInfo();

		// if pathInfo is null, the req should be to /users -> send back all users
		if (pathInfo == null) {
			HttpSession session = req.getSession();

			if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals(Role.ADMIN)) {
				// retrieving users from db using UserService
				List<Reimbursement> reimbursements = rs.getReimbursements();
				List<ReimbursementDto> reimbursementsDto = new ArrayList<>();

				// converting Users to UserDTOs for data transfer
				reimbursements.forEach(u -> reimbursementsDto.add(new ReimbursementDto(u)));

				// retrieving print writer to write to the Response body
				PrintWriter pw = res.getWriter();
				// writing toString representation of Users to body
				pw.write(om.writeValueAsString(reimbursementsDto));

				pw.close();
			} else {
				// if the user making the request is not an admin
				res.sendError(401, "Unauthorized request.");
			}
		}
		// get all reimbursements where reimb_status = accepted
		String reimb_status = req.getParameter("reimb_status");
		if (reimb_status != null) {
			List<Reimbursement> reimbursement = null;
			try {
				reimbursement = rs.getReimbursementsByStatus(reimb_status);
			} catch (ReimbursementNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<ReimbursementDto> reimbursementsDto = new ArrayList<>();

			// converting Users to UserDTOs for data transfer
			reimbursement.forEach(r -> reimbursementsDto.add(new ReimbursementDto(r)));

			// retrieving print writer to write to the Response body
			PrintWriter pw = res.getWriter();
			// writing toString representation of Users to body
			pw.write(om.writeValueAsString(reimbursementsDto));

			pw.close();
		}
		
//		try {
//			String cookie = res.getHeader("Set-cookie")+";SameSite=None; Secure";
//			res.setHeader("Set-Cookie", cookie);
//			
//			List<Reimbursement> reimbursement = rs.getReimbursementsByStatus();
//			
//			try (PrintWriter pw = res.getWriter()){
//				pw.write(om.writeValueAsString(reimbursement));
//				res.setStatus(200);
//			}
//		}catch (ReimbursementNotFoundException e) {
//			res.sendError(400, "No Accepted requests.");
//			e.printStackTrace();
//		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		InputStream reqBody = req.getInputStream();

		Reimbursement newReimbursement = om.readValue(reqBody, Reimbursement.class);
		newReimbursement.setSubmitted(new Date());

		try {
			rs.createReimbursement(newReimbursement);

			res.setStatus(201); // Status: Created
		} catch (ReimbursementNotCreatedException e) {
//			res.setStatus(400);
			res.sendError(400, "Unable to create new user.");
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Specifying that the response content-type will be JSON
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		int rid = Integer.parseInt(req.getParameter("reimb_id"));
		String pathInfo = req.getPathInfo();

		// if pathInfo is null, the req should be to /users -> send back all users
		if (pathInfo == null) {
			HttpSession session = req.getSession();

			if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals(Role.ADMIN)) {
				try {
					int id = (int) session.getAttribute("userId");

					User u;
					Reimbursement r = rs.getReimbursementById(rid);
					r.setReimb_status("Accepted");
					r.setResolved(new Date());
					u = us.getUserById(id);
					r.setResolver_id(u);
					rs.updateReimbursement(r);
					res.setStatus(200);
				} catch (ReimbursementNotFoundException | UserNotFoundException e) {
					res.sendError(400, "Unable to update reimbursement status.");
					e.printStackTrace();
				}

			} else {
				// if the user making the request is not an admin
				res.sendError(401, "Unauthorized request.");
			}
		} else {
			// /1, /11, /{some-value}
			// Have to remove "/" to get the id to be retrieved
			int id = Integer.parseInt(pathInfo.substring(1));

			try (PrintWriter pw = res.getWriter()) {
				// retrieve user by id
				User u = us.getUserById(id);
				UserDTO uDTO = new UserDTO(u);

				// convert user to JSON and write to response body
				pw.write(om.writeValueAsString(uDTO));

				res.setStatus(200);
			} catch (UserNotFoundException e) {
				// return 404, user not found
				res.setStatus(404);
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Specifying that the response content-type will be JSON
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		int rid = Integer.parseInt(req.getParameter("reimb_id"));
		String pathInfo = req.getPathInfo();

		// if pathInfo is null, the req should be to /users -> send back all users
		if (pathInfo == null) {
			HttpSession session = req.getSession();

			if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals(Role.ADMIN)) {
				try {
					int id = (int) session.getAttribute("userId");

					User u;
					Reimbursement r = rs.getReimbursementById(rid);
					r.setReimb_status("Deleted");
					r.setResolved(new Date());
					u = us.getUserById(id);
					r.setResolver_id(u);
					rs.updateReimbursement(r);
					res.setStatus(200);
				} catch (ReimbursementNotFoundException e) {
					res.sendError(400, "Unable to update reimbursement status.");
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
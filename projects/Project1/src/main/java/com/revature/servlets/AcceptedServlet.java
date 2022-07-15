package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.ReimbursementDto;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.services.ReimbursementService;
import com.revature.util.CorsFix;

/*- 
 * Handles all of the requests made to /users(/...)
 */
public class AcceptedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private UserService us = new UserService();
	private ReimbursementService rs = new ReimbursementService();
	// object to convert to JSON format
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//select * from reimbursements where reimb_status = 'Accepted';
        // Specifying that the response content-type will be JSON
        CorsFix.addCorsHeader(req.getRequestURI(), res);
        res.addHeader("Content-Type", "application/json");
        String pathInfo = req.getPathInfo();

        // if pathInfo is null, the req should be to /users -> send back all users

        if (pathInfo == null) {
            HttpSession session = req.getSession();

            if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals(Role.ADMIN)) {
                // retrieving users from db using UserService
                List<Reimbursement> reimbursements = null;
				try {
					reimbursements = rs.getReimbursementsByStatus("Accepted");
				} catch (ReimbursementNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                List<ReimbursementDto> reimbursementsDto = new ArrayList<>();

                // converting Users to UserDTOs for data transfer
                reimbursements.forEach(u -> reimbursementsDto.add(new ReimbursementDto(u)));

                // retrieving print writer to write to the Response body
                PrintWriter pw = res.getWriter();
                pw.write(om.writeValueAsString(reimbursementsDto));
            }
        }
    }
}
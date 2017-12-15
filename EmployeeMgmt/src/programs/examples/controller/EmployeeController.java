package programs.examples.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

import programs.examples.model.Employee;

@Path("/employee")
public class EmployeeController 
{
	
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addEmployee(String input) throws JSONException {
		
		return "student successfully added .. !!!";
	}

	@Produces(MediaType.TEXT_PLAIN)
	@GET
	@Path("/{id}")
	public String getEmployeeByID(@PathParam("id") String id) throws JSONException {
		System.out.println("request for student "+id);
		
		return null;
	}
	
}
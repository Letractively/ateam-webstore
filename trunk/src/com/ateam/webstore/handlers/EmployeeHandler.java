package com.ateam.webstore.handlers;

import java.sql.Date;
import java.util.Collection;
import java.util.Random;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Employee;
import com.ateam.webstore.model.EmployeeRoles;
import com.ateam.webstore.model.Role;
import com.ateam.webstore.service.impl.EmployeeRolesService;
import com.ateam.webstore.service.impl.EmployeeService;
import com.ateam.webstore.service.impl.RoleService;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.forms.LoginForm;
import com.ateam.webstore.ui.forms.RegistrationForm;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.AdminEmployeeDetailsView;
import com.ateam.webstore.ui.views.AdminEmployeeListView;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.RegistrationView;
import com.ateam.webstore.ui.views.View;
import com.ateam.webstore.utilities.Utilities;

public class EmployeeHandler extends Handler {
    EmployeeService service;



     public EmployeeHandler(HttpServletRequest req) {
                super(req);
                service=new EmployeeService();
        }
       
   

/**
         * Get the login view
         * @param loginMessage
         * @return
         */
        public View getLoginView(String loginMessage) {
               
                return getLoginView(loginMessage, getMainAdminView());
               
        }


/**
         * Gets a Employee from DB
         * @param id
         * @return
         */

        public Employee getEmployee() {
        	String eid =req.getParameter(Parameters.EMPLOYEE.getId());

           return service.getById(Long.parseLong(eid));
        }


       
/**
         * Get the view for a specific Employee
         * @param req
         * @return
         */
        public AdminEmployeeDetailsView getEmployeeDetailsView() {
               
            AdminEmployeeDetailsView ev = new AdminEmployeeDetailsView(getMainAdminView());
            
            Employee e = getEmployee();
               
                if (e != null) {
		            ev.setEmployee(e);
		            ev.addContentView(new ContentView(JSP_EMPLOYEE_DETAILS, "Employee "+e.getId()));
                }
                else {
                        ev.addContentView(new ContentView(JSP_MESSAGE, "Not Found"));
                        ev.setMessage("Sorry, employee not found.");
                }
                
                Collection<EmployeeRoles> roles = e.getRoles();
                for (EmployeeRoles role : roles) {
                	ev.addRole(role.getRole().getDescription());
                }
               
                return ev;
        }
       

/**
         * Builds a returns the view for a list of all employees
     * @param admin True for the admin context
         * @return
         */

        public AdminEmployeeListView getAllView() {
               
                AdminEmployeeListView ep = new AdminEmployeeListView (getMainAdminView());
               
                ep.setEmployees(service.getAll());
               
                ContentView cv = new ContentView(JSP_EMPLOYEE_LIST, "All Employees");
                
                ep.addContentView(cv);

                return ep;
               

        }

    	/**
    	 * Builds a LoginForm from the request
    	 * @param req
    	 * @return
    	 */
    	public LoginForm getLoginRequest() {
    		
    		l.info("Parsing Login Request from session "+req.getSession().getId());
    		
    		LoginForm login = new LoginForm();
    		Visitor v = new Visitor();
    		v.setEmail(req.getParameter(Parameters.EMAIL.getId()));
    		login.setVisitor(v);
    		login.setPassword(req.getParameter(Parameters.PASSWORD.getId()));
    		
    		req.getSession().setAttribute(SESSION_ATTRIBUTE_VISITOR, v);
    		login.setVisitor(v);
    		login.setForm(FormName.LOGIN);
    		login.setRedirect(req.getParameter(Parameters.REDIRECT.getId()));
    		
    		return login;
    	}

        /**
         * Process a login request
         * @param login
         * @param req
         * @return
         */

   
        public FormSubmission processLoginRequest() {
               
                LoginForm login = (LoginForm) getLoginRequest();
               
                l.info("Processing Login Request from session "+req.getSession().getId());
              
                Visitor v = login.getVistor();
                Employee emp = null;
                View resultView = null;
               
                try {
                        emp= service.authenticateEmployee(login.getVistor().getEmail(), login.getPassword());
                        if (emp!= null) {
                                l.info("Login Successful for "+login.getVistor().getEmail());

                                v.setEmployeeAuthenticated(true);
                                v.setEmployee(emp);
                                v.setKnown(true);
                               
                                req.getSession().setAttribute(SESSION_ATTRIBUTE_VISITOR,v);
                                login.setForm(FormName.LOGIN);
                                login.setSuccess(true);

                        }
                        else {
                                resultView = getLoginView("Invalid email or password. Please try again.", getMainAdminView());
                        }
                       
                } catch (Exception e) {
                        l.log(Level.INFO, "Failed authentication", e);
                        resultView = getLoginView("Invalid email or password. Please try again.", getMainAdminView());
                }

                if (v.isEmployeeAuthenticated()) try {
                       
                        if (login.getRedirect() != null) {
                                resultView = new View();
                                resultView.setRedirectPath(login.getRedirect());
                        }
                        else {
                                resultView = getAdminHomeView();
                        }

                } catch (Exception e) {
                        l.log(Level.INFO, "", e);                      
                }
               
                login.setResultView(resultView);
               
                l.info("Login results:"+v);
                
                try {
                    String roleNames = "";
                    Collection<EmployeeRoles> roles = emp.getRoles();
                    for (EmployeeRoles role : roles) {
                    	//roleNames += role.getId();
                    	roleNames += role.getRole().getDescription();
                    }
                   
                    l.info("employee roles:"+roleNames);
                	
                }
                catch (Exception e) {
                	l.log(Level.WARNING, "", e);
                }
                
                return login;
        }
       

       
        public FormSubmission processAddEmployeeRequest() {
                  
                l.info("Processing registration request from session "+req.getSession().getId());
               
                RegistrationForm add = getRegistrationRequest();
               
                if (!add.isValid()) {
                	l.info("registration form error in session "+req.getSession().getId());
                	add.setResultView(getAdminAddEmployeeView(null));	
                }
                else if (service.employeeExists(add.getEmail())) {
                		l.info("employee exists "+req.getSession().getId());
                        add.setResultView(getAdminAddEmployeeView("An account for"+add.getEmail()+" already exists"));
                }
                else {
                	
                	l.info("registration form check OK "+req.getSession().getId());
                    View rv = new View(getAdminHomeView());
                    Employee e = null;
                    try {
                    		String ssn = Utilities.padStringToLength(Math.abs(new Random().nextInt())+"", "0", 9, false);
                    		e = service.registerEmployee(add.getFirstName(), add.getLastName(), add.getEmail(), add.getPw(), new Long(1), "foo", ssn, "Employee", new Date(new java.util.Date().getTime()), "A1", new Double(100000));
                    		RoleService rs = new RoleService();
                    		Role role = rs.getById(new Integer(add.getRoleId()));
                    		EmployeeRoles er = new EmployeeRoles(new Date(new java.util.Date().getTime()), e, role);
                    		EmployeeRolesService ers = new EmployeeRolesService();
                    		ers.store(er);
                            rv.setMessage("Employee addition Complete");
                            add.setResultMessage("Employee successfull added");
                    } catch (Exception e1) {
                    	if (e != null) {
                    		service.remove(e);
                    	}
                        l.log(Level.WARNING, "", e1);
                        rv.setError(true);
                        rv = getAdminAddEmployeeView("An error occured.");
                        add.setResultMessage("Unable to process request");
                    }

                    add.setResultView(rv);                 
                }
               
                return add;
        }



		public RegistrationView getAdminAddEmployeeView(String string) {
			
			RegistrationView aeav = new RegistrationView(getMainAdminView());
			
			aeav.addContentView(new ContentView(JSP_REGISTRATION, "New Employee"));
			
			aeav.setAdmin(true);
			
			RoleService rs = new RoleService();
			aeav.setRoles(rs.getAll());
			
			return aeav;
		}

		public AdminEmployeeListView getEmployeeListView() {
			
			AdminEmployeeListView aempl = new AdminEmployeeListView(getMainAdminView());
			
			aempl.setEmployees(service.getAll());
			
			aempl.addContentView(new ContentView(JSP_EMPLOYEE_LIST, "All Employees"));

			return aempl;
		}
		
		private RegistrationForm getRegistrationRequest() {
			l.info("Parsing Registration Request from session "+req.getSession().getId());
			
			RegistrationForm reg = new RegistrationForm();

			reg.setFirstName(req.getParameter(Parameters.FIRST_NAME.getId()));
			reg.setLastName(req.getParameter(Parameters.LAST_NAME.getId()));
			reg.setEmail(req.getParameter(Parameters.EMAIL.getId()));
			reg.setPw(req.getParameter(Parameters.PASSWORD.getId()));
			reg.setCpw(req.getParameter(Parameters.CONFIRMPASSWORD.getId()));
			reg.setRoleId(req.getParameter(Parameters.ROLE.getId()));
			reg.setForm(FormName.REGISTER);
			reg.setAdmin(true);
			
			return reg;
		}



		public View getLogoutView() {
			View v = new View (getLoginView("You are now logged out"));
			
			req.getSession().invalidate();
			
			return v;
		}



		public FormSubmission processDeleteEmployeeRequest() {
			
			FormSubmission fs = new FormSubmission();
			
			fs.setResultView(getEmployeeListView());
			try { 
				Employee e = getEmployee();
				service.remove(e);
				fs.setResultMessage("Employee deleted");
			} catch (Exception e) {
				fs.setResultMessage("Failed to delete employee");
				l.log(Level.WARNING, "Failed to delete eomplyee", e);
			}
			
			return fs;
			
		}
       

     }
package com.ateam.webstore.handlers;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Employee;
import com.ateam.webstore.service.impl.EmployeeService;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.views.AdminEmployeeDetailsView;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.View;

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

        public Employee getEmployee(String id) {

                return (Employee) service.getById(Long.parseLong(id));
        }


       
/**
         * Get the view for a specific Employee
         * @param req
         * @return
         */
        public AdminEmployeeDetailsView getEmployeeDetailsView(Employee e) {
               
                if (e == null) {
                        e = getEmployee(req.getParameter(Parameters.EMPLOYEE.getId()));
                }
               
                View main = null;
                String jsp = null;
                              
                else {
                        main = getMainView();
                        jsp = JSP_EMPLOYEE_DETAILS;
                }
               
                AdminEmployeeDetailsView ev = new AdminEmployeeDetailsView(main);
               
                if (e != null) {
                        e.setEmployee(e);
                        e.addContentView(new ContentView(jsp, e.getEmployeeName()));
                }
                else {
                        e.addContentView(new ContentView(JSP_MESSAGE, "Not Found"));
                        e.setMessage("Sorry, employee not found.");
                }
               
                return e;
        }
       

/**
         * Builds a returns the view for a list of all employees
     * @param admin True for the admin context
         * @return
         */

        public AdminEmployeeListView getAllView(boolean admin) {
               
                View main = null;
               
                if (admin) {
                        main = getMainAdminView();
                } else {
                        main = getMainView();
                }
               
                AdminEmployeeListView ep = new AdminEmployeeListView (main);
               
                ep.setEmployees(getAllemployees());
               
                String jsp = JSP_EMPLOYEE_LIST;
                if (admin) {
                        jsp = JSP_ADMIN_EMPLOYEE_LIST;
                }
                ContentView cv = new ContentView(jsp, "All employees");
               
                ep.getContentViews().add(cv);

                return ep;
               

        }



/**
         * Process a login request
         * @param login
         * @param req
         * @return
         */

    public FormSubmission processLoginRequest() {
        public FormSubmission processLoginRequest() {
               
                LoginForm login = getLoginRequest();
               
                l.info("Processing Login Request from session "+req.getSession().getId());
                Employee E = login.getEmployee();
               
                Employee emp = null;
                View resultView = null;
               
                try {
                        emp= service.authenticateEmployee(req.getParameter(Parameters.EMAIL.getId()), req.getParameter(Parameters.PASSWORD.getId()));
                        if (emp!= null) {
                                l.info("Login Successful for "+cust.getPerson().getLogin());
                                E.setEmployee(emp);
                                E.setAuthenticated(true);
                                E.setKnown(true);
                                E.setEmail(req.getParameter(Parameters.EMAIL.getId()));
                               
                                req.getSession().setAttribute(SESSION_ATTRIBUTE_EMPLOYEE,E);
                                login.setForm(FormName.LOGIN);
                                login.setSuccess(true);

                        }
                        else {
                                resultView = getLoginView("Invalid email or password. Please try again.", getMainView());
                        }
                       
                } catch (Exception e) {
                        l.log(Level.INFO, "Failed authentication", e);
                        resultView = getLoginView("Invalid email or password. Please try again.", getMainView());
                }

                if (E.isAuthenticated()) try {
                        CartService cs = new CartService();
                        l.info("retrieving cart for employeeId:"+emp.getId());
                        req.getSession().setAttribute(SESSION_ATTRIBUTE_CART, cs.getByEmployeeId(emp.getId()));
                       
                        if (login.getRedirect() != null) {
                                resultView = new View();
                                resultView.setRedirectPath(login.getRedirect());
                        }
                        else {
                                //Build view
                                ProductHandler ph = new ProductHandler(req);
                                resultView = ph.getHomePageView();
                        }

                } catch (Exception e) {
                        l.log(Level.INFO, "", e);                      
                }
               
                login.setResultView(resultView);
               
                l.info("Login results:"+v);
               
                return login;
        }
       

       
        public FormSubmission processAddEmployeeRequest() {
                  
                l.info("Processing registration request from session "+req.getSession().getId());
               
                AdminAddEmployeeForm add= getAdminAddEmployeeRequest();
               
                if (!add.isValid()) {
                        add.setResultView(getAdminAddEmployeeView(add));
                }
                else if (service.employeeExists(add.getEmail())) {
                        add.setResultView(getAdminAddEmployeeView("An account for"+add.getEmail()+" already exists"));
                }
                else {
                        View rv = new View(getMainView());
                       
                        rv.addContentView(new ContentView(JSP_LOGIN, "Login"));
                       
                        try {
                                service.addemployee(add.getFirstName(), add.getLastName(), add.getEmail(), add.getPw(), add.getSecurityQuestionIdLong(), add.getSecurityAnswer());
                                rv.setMessage("Employee addition Complete");
                        } catch (Exception e) {
                                l.log(Level.WARNING, "", e);
                                rv.setError(true);
                                //rv.setMessage("Failed!! "+e.getMessage());
                                add.setResultView(getRegistrationView("An error occured."));
                        }

                        add.setResultView(rv);                 
                }
               
                return add;
        }
       

     }
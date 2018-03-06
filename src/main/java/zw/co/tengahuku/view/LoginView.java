package zw.co.tengahuku.view;

import java.io.Serializable;
import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import zw.co.tengahuku.exception.ApplicationException;

@Scope(value = "session")
@Component(value = "loginView")
@ELBeanName(value = "loginView")
@Join(path = "/login", to = "/jsf/loginForm.jsf")
public class LoginView implements Serializable {

	@Autowired
	HttpServletRequest request;
	private Integer loginRefreshTimeout;
	
	
	 private FacesContext context;

	private String userName;
	private String userDescription;
	private String password;

	private String changePasswordNewPassword;
	private String changePasswordConfirmPassword;
	
	private static final Logger log = Logger.getLogger(LoginView.class);

	@SuppressWarnings("unused")
	private void initChangePasswordMembers() {
		changePasswordNewPassword = null;
		changePasswordConfirmPassword = null;
	}

	@PostConstruct
	public void init() {

		request.getSession().setMaxInactiveInterval(60000);

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChangePasswordNewPassword() {
		return changePasswordNewPassword;
	}

	public void setChangePasswordNewPassword(String changePasswordNewPassword) {
		this.changePasswordNewPassword = changePasswordNewPassword;
	}

	public String getChangePasswordConfirmPassword() {
		return changePasswordConfirmPassword;
	}

	public void setChangePasswordConfirmPassword(String changePasswordConfirmPassword) {
		this.changePasswordConfirmPassword = changePasswordConfirmPassword;
	}

	public Integer getLoginRefreshTimeout() {
		return loginRefreshTimeout;
	}

	public void setLoginRefreshTimeout(Integer loginRefreshTimeout) {
		this.loginRefreshTimeout = loginRefreshTimeout;
	}

	public boolean isLoggedIn() {
		return request.getUserPrincipal() != null;
	}

	/**
	 * Called by the login page before rendering, to check that we aren't
	 * already logged in. If we are logged in, don't render the login page,
	 * rather redirect to the main page.
	 */
	public void dontLoginIfAuthenticated() {
		Principal principal = request.getUserPrincipal();

		if (principal != null && !principal.getName().equals("anonymous")) { // Already
			// authenticated
			// navigationHandler.performNavigation("loggedIn");
			// TODO: So go to app
		}
	}

	public void handleSelectUserType() {
		userName = null;
		password = null;
	}

	public String login() {
		String outcome = null;

		try {
			if (!isLoggedIn()) {
				if (StringUtils.isBlank(userName)) {
					throw new ServletException("Username is required!");
				} else if (StringUtils.isBlank(password)) {
					throw new ServletException("Password is required!");
				}
				userName = userName.toUpperCase();
				String passwordDigest = password;

				request.login(userName, passwordDigest);

			//TODO: Login into the app

				if (outcome == null) {
					outcome = "loggedIn";
				}

			}
		} catch (ServletException servletException) {
			String growlMessage = servletException.getMessage();
			log.error(growlMessage, servletException);

			if (isLoggedIn()) {
				logout();
			}

			if (growlMessage.toLowerCase().contains("principal")) {
				growlMessage = "Your username and password combination could not be verified.";

			}

			// Failed to authenticate with AD
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed", growlMessage));
		} catch ( ApplicationException ejbException) {
			
			if (isLoggedIn()) {
				logout();
			}

			if (ejbException.getCause() instanceof Exception) {
				log.error(ejbException.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed",
						"You do not have sufficient permissions to log in to selected Business Area"));
			} else {
				log.error("Error occurred while trying to log in", ejbException);
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed", ejbException.getMessage()));
			}
		} catch (Exception e) {
			log.error("Error occurred while trying to log in", e);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed", e.getMessage()));
		}

		if (outcome != null && outcome.equals("changePassword")) {
			outcome = null;
		}

		return outcome;
	}
	
	 public void logout() {
	        try {
	            context.getExternalContext().invalidateSession();
	            request.logout();
	        } catch (Exception e) {
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Logout Failed.", e.getMessage()));
	            log.error("Error occurred while trying to log out", e);
	        }
	    }

}

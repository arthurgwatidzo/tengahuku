package zw.co.tengahuku.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;


import javax.servlet.http.HttpServletRequest;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "loginView")
@ELBeanName(value = "loginView")
@Join(path = "/login", to = "/jsf/loginForm.jsf")
public class LoginView implements Serializable{
	
	@Autowired 
	HttpServletRequest request;
	 private Integer loginRefreshTimeout;
	 
	 private String userName;
	    private String userDescription;
	    private String password;

	    private String changePasswordNewPassword;
	    private String changePasswordConfirmPassword;
	    
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

}

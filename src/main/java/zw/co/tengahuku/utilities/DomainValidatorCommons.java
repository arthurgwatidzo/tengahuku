package zw.co.tengahuku.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class DomainValidatorCommons {
	  @Autowired
	    @Qualifier("localValidatorFactoryBean")
	    private LocalValidatorFactoryBean validator;

	    public DomainValidatorCommons() {
	    }

	    public BeanPropertyBindingResult validateFields(Object target, String objectName, Class... groups) {
	        BeanPropertyBindingResult result = new BeanPropertyBindingResult(target, objectName);
	        this.validator.validate(target, result, groups);
	        return result;
	    }

	    public boolean validateBusinessObject(BaseEntity idEntity) {
	        return idEntity != null && idEntity.getId() != null;
	    }

	    public ObjectError createObjectError(String name, String defaultMessage, String[] codes, String[] args) {
	        return new ObjectError(name, codes, args, defaultMessage);
	    }

	    public ObjectError createObjectError(String name, String defaultMessage, String[] codes) {
	        return new ObjectError(name, codes, new String[]{""}, defaultMessage);
	    }

}

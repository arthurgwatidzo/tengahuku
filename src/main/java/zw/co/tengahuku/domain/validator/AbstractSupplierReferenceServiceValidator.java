package zw.co.tengahuku.domain.validator;

import org.springframework.validation.annotation.Validated;

import zw.co.tengahuku.model.Supplier;

@Validated
public abstract class AbstractSupplierReferenceServiceValidator {
	
	abstract Supplier createSupper(Supplier supplier);

}

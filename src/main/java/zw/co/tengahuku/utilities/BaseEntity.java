package zw.co.tengahuku.utilities;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

@MappedSuperclass
@FilterDefs({@FilterDef(
    name = "product",
    defaultCondition = ":product = product",
    parameters = {@ParamDef(
    name = "product",
    type = "integer"
)}
), @FilterDef(
    name = "productPostgres",
    defaultCondition = ":product = \"product\"",
    parameters = {@ParamDef(
    name = "product",
    type = "integer"
)}
)})
@Filters({@Filter(
    name = "product"
), @Filter(
    name = "productPostgres"
)})
@EntityListeners({BaseEntityListener.class})
public abstract class BaseEntity implements  Serializable, ToStringResolver, EntityInterface {
    protected Long id;
    private String uuid;
    private Integer product;
    private Integer optLock = Integer.valueOf(0);
    private String auditTransactionId;
    private String auditUserId;
    private boolean updateValuesSet;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(
        generator = "ID_SEQUENCE",
        strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
        name = "ID_SEQUENCE",
        allocationSize = 25,
        initialValue = 100000,
        sequenceName = "ID_SEQUENCE"
    )
    @Column(
        name = "ID"
    )
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(
        name = "UUID",
        length = 100,
        nullable = false
    )
    @NotNull(
        message = "\"The Uuid field cannot be null.\""
    )
    public String getUuid() {
        if (this.uuid == null || "".equals(this.uuid)) {
            this.uuid = (new UUID(ThreadLocalRandom.current().nextLong(), ThreadLocalRandom.current().nextLong())).toString();
        }

        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Column(
        name = "product",
        nullable = false
    )
    @NotNull(
        message = "\"The product field cannot be null.\""
    )
    public Integer getproduct() {
        return this.product;
    }

    public void setproduct(Integer product) {
        this.product = product;
    }

    @NotNull
    @Column(
        name = "OPT_LOCK",
        nullable = false
    )
    @Version
    public Integer getOptLock() {
        return this.optLock;
    }

    public void setOptLock(Integer optLock) {
        this.optLock = optLock;
    }

    @Column(
        name = "AUDIT_TRANSACTION_ID",
        length = 100
    )
    public String getAuditTransactionId() {
        return this.auditTransactionId;
    }

    public void setAuditTransactionId(String transationId) {
        this.auditTransactionId = transationId;
    }

    @Column(
        name = "AUDIT_USER_ID",
        length = 100
    )
    public String getAuditUserId() {
        return this.auditUserId;
    }

    public void setAuditUserId(String userId) {
        this.auditUserId = userId;
    }

    public String resolveShortDisplayName() {
        return this.getId() != null ? this.getId().toString() : "";
    }

    public String resolveListDisplayName() {
        return this.resolveShortDisplayName();
    }

    public String resolveLongDisplayName() {
        return this.resolveShortDisplayName();
    }

    @Transient
    public boolean isUpdateValuesSet() {
        return this.updateValuesSet;
    }

    public void setUpdateValuesSet(boolean updateValuesSet) {
        this.updateValuesSet = updateValuesSet;
    }

    public String resolveToString(Object... objects) {
        return this.resolveToStringMessage(new Object[]{"id", this.getId(), "product", this.getproduct(), "uuid", this.getUuid(), objects});
    }

   

    protected boolean canEqual(Object other) {
        return other instanceof BaseEntity;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditTransactionId == null) ? 0 : auditTransactionId.hashCode());
		result = prime * result + ((auditUserId == null) ? 0 : auditUserId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((optLock == null) ? 0 : optLock.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + (updateValuesSet ? 1231 : 1237);
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (auditTransactionId == null) {
			if (other.auditTransactionId != null)
				return false;
		} else if (!auditTransactionId.equals(other.auditTransactionId))
			return false;
		if (auditUserId == null) {
			if (other.auditUserId != null)
				return false;
		} else if (!auditUserId.equals(other.auditUserId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optLock == null) {
			if (other.optLock != null)
				return false;
		} else if (!optLock.equals(other.optLock))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (updateValuesSet != other.updateValuesSet)
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
    
    

}
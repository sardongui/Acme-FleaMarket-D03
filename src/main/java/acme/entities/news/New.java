
package acme.entities.news;

import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class New extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Atributes------------------------------------------

	@NotBlank
	private String				category;

	@NotBlank
	@URL
	private String				picture;

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotBlank
	private String				body;

	@ElementCollection(fetch = FetchType.EAGER)
	public Collection<String>	relatedNews;

	public boolean				confirmed;

}

package br.com.manzatech.RestAPI.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7176529291423909036L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotEmpty(message="Não pode ser vazio")
	@NotBlank(message="Não pode estar em branco")
	@Size(min=4, max=255)
	private String name;
	@Column
	@Min(0)
	@Max(1000)
	@NotNull
	private Integer quantity;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date createdAt;

	
	
	public Product() {
	}

	public Product(String name, Integer quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	@PrePersist
	public void onPrePersist() {
		if (createdAt != null) {
			createdAt = new Date();
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "{ id: " + this.id + ", name: " + this.name + ", quantity: " + this.quantity + ", createdAt: " + this.createdAt + " }" ;
	}
}

package tn.camps.tuncamps.persistence.entity.ecomerce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "allocationitem")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Allocationitem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public Date dateDebut;
	public Date dateFin;
	public double price;
	public int Quantity;

	@JsonIgnore
	@ManyToOne(optional = true)
	@JoinColumn(name = "allocation_id", nullable = true)
	private Allocation allocation;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Allocationitem other = (Allocationitem) obj;

		return id == other.id;
	}

}

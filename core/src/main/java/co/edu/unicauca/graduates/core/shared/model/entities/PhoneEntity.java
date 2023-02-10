package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Phones")
public class PhoneEntity{
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ph_id")
    private Integer id;
    
    @Column(name = "ph_type", nullable = false)
    private String type;
    
    @Column(name = "ph_number", nullable = false)
    private String number;



    @OneToOne(cascade = { CascadeType.ALL },fetch = FetchType.EAGER, mappedBy = "phone")
	private ReferedEntity refered; 
    
    @OneToOne(cascade = { CascadeType.ALL },fetch = FetchType.EAGER, mappedBy = "phone")
	private JobEntity job; 
}

package com.noteninja.backend.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "string_fret")
public class StringFret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fret_id")
    private Integer id;
    @Column(name = "string_number")
    private Integer stringNumber;
    @Column(name = "fret_number")
    private Integer fretNumber;
    @Column(name = "slide_to")
    private Integer slideTo;
    @Column(name = "hammer_to")
    private Integer hammerTo;
    @Column(name = "pull_off_to")
    private Integer pullOffTo;

    public String getstreFretName(){
        return "String: " + this.stringNumber.toString() + ", Fret: " + this.fretNumber.toString();
    }
}

package kz.springboot.springboot.finalTask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t-task_categories")
@Getter
@Setter
public class TaskCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "categories_name")
    private String name;
}

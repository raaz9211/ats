//package com.ai.ats.data;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.stereotype.Component;
//
//import jakarta.persistence.*;
//
//@Component
//@Entity
//@Table(name = "question_options")
//@Setter
//@Getter
//@ToString
//public class Option {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//    String value;
//    @Column(name = "is_answer")
//    boolean isAnswer;
//
//    @ManyToOne
//    User user;
//
//}

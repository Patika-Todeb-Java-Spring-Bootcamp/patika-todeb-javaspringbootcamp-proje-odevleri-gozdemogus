package com.patika.springbootcamp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.patika.springbootcamp.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class OrderDTO {

    private boolean finished;
    private boolean confirmed;
    private Long boughtProductId;

}
